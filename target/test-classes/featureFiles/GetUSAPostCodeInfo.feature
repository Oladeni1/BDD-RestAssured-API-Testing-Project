Feature: As a 3rd party Developer I am able access to the API and retrieved postcode information for the US and Great Britain only.

     ## Positive test Scenario:
  Scenario: Get postcode info for United States
    Given I made a get call to "https://api.zippopotam.us/us/tx/Houston"
    Then status code should be "200"
    Then  I retrieve United states post code

     ## Negative test Scenario:
  Scenario: Verify that 404 status code returned when a GET request is made to incomplete endpoint for United States.
    Given Get call to "https://api.zippopotam.us/us/tx"
    Then Status code of "404"