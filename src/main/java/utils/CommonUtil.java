package utils;

import context.TestContext;
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
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import pages.AuthenticationPage;
import pages.HomePage;
import steps.WaitSteps;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

import static io.restassured.RestAssured.*;
import static java.util.stream.Collectors.toMap;

@Slf4j
public class CommonUtil {

    TestContext testContext;
    Map<String, String> collect = null;
    String response;
    JSONObject postJsonObject;
    JSONObject jsonObject;
    LinkedHashMap<String, String> inputValues = new LinkedHashMap<>();
    WaitSteps waitSteps = new WaitSteps();
    WaitSteps homePage = new HomePage();
    WaitSteps authenticationPage = new AuthenticationPage();

    public CommonUtil(TestContext testContext) {
        this.testContext = testContext;
    }


    private void fillMyScreen(LinkedHashMap<String, String> inputValues, WaitSteps page) {
        try {
            for (Map.Entry<String, String> entry : inputValues.entrySet()) {
                if (entry.getKey().contains("Button")) {
                    buttonClick(page, entry.getKey());
                } else if (entry.getKey().contains("TextBox")) {
                    enterValues(page, entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void signIn() {
        LinkedHashMap<String, String> signIn = new LinkedHashMap<>();
        try {
            signIn.put("SignInButton", "Click");
            fillMyScreen(signIn, homePage);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public void createAccount() {
        LinkedHashMap<String, String> createAccount = new LinkedHashMap<>();
        try {
            createAccount.put("EmailAddressTextBox", "htyy@gmail.com");
            createAccount.put("CreateAccountButton", "Click");
            createAccount.put("TitleMrRadio", "Click");
            createAccount.put("TitleMrsRadio", "Click");
            createAccount.put("FirstNameTextBox", "David");
            createAccount.put("LastNameTextBox", "Hall");
            fillMyScreen(createAccount, authenticationPage);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    private void buttonClick(WaitSteps waitSteps, String eleName) {
        try {
            waitSteps.waitForElementVisible(eleName, testContext).click();
        } catch (StaleElementReferenceException e) {
            log.error(e.getMessage());
            WebElement element = testContext.getDriver().findElement(waitSteps.webElementPath.get(eleName));
            waitSteps.findElementJSClick(element, testContext);
        }
    }

    private void enterValues(WaitSteps waitSteps, String key, String value) {
        try {
            waitSteps.waitForElementVisible(key, testContext).sendKeys(value);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
