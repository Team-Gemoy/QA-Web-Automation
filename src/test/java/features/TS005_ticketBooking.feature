@ticketBooking
Feature: Ticket Booking

  @ticketBooking @negative  @phase1
  Scenario: As a user, I would like to test the validation if I make a ticket selection while not logged in.
    Given user navigate to the home page "https://dev-team8.netlify.app/"
    * user is not logged in to WeFLy
    When user add number of passenger
    * user select airlines type
    * user input departure airport
    * user input destination airport
    * user click Search button
    * user click Choose button on list

  @ticketBooking @positive  @phase1
  Scenario: As a user, I want to successfully book a flight ticket. (e2e flight ticket booked) & I want to make sure that the validations on the order details are all working (e2e validation of order details)
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