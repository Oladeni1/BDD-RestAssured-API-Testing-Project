Feature: As a 3rd party Developer I am able access to the API and retrieved postcode information for the US and Great Britain only.


  Scenario: Get postcode info for Great Britain
    Given a get call to "https://api.zippopotam.us/GB/eng/london"
    Then status code is "200"
    Then  I retrieve Great Britain post code










