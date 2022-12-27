@LoginHarry
Feature: Login Harry Harry

  Scenario Outline: Changing machines timezone

    Given I change Windows "<TimeZone>"

    Examples:
      | TimeZone                  |
      | New Zealand Standard Time |

  Scenario Outline: This test use to verify login
    Given the url hit in successfully
    And login button clicked successfully
    And Enter the Email as "Email"
    And Enter the Password as "Password"
    And Click the Login button
    Then User logged in successfully
    And Click signout button

    Examples: 
      | Email                   | Password   |
      | harryharry@mmh-demo.com | Manage@123 |

  Scenario Outline: This test use to verify logout
    Given the url hit in successfully
    And login button clicked successfully
    And Enter the Email as "Email"
    And Enter the Password as "Password"
    And Click the Login button
    Then User logged in successfully
    Then I click MMH Logo
    And Click signout button

    Examples:
      | Email                   | Password   |
      | harryharry@mmh-demo.com | Manage@123 |
