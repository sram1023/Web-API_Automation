package utils;

import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static java.util.stream.Collectors.toMap;

@Slf4j
public class CommonUtil {

    Map<String, String> collect = null;
    String response;
    JSONObject postJsonObject;
    JSONObject jsonObject;

    public Map<String, String> restApiActions(String action) {
        return getInputData(action);
    }

    public void postAction(String action) {
        RestAssured.baseURI = collect.get("BaseURI");

        switch (action) {
            case "post":
                response =  given().spec(requestSpecification()).body(collect.get("Body")).
                        when().post(collect.get("Resource")).then().assertThat().
                        statusCode(Integer.parseInt(collect.get("StatusCode"))).log().all()
                        .extract().response().asString();
                log.info("Post Response==============" + response);
                break;
            case "get":
                response =  given().spec(requestSpecification()).queryParam(collect.get("QueryParamPlaceId"), placeIdValue()).
                        when().get(collect.get("Resource")).then().assertThat().
                        statusCode(Integer.parseInt(collect.get("StatusCode"))).log().all()
                        .extract().response().asString();
                break;
            case "update":
                response =  given().spec(requestSpecification()).body(collect.get("Body").replace("dynamicPlaceId", placeIdValue())).
                        when().put(collect.get("Resource")).then().assertThat().
                        statusCode(Integer.parseInt(collect.get("StatusCode"))).log().all()
                        .extract().response().asString();

                break;
            case "delete":
                response =  given().spec(requestSpecification()).body(collect.get("Body").replace("dynamicPlaceId", placeIdValue())).
                        when().delete(collect.get("Resource")).then().assertThat().
                        statusCode(Integer.parseInt(collect.get("StatusCode"))).log().all()
                        .extract().response().asString();
                break;
            default:
                throw new IllegalArgumentException("Actions are not matched");
        }

    }

    public String placeIdValue() {
        return postJsonObject.getString("place_id");
    }

    public void validateStatus(String expected) {
        try {
            postJsonObject = new JSONObject(response);
            Assert.assertEquals(expected, postJsonObject.getString("status"));
        } catch (JSONException err) {
            err.printStackTrace();
        }

    }

    public void validateUpdateStatus(String expected) {
        try {
            jsonObject = new JSONObject(response);
            Assert.assertEquals(expected, jsonObject.getString("msg"));
        } catch (JSONException err) {
            err.printStackTrace();
        }

    }

    public void validateGetServiceResponse(String expected) {
        try {
            jsonObject = new JSONObject(response);
            Assert.assertEquals(expected, jsonObject.getString("address"));
        } catch (JSONException err) {
            err.printStackTrace();
        }
    }

    public Map<String, String> getInputData(String action) {
        List<String> inputData = new ArrayList<>();
        Gson gson = new Gson();
        try (Reader reader = new FileReader("input.json")) {
            Map<String, List<String>> strJson = gson.fromJson(reader, Map.class);
            for (Map.Entry<String, List<String>> entry : strJson.entrySet()) {
                if (entry.getKey().toLowerCase().equals(action.toLowerCase())) {
                    inputData = entry.getValue();
                    break;
                }
            }
            collect = inputData.stream().map(str -> str.split("=")).
                    collect(toMap(str -> str[0], str -> str[1]));

        } catch (IOException e) {
            e.getMessage();
        }
        return collect;
    }

    private RequestSpecification requestSpecification(){
        RequestSpecification requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(collect.get("BaseURI"))
                .addQueryParam(collect.get("QueryParamKey"), collect.get("QueryParamValue")).
                        addHeader(collect.get("HeaderKey"), collect.get("HeaderValue")).build();
        return requestSpec;
    }
}
