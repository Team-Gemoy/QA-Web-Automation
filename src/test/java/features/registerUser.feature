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
    Then user should be successfully login

  @register1 @negative
  Scenario: As a user, I want to be reminded to complete all mandatory fields if I attempt to submit the registration form with empty fields.
    Given user navigate to the register page "https://dev-team8.netlify.app/register"
    When user click Sign Up button
    Then inline error message appears for each required field

  @register2 @negative
  Scenario: As a user, I want to receive a clear error message if I attempt to submit the registration form with an email lacking the "@" symbol.
    Given user navigate to the register page "https://dev-team8.netlify.app/register"
    When user input a invalid email format
    * user input a fullname
    * user input a date of birth
    * user input a phone number
    * user input a password that matches the criteria
    * user click Sign Up button
    Then inline error message appears for invalid email format

  @register3 @negative
  Scenario: As a user, I want to be notified with an error message if I provide an invalid phone number, such as one containing alphabetic characters.
    Given user navigate to the register page "https://dev-team8.netlify.app/register"
    When user input a valid email
    * user input a fullname
    * user input a date of birth
    * user input a phone number using alphabetic characters
    * user input a password that matches the criteria
    * user click Sign Up button
    Then inline error message appears for phone number using alphabetic characters

  @register4 @negative
  Scenario: As a user, I want to receive guidance and error messages when attempting to set a password that does not meet the specified criteria, including a minimum length, at least one letter, and one number.
    Given user navigate to the register page "https://dev-team8.netlify.app/register"
    When user input a valid email
    * user input a fullname
    * user input a date of birth
    * user input a phone number
    * user input a password that does not match the criteria
    * user click Sign Up button
    Then inline error message appears that Password require minimum eight characters, at least one letter and one number
