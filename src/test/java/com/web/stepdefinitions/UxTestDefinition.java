package com.web.stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AuthenticationPage;
import utils.AssertionText;
import utils.CommonUtil;

public class UxTestDefinition {

    private final TestContext testContext;
    private final CommonUtil commonUtil;
    private final AuthenticationPage authenticationPage;

    public UxTestDefinition(TestContext testContext) {
        this.testContext = testContext;
        commonUtil = new CommonUtil(testContext);
        authenticationPage = new AuthenticationPage();
    }

    public void launchApplication() {
        testContext.getDriver().get(System.getProperty("UX"));
    }

    @Given("^user clicks create account$")
    public void homePage() {
        this.launchApplication();
        commonUtil.signIn();
    }

    @And("user filling the personal information")
    public void userFillingThePersonalInformation() {
        commonUtil.createAccount();
    }

    @Then("^validate the text as (.+)$")
    public void validateText(String expected) {
        new AssertionText(expected, "PersonalInfoLabel", authenticationPage, testContext);

    }
}
