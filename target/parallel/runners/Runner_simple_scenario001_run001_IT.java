

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"target/parallel/features/simple_scenario001_run001_IT.feature"},
        plugin = {"json:target/cucumber-report/Runner_simple_scenario001_run001_IT.json"}
)
public class Runner_simple_scenario001_run001_IT {

}

// Generated by Cucable from src/test/java/com/api/parallel/CucableJavaTemplate.java
