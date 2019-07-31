@all
  Feature: 123
    Scenario: 345
      Given I am open "https://vk.com/"
      Then I swich langauge to English
      And I check title "VK for mobile devices"
      When I swich langauge to Russian
      And I check title "ВКонтакте для мобильных устройств"
