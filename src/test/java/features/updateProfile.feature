@profile
Feature: Update Profile

  @profile @positive
  Scenario: As a user, I should be able to update profile
    Given user navigate to url "https://secondhand.binaracademy.org/users/sign_in"
    When user login using "correct registered credential"
    * user click profile icon
    * user change user profile data
    Then user verify profile data is changes
    * user take screenshot "user-update-profile-successfully"