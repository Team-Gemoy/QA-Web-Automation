@ticketBooking
Feature: Registration User

  @notLogin
  Scenario: As a user, I want to test all validations on the register page
    Given user navigate to the home page "https://dev-team8.netlify.app/"
    * user is not logged in to WeFLy
    When user add number of passenger
    * user select airlines type
    * user input departure airport
    * user input destination airport
    * user click Search button
    * user click Choose button on list

  @ticketBooking1 @login
  Scenario: As a user, I want to test all validations on the register page
    Given user navigate to the home page "https://dev-team8.netlify.app/"
    * user is already login WeFly
    When user add number of passenger
    * user select airlines type
    * user input departure airport
    * user input destination airport
    * user click Search button
    * user click Choose button on list
    * user filled in all mandatory data in order details
    * user click Pay Now button
    Then user redirect to My Booking Page