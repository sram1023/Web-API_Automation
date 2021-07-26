package com.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RestWebServices {

    CommonUtil commonUtil = new CommonUtil();

    @Given("^the rest api for (.+) is ready$")
    public void restApi(String action) {
        commonUtil.restApiActions(action);
    }

    @When("^I (.+) the record with some details$")
    public void iPostTheRecordWithSomeDetails(String action) {
        commonUtil.postAction(action);
    }

    @Then("^validate the success status (.+)$")
    public void validateTheSuccessStatus(String expected) {
        commonUtil.validateStatus(expected);
    }

    @Then("^validate the address (.+) from get response$")
    public void validateTheNameFrontlineHousesFromGetResponse(String expected) {
        commonUtil.validateGetServiceResponse(expected);
    }

    @Then("^validate the message (.+)$")
    public void validateTheMessageAddressSuccessfullyUpdated(String expected) {
        commonUtil.validateUpdateStatus(expected);
    }



    @Given("test the properties")
    public void testTheProperties() throws IOException {

            Properties properties = new Properties();
            String propFile = "C:\\Users\\ramkumar.raja\\IdeaProjects\\Practice\\tests123\\src\\test\\resources\\sample.properties";
//             InputStream fileInputStream = One.class.getClassLoader().getResourceAsStream("src/main/resources/sample.properties");
            ClassLoader classLoader = RestWebServices.class.getClassLoader();
            InputStream propStream = classLoader.getResourceAsStream(propFile);
            properties.load(propStream);

            System.out.println(properties.getProperty("nameR"));


    }
}
