import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-html-reports", "json:target/cucumber.json",
        "pretty:target/cucumber-pretty.txt", "junit:target/cucumber-results.xml"},
        features = "src/test/java/feature",
        glue = "steps",
        tags = "@all",
        dryRun = false,
        strict = false

)
public class RunnerTest {
}