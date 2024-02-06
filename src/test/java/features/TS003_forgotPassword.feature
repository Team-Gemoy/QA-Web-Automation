@forgotPassword
Feature: Forgot Password

  @forgotPassword99  @negative
  Scenario: valid email format
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user click Forgot Password button
    * user input valid email on forgot password page
    * user click Reset Password button
    Then user will redirect to input OTP page
    * user take screenshot "forgot password without filling in the email field"
    When user input incorret OTP code
    * user click Continue button
    Then user should see an snackbar error message that invalid OTP

  @forgotPassword  @negative
  Scenario: invalid email format
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user click Forgot Password button
    * user input invalid email format on forgot password page
    * user click Reset Password button
    Then user should see an inline error message that invalid email formatted
    * user take screenshot "forgot password without filling in the email field"

  @forgotPassword1  @negative
  Scenario: As a user, I want to be reminded to provide the necessary information for password reset.
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user click Forgot Password button
    * user click Reset Password button
    Then user should see an inline error message that empty email field
    * user take screenshot "forgot password with invalid email format"

  @forgotPassword  @negative
  Scenario: invalid email format
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user click Forgot Password button
    * user input unregistered email
    * user click Reset Password button
    Then user should see an snackbar error message that unregistered email
    * user take screenshot "forgot password with unregistered email"

  @End2EndPhase1
  Scenario: As a user, I want to be reminded to provide the necessary information for password reset.
    Given user navigate to the home page "https://dev-team8.netlify.app/"
    * user is not logged in to WeFLy
    * user navigate to login page
    * user navigate to forgot password page
    When user click Reset Password button
    Then user should see an inline error message that empty email field
    * user take screenshot "forgot password without filling in the email field"
    When user input invalid email format on forgot password page
    * user click Reset Password button
    Then user should see an inline error message that invalid email formatted
    * user take screenshot "forgot password with invalid email format"
    When user input unregistered email on forgot password page
    * user click Reset Password button
    Then user should see an snackbar error message that unregistered email
    * user take screenshot "forgot password with unregistered email"
    When user input valid email on forgot password page
    * user click Reset Password button
    Then user will redirect to input OTP page
    * user take screenshot "forgot password without filling in the email field"
    When user input incorret OTP code
    * user click Continue button
    Then user should see an snackbar error message that invalid OTP






