package steps;

import context.TestContext;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Slf4j
public class WaitSteps {

    public HashMap<String, By> webElementPath = new LinkedHashMap<>();
    private static final int WAIT_TIME = 10;
    String executeScript = "window.onbeforeunload = function(e){};";

    public WebElement waitForElementVisible(String eleName, TestContext testContext){
        testContext.getDriver().executeScript(executeScript);
        WebDriverWait wait = new WebDriverWait(testContext.getDriver(), Duration.ofSeconds(WAIT_TIME));
        try{
            return wait.until(ExpectedConditions.visibilityOfElementLocated(webElementPath.get(eleName)));
        }catch (Exception e){
            log.info(e.getMessage());
            return  wait.until(ExpectedConditions.visibilityOfElementLocated(webElementPath.get(eleName)));
        }
    }

    public void findElementJSClick(WebElement element, TestContext testContext){
        testContext.getDriver().executeScript("arguments[0].click();", element);
    }

}
