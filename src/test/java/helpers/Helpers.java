package helpers;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebElementSource;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static helpers.Const.*;

public class Helpers {
    public static void targetElement(String arg0) {

        char A = arg0.charAt(0);
        switch (A) {
            case 'Т': {
                $(".suggest--nav > span:nth-child(1)").shouldHave(text(arg0)).click();
                break;
            }
            case 'П': {
                $(".suggest--nav > span:nth-child(2)").shouldHave(text(arg0)).click();
                break;
            }
            case 'К': {
                $(".suggest--nav > span:nth-child(3)").shouldHave(text(arg0)).click();
                break;
            }
        }

    }

    public static void actionWithTargetElement(String arg0, String arg1, Integer i) {
        targetElement(arg0);
        $(".lg > input:nth-child(1)").setValue(arg1);
        sleep(500);
        $("span.icon:nth-child(" + i + ")").click();
        sleep(500);
    }

    public static void checkProcedureNamePurchase(String str1, Integer integer) {
        ArrayList<String> procedureNamePurchase = new ArrayList<String>();
        procedureNamePurchase.add("tender_open Открытый тендер на закупку");
        procedureNamePurchase.add("tender_close Закрытый тендер на закупку");
        procedureNamePurchase.add("auction_open Открытый аукцион на закупку");
        procedureNamePurchase.add("auction_close Закрытый аукцион на закупку");
        procedureNamePurchase.add("query_quotation Запрос котировок");

        if (str1.equalsIgnoreCase(procedureNamePurchase.get(0)) ||
                str1.equalsIgnoreCase(procedureNamePurchase.get(1)) ||
                str1.equalsIgnoreCase(procedureNamePurchase.get(2)) ||
                str1.equalsIgnoreCase(procedureNamePurchase.get(3)) ||
                str1.equalsIgnoreCase(procedureNamePurchase.get(4))) {
            $("div.summary:nth-child(" + integer + ") > div:nth-child(1) > div:nth-child(1)" +
                    " > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)" +
                    " > span:nth-child(1)").click();
        } else {
            $(".no-data-selector-bug-test-fail").click();
        }
    }

    public static void checkProcedureNameSale(String str1, Integer integer) {
        ArrayList<String> procedureNameSale = new ArrayList<String>();
        procedureNameSale.add("tender_open Открытый тендер на продажу");
        procedureNameSale.add("tender_close Закрытый тендер на продажу");
        procedureNameSale.add("auction_open Аукцион на продажу");
        procedureNameSale.add("auction_close Закрытый аукцион на продажу");

        if (str1.equalsIgnoreCase(procedureNameSale.get(0)) ||
                str1.equalsIgnoreCase(procedureNameSale.get(1)) ||
                str1.equalsIgnoreCase(procedureNameSale.get(2)) ||
                str1.equalsIgnoreCase(procedureNameSale.get(3))) {
            $("div.summary:nth-child(" + integer + ") > div:nth-child(1) > div:nth-child(1) " +
                    "> div:nth-child(2) > div:nth-child(1) > div:nth-child(1) " +
                    "> span:nth-child(1) > span:nth-child(1)").click();
        } else {
            $(".no-data-selector-bug-test-fail").click();
        }
    }

    public static void itemChecking(String itemName, Integer i) {
        String s1 = itemName.replaceAll("[^0-9]+", "");
        Integer valueItemTab = Integer.valueOf(s1);
        $$("li.iac--tabs_item").get(i).click();
        Integer realSize = $$(".summary-list > .summary").size();
        if (valueItemTab > 0) {
            if (valueItemTab >= realSize) {
                for (int v = 0; v < realSize; v++) {
                    $$(".summary-list > .summary").get(v).shouldNotBe(empty).click();
                    sleep(300);
                }
            }
        }
    }

