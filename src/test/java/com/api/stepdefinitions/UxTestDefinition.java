package com.api.stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuthenticationPage;
import steps.WaitSteps;
import utils.AssertionText;
import utils.CommonUtil;

public class UxTestDefinition {

    private final TestContext testContext;
    private CommonUtil commonUtil;
    private  AuthenticationPage authenticationPage;

    public UxTestDefinition(TestContext testContext) {
        this.testContext = testContext;
        commonUtil = new CommonUtil(testContext);
        authenticationPage = new AuthenticationPage();
    }

    @Given("^user clicks create account$")
    public void homePage() {
        testContext.getPropertyTransfer().put("UXLaunchResponse","Yes");
//        testContext.getDriver().get(System.getProperty("UX"));
        commonUtil.signIn();
    }

    @And("user filling the personal information")
    public void userFillingThePersonalInformation() {
        commonUtil.createAccount();
    }

    @When("user back to home page")
    public void userBackToHomePage() {
    }

    @And("add the items into the cart")
    public void addTheItemsIntoTheCart() {
    }

    @Then("verify the item counts in the cart")
    public void verifyTheItemCountsInTheCart() {
    }

    @Then("^validate the text as (.+)$")
    public void validateText(String expected) {
        new AssertionText(expected,"PersonalInfoLabel", authenticationPage,testContext);
    }
}
