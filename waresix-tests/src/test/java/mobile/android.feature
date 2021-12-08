Feature: android test

  Background:
    * call read 'classpath:mobile/locator.json'

  Scenario: Login account
    Given driver mobileDriver
    And waitFor(landing_page.dev_tool_button).click()
    And delay(1000)

  Scenario: Switch environment
    Given driver mobileDriver
    And waitFor(landing_page.dev_tool_button).click()
    And delay(1000)
