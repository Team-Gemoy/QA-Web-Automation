@login
Feature: Login

  @login @positive
  Scenario: As a user, I should be able to log in using correct registered data on secondhand-binaracademy
    Given user navigate to url "https://secondhand.binaracademy.org/users/sign_in"
    When user login using "correct registered credential"
    Then user direct to dashboard screen
    * user take screenshot "user-login-successfully"



  @login @negative @smoke
  Scenario Outline: As a user, I can't log in using wrong password to secondhand-binaracademy
    Given user navigate to url "https://secondhand.binaracademy.org/users/sign_in"
    When user login using "wrong password"
    Then user verify snackbar error with value "<snackbar_error>" exists
    * user take screenshot "user-failed-login"

    Examples:
      | snackbar_error             |
      | Invalid Email or password. |
