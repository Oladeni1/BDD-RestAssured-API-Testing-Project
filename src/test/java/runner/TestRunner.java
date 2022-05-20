package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
        //path of feature file
        features = "src/test/resources/featureFiles",
        //path of step definition file
        glue = "step/definitions"
)

public class TestRunner {

}
