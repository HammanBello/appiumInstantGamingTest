@login
Feature: Login

  Background:
    Given User is on homepage

  @TEST_OF
  Scenario Outline: Login as subscribed user
    Given User is on login page
    When User enter a "<cellphone_number>" and "<password>"
    And User press on login button
    Then User should be in the application as a logged user

    Examples:
      |cellphone_number     |password      |
      |696074190            |Mimosamimosa1.|
