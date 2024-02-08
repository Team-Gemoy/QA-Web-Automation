@forgotPassword
Feature: Forgot Password

  @forgotPassword  @negative  @phase1
  Scenario: As a user, I want to make sure that I can't skip the OTP input step if the otp I entered is invalid.
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user click Forgot Password button
    * user input valid email on forgot password page
    * user click Reset Password button
    Then user will redirect to input OTP page
    * user take screenshot "forgot password without filling in the email field"
    When user input incorret OTP code
    * user click Continue button
    Then user should see an snackbar error message that invalid OTP

  @forgotPassword  @negative  @phase1
  Scenario: As a user, I want to make sure that I can't skip the email input step in the forgot password feature if I enter an email with an invalid format.
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user click Forgot Password button
    * user input invalid email format on forgot password page
    * user click Reset Password button
    Then user should see an inline error message that invalid email formatted
    * user take screenshot "forgot password without filling in the email field"

  @forgotPassword  @negative  @phase1
  Scenario: As a user, I want to make sure that there is information if I have not entered my email in the forgot password feature.
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user click Forgot Password button
    * user click Reset Password button
    Then user should see an inline error message that empty email field
    * user take screenshot "forgot password with invalid email format"

  @forgotPassword  @negative  @phase1
  Scenario: As a user, I want to make sure that I can't request a forgot password if I use an unregistered email.
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user click Forgot Password button
    * user input unregistered email on forgot password
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