    public static void itemContentChecking() {
        $("div.summary:nth-child(1) > div:nth-child(1) > div:nth-child(1) " +
                "> div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) " +
                "> a:nth-child(1)").shouldNotBe(empty);
        $("div.summary:nth-child(1) > div:nth-child(1) > div:nth-child(1) " +
                "> div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) " +
                "> a:nth-child(1)").shouldNotBe(empty);
        String value = $("div.summary:nth-child(1) > div:nth-child(1) " +
                "> div:nth-child(1) > div:nth-child(2) > footer:nth-child(2) > div:nth-child(1) " +
                "> div:nth-child(1) > span:nth-child(1)").getText();
        String s1 = value.replaceAll("[^0-9]+", "");
        Integer value1 = Integer.valueOf(s1);
        if (value1 > 0) {
            $("div.summary:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > footer:nth-child(2)").click();
        }
    }

    public static void companyTabContentChecking() {
        $$(".summary-list > .summary").get(1).shouldBe(appear);
        Integer size = $$(".summary-list > .summary").size();
        for(int i = 1; i < size; i++) {
            $("div.summary:nth-child("+i+") > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) " +
                    "> div:nth-child(1) > a:nth-child(1)").shouldNotBe(empty);
            $("div.summary:nth-child("+i+") > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) " +
                    "> div:nth-child(2) > a:nth-child(1) > span:nth-child(2)").shouldNotBe(empty);
            String val = $("div.summary:nth-child("+i+") > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > footer:nth-child(3) > div:nth-child(1) > span:nth-child(1)").getText();
            float x = Float.parseFloat(val);
            if(x >= 0) {
                $("div.summary:nth-child("+i+") > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > footer:nth-child(3) > div:nth-child(1) > span:nth-child(1)").click();
                sleep(50);
            }
        }
    }
    public static void companyTabProcedureChecking() {
        $$(".summary-list > .summary").get(1).shouldBe(appear);
        Integer size = $$(".summary-list > .summary").size();
        for(int i = 1; i < size; i++) {
            $("div.summary:nth-child("+i+") > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) " +
                    "> div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > span:nth-child(1)")
                    .shouldNotBe(empty).click();
            $("div.summary:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) " +
                    "> div:nth-child(1) > div:nth-child(2)").shouldNotBe(empty);
            $("div.summary:nth-child("+i+") > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) " +
                    "> div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)").shouldNotBe(empty);
            $("div.summary:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) " +
                    "> div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1)").shouldNotBe(empty);
            $("div.summary:nth-child("+i+") > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) " +
                    "> div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) " +
                    "> span:nth-child(2)").shouldNotBe(empty);
            $("div.summary:nth-child("+i+") > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) " +
                    "> div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > span:nth-child(1) " +
                    "> span:nth-child(2)").shouldNotBe(empty);
            $("div.summary:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) " +
                    "> div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2) " +
                    "> span:nth-child(2)").shouldNotBe(empty);
            $("div.summary:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) " +
                    "> div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > span:nth-child(2) " +
                    "> span:nth-child(2)").shouldNotBe(empty);
            sleep(100);
        }
    }
    public static void swichLang(String arg) {
        String presentLang = $(".toggle > div:nth-child(1) > span:nth-child(2)").shouldBe(appear).getText();
        if(presentLang.equalsIgnoreCase("Русский")) {
            $(".toggle > div:nth-child(1) > span:nth-child(2)").shouldBe(appear).click();
            sleep(500);
            $(".content > div:nth-child(1) > span:nth-child(2)").shouldBe(appear).click();
            open(arg);
        }
    }

    public static void AuthByTpro() {
        open(DEFAULT_URL + "develop/config");
        $(".table > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(3) > input:nth-child(1)").setValue("false").pressEnter();
        open(LOGIN_PAGE);
        $(byAttribute("placeholder", "Логин")).setValue("login_soap1");
        $("div.form-group:nth-child(3) > label:nth-child(1)").click();
        $(byAttribute("placeholder", "Пароль / Временный код")).setValue("5879JVw").pressEnter();
        sleep(1000);
    }

}
