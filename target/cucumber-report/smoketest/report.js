$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/feature/FirstTest.feature");
formatter.feature({
  "name": "123",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@all"
    }
  ]
});
formatter.scenario({
  "name": "345",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@all"
    }
  ]
});
formatter.step({
  "name": "I am open \"https://vk.com/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.iAmOpen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I swich langauge to English",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.iSwichLangaugeToEnglish()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I check title \"VK for mobile devices\"",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.iCheckTitle(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I swich langauge to Russian",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.iSwichLangaugeToRussian()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I check title \"ВКонтакте для мобильных устройств\"",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.iCheckTitle(String)"
});
formatter.result({
  "status": "passed"
});
});