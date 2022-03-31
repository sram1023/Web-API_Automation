package com.utility;

import org.junit.Assert;
import pojo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.AssertionFailedError;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static java.util.stream.Collectors.toMap;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

@Slf4j
public class WebServiceUtil {

    Map<String, String> collect = null;
    Response response;
    JSONObject postJsonObject;
    JSONObject jsonObject;
    PostResponse postResponse;
    PutResponse putResponse;
    DeleteResponse deleteResponse;
    String action = "";
    ObjectMapper objectMapper = new ObjectMapper();

    public static void baseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    public Map<String, String> restApiActions(String action) {
        return getInputData(action);
    }

    public void getApiURI(){
        baseURI("https://reqres.in");
    }

    public void getApiResponse(){
        response = given().
                when().get("/api/users?page=2").then().assertThat().
                body(matchesJsonSchema(new File("src\\test\\resources\\schema\\responsePayload.json")))
                .log().all()
                .extract().response();
    }

    public void restActions(String action) {

        baseURI(collect.get("BaseURI"));

        switch (action) {
            case "post":

                response = given().spec(requestSpecification()).body(setPostBody()).
                        when().post(collect.get("Resource")).then().assertThat().
                        statusCode(Integer.parseInt(collect.get("StatusCode"))).log().all()
                        .extract().response();
                System.out.println("Post Response==============" + response.asString());
                break;
            case "get":
                response = given().spec(requestSpecification()).queryParam(collect.get("QueryParamPlaceId"), placeIdValue()).
                        when().get(collect.get("Resource")).then().assertThat().
                        statusCode(Integer.parseInt(collect.get("StatusCode"))).log().all()
                        .extract().response();
                break;
            case "update":
                response = given().spec(requestSpecification()).body(setPutBody()).
                        when().put(collect.get("Resource")).then().assertThat().
                        statusCode(Integer.parseInt(collect.get("StatusCode"))).log().all()
                        .extract().response();

                break;
            case "delete":
                response = given().spec(requestSpecification()).body(setDeleteBody()).
                        when().delete(collect.get("Resource")).then().assertThat().
                        statusCode(Integer.parseInt(collect.get("StatusCode"))).log().all()
                        .extract().response();
                break;
            default:
                throw new IllegalArgumentException("Actions are not matched");
        }

    }

    private Post setPostBody() {
        Post post = new Post();
        List<String> types = new ArrayList<>();
        types.add("shoe park");
        types.add("shop");
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        post.setLocation(location);
        post.setAccuracy(50);
        post.setName("Frontline houses");
        post.setPhone_number("+919830000000");
        post.setAddress("45 Tweedy Road");
        post.setTypes(types);
        post.setWebsite("http://google.com");
        post.setLanguage("French-IN");
        return post;
    }

    private Put setPutBody() {
        Put put = new Put();
        put.setName("Queen Palace");
        put.setAddress("76 college road");
        put.setKey(collect.get("QueryParamValue"));
        put.setPlace_id(placeIdValue());
        return put;
    }

    private Delete setDeleteBody(){
        Delete delete = new Delete();
        delete.setPlace_id(placeIdValue());
        return delete;
    }

    public String placeIdValue() {
        return postResponse.getPlace_id();

    }

    /**
     * we can deserialize the response with the help of getBody().as() method
     *
     */
    public void validatePost(String expected) {
        try {
            action = "Post";
            postResponse = response.getBody().as(PostResponse.class);
//            postResponse = setObjectMapper(PostResponse.class);
            Assert.assertEquals(postResponse.getStatus(),expected);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Object mapper is used covert the response body back to java object
     * with the support of pojo classes
     * If the response is wrapped as java object, then it is easy to parse and
     * extract response using getters methods.
     */
    private <T> T setObjectMapper(Class<T> action) throws JsonProcessingException {
        T responseValue;
        responseValue = objectMapper.readValue(response.asString(), action);
        return responseValue;
    }

    public void validatePut(String expected) {
        try {
            action = "put";
            putResponse = setObjectMapper(PutResponse.class);
            Assert.assertEquals(putResponse.getMsg(),expected);
        } catch (JSONException | JsonProcessingException err) {
            err.printStackTrace();
        }

    }

    public void validateGetServiceResponse(String expected) {
        try {
            boolean address = action.equals("Post") ? this.setPostBody().getAddress().equals(expected) :
                    this.setPutBody().getAddress().equals(expected);
            if (!address) {
                throw new AssertionFailedError();
            }
        } catch (JSONException err) {
            err.printStackTrace();
        }
    }

    public void validateDelete(String expected) {
        try {
            deleteResponse = setObjectMapper(DeleteResponse.class);
            Assert.assertEquals(deleteResponse.getStatus(),expected);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }

    public Map<String, String> getInputData(String action) {
        List<String> inputData = new ArrayList<>();
        Gson gson = new Gson();
        try (Reader reader = new FileReader("restapi_input.json")) {
            Map<String, List<String>> strJson = gson.fromJson(reader, Map.class);
            for (Map.Entry<String, List<String>> entry : strJson.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(action.toLowerCase())) {
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

    private RequestSpecification requestSpecification() {
        return new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(collect.get("BaseURI"))
                .addQueryParam(collect.get("QueryParamKey"), collect.get("QueryParamValue")).
                        addHeader(collect.get("HeaderKey"), collect.get("HeaderValue")).build();
    }
}
