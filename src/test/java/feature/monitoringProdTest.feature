@all
Feature: Мониторинг кабинета на бою
  Scenario: Проверка работоспособности кабинета
    Given I logged in
    And I check login user "Jenkins - 1"
    And I check workspace
    And I see message "Раздел в разработке"
    Then I check sidebar link
      | Name         |
      | Корзина      |
      | Торги        |
      | Организуем   |
      | Участвуем    |
      | Приглашения  |
      | Договоры     |
      | Заказы       |

    Scenario: Переход по ссылкам в сайдбаре
      Given I logged in
      And I check sidebar link "Корзина"
      And check tab trash "Товары", "Процедуры", "Компании"
      And I check sidebar link "Торги"
      And check tab tender "Организуем", "Участвуем", "Приглашения"
      And I check sidebar link "Договоры"
      And check tab contract "Исходящие", "Входящие"
      And I check sidebar link "Заказы"
      And check tab order "Исходящие", "Входящие"

    Scenario: Проверка элемента из раздела Торги -> Организуем
      Given I logged in
      And I select "Организуем"
      And I check a random item from the list own "Организуем"

    Scenario: Проверка элемента из раздела Торги -> Участвуем
      Given I logged in
      And I select "Участвуем"
      And I check a random item from the list party "Участвуем"

  Scenario: Проверка элемента из раздела Торги -> Приглашения
    Given I logged in
    And I select "Приглашения"
    And I check a random item from the list invitation "Приглашения"

  Scenario: Проверка элемента из раздела Договоры -> Исходящие
    Given I logged in
    And I select "Договоры"
    And I check a random item from the list contract own "Исходящие"

  Scenario: Проверка элемента из раздела Договоры -> Входящие
    Given I logged in
    And I select "Договоры"
    And I check a random item from the list contract party "Входящие"

  Scenario: Проверка элемента из раздела Заказы -> Исходящие
    Given I logged in
    And I select "Заказы"
    And I check a random item from the list order own "Исходящие"

  Scenario: Проверка элемента из раздела Заказы -> Входящие
    Given I logged in
    And I select "Заказы"
    And I check a random item from the list order party "Входящие"