Feature: As a 3rd party Developer I am able access to the API and retrieved postcode information for the US and Great Britain only.

## Positive test Scenario:
  Scenario: Get postcode info for Great Britain
    Given a get call to "https://api.zippopotam.us/GB/eng/Birmingham"
    Then status code is "200"
    Then  I retrieve Great Britain post code

  ## Negative test Scenario:
  Scenario: Verify that 404 status code returned when a GET request is made to incomplete endpoint for Great Britain.
    Given a Get call to "https://api.zippopotam.us/GB/eng/"
    Then Status code is "404"








