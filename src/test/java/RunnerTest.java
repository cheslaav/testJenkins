import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue = "steps",
        tags = "@all",
        dryRun = false,
        strict = false

)
public class RunnerTest {
}