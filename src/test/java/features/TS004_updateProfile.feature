@updateProfile
Feature: Update Profile

  @updateProfile
  Scenario: -
    Given user navigate to the home page "https://dev-team8.netlify.app/"
    * user is already login WeFly
    * user navigate to profile page
    When user change profile data
    * user click Save Button
    Then user should see an snackbar message that update profile successfully

  @updateProfile1
  Scenario: -
    Given user navigate to the home page "https://dev-team8.netlify.app/"
    * user is already login WeFly
    * user navigate to profile page
    When user clear all mandatory field
    * user click Save Button
    Then user should see an inline error message that required data must be filled in


  @End2EndPhase1
  Scenario: -
    Given user navigate to the home page "https://dev-team8.netlify.app/"
    * user is already login WeFly
    * user navigate to profile page
    When user change profile data
    * user click Save Button
    Then user should see an snackbar message that update profile successfully
    * user take screenshot "forgot password without filling in the email field"
