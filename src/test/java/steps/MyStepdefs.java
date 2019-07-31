package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("I am open {string}")
    public void iAmOpen(String arg0) {
        open(arg0);
    }

    @And("I check title {string}")
    public void iCheckTitle(String arg0) {
        $(".login_mobile_header").shouldHave(text(arg0));
    }

    @When("I swich langauge to Russian")
    public void iSwichLangaugeToRussian() {
        $("#index_footer_wrap > div:nth-child(1) > div:nth-child(2) > a:nth-child(2)").scrollTo().click();
    }

    @Then("I swich langauge to English")
    public void iSwichLangaugeToEnglish() {
        $("#top_switch_lang").click();
    }
}
