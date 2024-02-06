@login
Feature: Login User

  @login1 @positive
  Scenario: As a user, I want to ensure that I can successfully log in to the application using my credentials.
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user input valid email
    * user input correct password
    * user click Login button
    Then user should be successfully login
    * user take screenshot "user-successfully-login"

  @login2 @negative
  Scenario: As a user, I want the system to notify me when I enter an incorrect password during the login process.
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user input valid email
    * user input incorrect password
    * user click Login button
    Then user should see an snackbar error message for incorrect password
    * user take screenshot "incorrect-password"

  @login2 @negative
  Scenario: As a user, I want to be informed if I enter an unregistered "Email" during the login attempt.
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user input unregistered email
    * user input correct password
    * user click Login button
    Then user should see an snackbar error message for unregistered email
    * user take screenshot "unregistered-email"

  @login2 @negative
  Scenario: As a user, I would like to leave the "Email" or "Password" fields, or both, blank during the login process.
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user click Login button
    Then user should see an error message indicating empty fields
    * user take screenshot "empty-fields"

  @login2 @negative
  Scenario: As a user, I want to enter an incorrectly formatted email (without @)
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user input invalid email format
    Then user should see an error message indicating invalid email format
    * user take screenshot "invalid-email-formatted"

    @End2EndPhase1
    Scenario: As a user, I want to test all validations on the login page
      Given user navigate to the home page "https://dev-team8.netlify.app/"
      * user is not logged in to WeFLy
      * user navigate to login page
      When user input valid email
      * user input incorrect password
      * user click Login button
      Then user should see an snackbar error message for incorrect password
      * user take screenshot "incorrect-password"
      When user input unregistered email
      * user input correct password
      * user click Login button
      Then user should see an snackbar error message for unregistered email
      * user take screenshot "unregistered-email"
      When user click Login button
      Then user should see an error message indicating empty fields
      * user take screenshot "empty-fields"
      When user input invalid email format
      Then user should see an error message indicating invalid email format
      * user take screenshot "invalid-email-formatted"
      When user input valid email
      * user input correct password
      * user click Login button
      Then user should be successfully login
      * user take screenshot "user-successfully-login"


