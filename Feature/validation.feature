Feature: Validationg Place API's
@AddPlace @Regression
  Scenario Outline: Verify is place is being successfully added using AddPlaceAPI
    Given Add Place Payload "<name>" "<language>" "<address>"
    When user calls  "AddPlaceAPI" with "Post" http  request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_id created maps to "<name>" using "getPlaceAPI"
#here why we are using regression beacuse we can have n number tags to secarnio suppose i want to run bith addplace and deleteplace at\
#that time we can use regredession suppose i want to reun ony addplace we can use addplace same todeletepalce
    Examples: 
      | name | language | address |
      | sai  | hindi    | h.no10  |
  #    | anus | telugu   | h.no12  |
# here why am doing cooment for the above data because already we have see these so you un comment but i commected that it

@DeletePlace @Regression
Scenario: Verify if Delete Place functionality is working
Given DeletePlace Payload
    When user calls  "deletePlaceAPI" with "Post" http  request
    Then the API call is success with status code 200
    And "status" in response body is "OK"