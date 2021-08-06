package com.hooks;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

@Slf4j
public class Hooks {

    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void beforeScenario(){
        testContext.getDriver().get(System.getProperty("UX"));
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                // Take a screenshot...
                byte[] screenshot = ((TakesScreenshot) testContext.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot");
            }
        }catch (WebDriverException e){
            log.error(e.getMessage());
        }
    }
}
