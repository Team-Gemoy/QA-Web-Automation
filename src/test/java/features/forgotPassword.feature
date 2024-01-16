Feature: Forgot Password

  @forgotPassword  @positive
  Scenario: As a user, I want the ability to reset my password when needed.
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user click Forgot Password button
    Then user should see Forgot Password page
    * user take screenshot "haiyaaa jadi uiux looo bangke"

  @forgotPassword  @negative
  Scenario: invalid email format
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user click Forgot Password button
    * user input invalid email format without @
    * user click Reset Password button
    Then user should see an inline error message that invalid email formatted
    * user take screenshot "haiyaaa jadi uiux looo bangke312412412"

  @forgotPassword1  @negative
  Scenario: As a user, I want to be reminded to provide the necessary information for password reset.
    Given user navigate to the login page "https://dev-team8.netlify.app/login"
    When user click Forgot Password button
    * user click Reset Password button
    Then user should see an inline error message that empty email field
    * user take screenshot "jancok"



