

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"target/parallel/features/soapapi_scenario001_run001_IT.feature"},
        plugin = {"json:target/cucumber-report/Runner_soapapi_scenario001_run001_IT.json"}
)
public class Runner_soapapi_scenario001_run001_IT {

}

// Generated by Cucable from src/test/java/com/web/parallel/CucableJavaTemplate.java
