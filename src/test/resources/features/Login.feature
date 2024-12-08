Feature: Login Harry Harry

  @LoginHarry
  Scenario Outline: Changing machines timezone

    Given I change Windows "<TimeZone>"

    Examples:
      | TimeZone                  |
      | New Zealand Standard Time |
  @LoginHarry1
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

  @LoginHarry2
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

  @WindowHandle1
  Scenario Outline: This test use to verify login
    Given the url hit in successfully
    And login button clicked successfully
    And Enter the Email as "PatientEmail"
    And Enter the Password as "PatientPassword"
    And Click the Login button
    Then User logged in successfully
    Then Open a New tab or New Window
    And login button clicked successfully
    And Enter the Email as "ProviderEmail"
    And Enter the Password as "ProviderPassword"
    And Click the Login button
    Then User logged in successfully

    Examples:
      | PatientEmail            | PatientPassword | ProviderEmail    | ProviderPassword |
      | testhenry@mmh-demo.com  | Manage@123      | tim@mmh-demo.com | Manage@123       |
