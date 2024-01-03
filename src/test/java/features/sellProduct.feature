@sell
Feature: Update Profile

  @sell @positive
  Scenario: As a user, I should be able to sell the product
    Given user navigate to url "https://secondhand.binaracademy.org/users/sign_in"
    When user login using "correct registered credential"
    * user click jual button
    * user fills in all product data
    * user click Terbitkan button
    Then user verify product uploaded successfully
    * user take screenshot "user-sell-product-successfully"

  @sell @positive
  Scenario: As a user, I can preview the product before selling it.
    Given user navigate to url "https://secondhand.binaracademy.org/users/sign_in"
    When user login using "correct registered credential"
    * user click jual button
    * user fills in all product data
    * user click Preview button
    Then user verify can see the preview screen
    * user take screenshot "user-is-on-preview-screen"

  @sell @negative
  Scenario Outline: As a user, I can't sell product if i not login
    Given user navigate to url "https://secondhand.binaracademy.org/"
    When user click jual button
    Then user verify snackbar error with value "<snackbar_error>" exists
    * user take screenshot "user-is-on-login-screen-and-failed-to-sell-product"

    Examples:
      | snackbar_error                                    |
      | You need to sign in or sign up before continuing. |

