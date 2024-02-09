@updateProfile
Feature: Update Profile

  @updateProfile @positive   @phase1
  Scenario: As a user, I want to successfully update my profile data.
    Given user navigate to the home page "https://dev-team8.netlify.app/"
    * user is already login WeFly
    * user navigate to profile page
    When user change profile data
    * user click Save Button
    Then user should see an snackbar message that update profile successfully

  @updateProfile @negative  @phase1
  Scenario: As a user, I would like to make sure that I will fail to update my profile if I fill in my phone number alphabetically.
    Given user navigate to the home page "https://dev-team8.netlify.app/"
    * user is already login WeFly
    * user navigate to profile page
    When user changes phone number with alphabet
    * user click Save Button
    Then user should see an inline error message that Invalid phone number

  @updateProfile @negative   @phase1
  Scenario: As a user, I want to make sure that the profile update will fail if I don't enter all the required data.
    Given user navigate to the home page "https://dev-team8.netlify.app/"
    * user is already login WeFly
    * user navigate to profile page
    When user clear all mandatory field
    * user click Save Button
    Then user should see an snackbar message that update profile successfully

