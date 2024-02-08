@notification
Feature: Notification

  @notification
  Scenario: As a user, I want to see notifications
    Given user navigate to the home page "https://dev-team8.netlify.app/"
    * user is already login WeFly
    * user navigate to My Booking page
    When user click notification button
    Then user will see the item on the notification page