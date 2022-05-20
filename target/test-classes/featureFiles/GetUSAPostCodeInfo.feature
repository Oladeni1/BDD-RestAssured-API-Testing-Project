Feature: As a 3rd party Developer I am able access to the API and retrieved postcode information for the US and Great Britain only.


  Scenario: Get postcode info for United States
    Given I made a get call to "https://api.zippopotam.us/us/tx/dallas"
    Then status code should be "200"
    Then  I retrieve United states post code