@register
Feature: Registration User

  @register @positive
  Scenario: As a user, I want to fill in all required information accurately and successfully create an account.
    Given user navigate to the register page "https://dev-team8.netlify.app/register"
    When user input a valid email
    * user input a fullname
    * user input a date of birth
    * user input a phone number
    * user input a password that matches the criteria
    * user click Sign Up button
    Then user should be successfully register
    * user take screenshot "user-successfully-register"

  @register1 @negative
  Scenario: As a user, I want to be reminded to complete all mandatory fields if I attempt to submit the registration form with empty fields.
    Given user navigate to the register page "https://dev-team8.netlify.app/register"
    When user click Sign Up button
    Then inline error message appears for each required field

  @register1 @negative
  Scenario: As a user, I want to receive a clear error message if I attempt to submit the registration form with an email lacking the "@" symbol.
    Given user navigate to the register page "https://dev-team8.netlify.app/register"
    When user input a invalid email format
    * user input a fullname
    * user input a date of birth
    * user input a phone number
    * user input a password that matches the criteria
    * user click Sign Up button
    Then inline error message appears for invalid email format

  @register1 @negative
  Scenario: As a user, I want to be notified with an error message if I provide an invalid phone number, such as one containing alphabetic characters.
    Given user navigate to the register page "https://dev-team8.netlify.app/register"
    When user input a valid email
    * user input a fullname
    * user input a date of birth
    * user input a phone number using alphabetic characters
    * user input a password that matches the criteria
    * user click Sign Up button
    Then inline error message appears for phone number using alphabetic characters

  @register1 @negative
  Scenario: As a user, I want to receive guidance and error messages when attempting to set a password that does not meet the specified criteria, including a minimum length, at least one letter, and one number.
    Given user navigate to the register page "https://dev-team8.netlify.app/register"
    When user input a valid email
    * user input a fullname
    * user input a date of birth
    * user input a phone number
    * user input a password that does not match the criteria
    * user click Sign Up button
    Then inline error message appears that Password require minimum eight characters, at least one letter and one number

  @End2EndPhase100
  Scenario: As a user, I want to test all validations on the register page
    Given user navigate to the home page "https://dev-team8.netlify.app/"
    * user is not logged in to WeFLy
    * user navigate to register page
    When user click Sign Up button
    Then inline error message appears for each required field
    * user take screenshot "register by not filling in all required data"
    When user input a invalid email format
    * user input a fullname
    * user input a date of birth
    * user input a phone number
    * user input a password that matches the criteria
    * user click Sign Up button
    Then inline error message appears for invalid email format
    * user take screenshot "register with invalid email format"
    When user input a valid email
    * user input a fullname
    * user input a phone number using alphabetic characters
    * user input a password that matches the criteria
    * user click Sign Up button
    Then inline error message appears for phone number using alphabetic characters
    * user take screenshot "register with alphabetic characters on phone number"
    When user input a valid email
    * user input a fullname
    * user input a phone number
    * user input a password that does not match the criteria
    * user click Sign Up button
    Then inline error message appears that Password require minimum eight characters, at least one letter and one number
    * user take screenshot "register with a password that does not match the criteria"
    When user input a valid email
    * user input a fullname
    * user input a phone number
    * user input a password that matches the criteria
    * user click Sign Up button
    Then user should be successfully register
    * user take screenshot "user-successfully-register"

    Given navigate to login page
    * navigate to forgot password page
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

    When back to login page
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

    * user navigate to profile page
    When user change profile data
    * user click Save Button
    Then user should see an snackbar message that update profile successfully
    * user take screenshot "forgot password without filling in the email field"





