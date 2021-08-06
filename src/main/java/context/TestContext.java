package context;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@Slf4j
public class TestContext {

    private RemoteWebDriver driver = null;
    private Map<String,String> propertyTransfer = new LinkedHashMap<>();

    public RemoteWebDriver getDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            log.info("Browser version - {}",getDriver().getCapabilities().getBrowserVersion());
            driver.manage().window().maximize();
        }
        return driver;
    }

}
