@register
Feature: Register

  @register @positive
  Scenario: As a user, I should be able to register with an unregistered email on secondhand-binaracademy.
    Given user navigate to url "https://secondhand.binaracademy.org/users/sign_up"
    When user registration using "correct unregistered data"
    Then user direct to dashboard screen
    * user take screenshot "user-register-successfully"

  @register @negative
  Scenario Outline: As a user, I shouldn't be able to register with a registered email on secondhand-binaracademy.
    Given user navigate to url "https://secondhand.binaracademy.org/users/sign_up"
    When user registration using "registered data"
    Then user verify inline error with value "<errorMessage>" exists
    * user take screenshot "user-failed-register"

    Examples:
      | errorMessage                 |
      | Email has already been taken |