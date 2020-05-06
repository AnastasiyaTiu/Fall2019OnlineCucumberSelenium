@create_car
Feature: Create a car
  As a user, I want to be able to add new cars

  Scenario: Add new car
    Given user is on the login page
    When user logs in as a sales manager
    Then user navigates to "Fleet" and "Vehicles"
    And user click on create a car button
    Then user creates a car with following info:
      | License Plate | Driver | Location    | Model Year | Color |
      | SDET          | Racer  | Roma, Italy | 2020       | White |
    And user verifies that car info is displayed:
      | License Plate | Driver | Location    | Model Year | Color |
      | SDET          | Racer  | Roma, Italy | 2020       | White |


  @create_car_ddt
  Scenario Outline: Add new car for driver <driver>
    Given user is on the login page
    When user logs in as a sales manager
    Then user navigates to "Fleet" and "Vehicles"
    And user click on create a car button
    Then user creates a car with following info:
      | License Plate   | Driver   | Location   | Model Year   | Color   |
      | <license_plate> | <driver> | <location> | <model_year> | <color> |
    And user verifies that car info is displayed:
      | License Plate   | Driver   | Location   | Model Year   | Color   |
      | <license_plate> | <driver> | <location> | <model_year> | <color> |

    Examples: cars test data
      | license_plate | driver      | location        | model_year | color  |
      | 000           | pilot       | Washington D.C. | 2010       | purple |
      | 123           | test_driver | New York        | 2020       | black  |
      | 9122          | pro_driver  | Los Angeles     | 2019       | red    |

