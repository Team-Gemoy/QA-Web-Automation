@regression
Feature: Registration, Forgot Password, Login, Update Profile, Ticket Booking

  @regression @end2end
  Scenario: As a user, I wanted to test all the functional features in WeFly

    #   Registration User   #
    Given user navigate to the home page "https://dev-team8.netlify.app/"
    #1.  Verify that the user failed to register due to not filling in all the required data. (empty field)
    * user is not logged in to WeFLy
    * user navigate to register page
    When user click Sign Up button
    Then inline error message appears for each required field
    * user take screenshot "register-by-not-filling-in-all-required-data"
    #2.  Verify that the user failed to register due to using an invalid email when registering. (invalid email format)
    When user input a invalid email format
    * user input a fullname
    * user input a date of birth
    * user input a phone number
    * user input a password that matches the criteria
    * user click Sign Up button
    Then inline error message appears for invalid email format
    * user take screenshot "register-with-invalid-email-format"
    #3.  Verify that the user failed to register because they used an alphabetical mobile number. (alphabetic characters on phone number)
    When user input a valid email
    * user input a fullname
    * user input a phone number using alphabetic characters
    * user input a password that matches the criteria
    * user click Sign Up button
    Then inline error message appears for phone number using alphabetic characters
    * user take screenshot "register-with-alphabetic-characters-on-phone-number"
    #4.  Verify that the user failed to register due to using a password that does not match the criteria. (incorrect password format criteria)
    When user input a valid email
    * user input a fullname
    * user input a phone number
    * user input a password that does not match the criteria
    * user click Sign Up button
    Then inline error message appears that Password require minimum eight characters, at least one letter and one number
    * user take screenshot "register-with-a-password-that-does-not-match-the-criteria"
    #5.  Verify that the user has successfully registered by filling in the data according to the requirements.
    When user input a valid email
    * user input a fullname
    * user input a phone number
    * user input a password that matches the criteria
    * user click Sign Up button
    Then user should be successfully register
    * user take screenshot "user-successfully-register"

    #   Forgot Password   #
    #6.  Verify that the validation on email input in the forgot password feature for empty fields works. (empty field)
    Given navigate to login page
    * navigate to forgot password page
    When user click Reset Password button
    Then user should see an inline error message that empty email field
    * user take screenshot "forgot-password-without-filling in-the-email-field"
    #7.  Verify that the validation on email input in the forgot password feature for invalid email formats works. (invalid email format)
    When user input invalid email format on forgot password page
    * user click Reset Password button
    Then user should see an inline error message that invalid email formatted
    * user take screenshot "forgot-password-with-invalid-email-format"
    #8.  Verify that the validation on email input in the forgot password for unregistered email feature works. (unregistered email)
    When user input unregistered email on forgot password page
    * user click Reset Password button
    Then user should see an snackbar error message that unregistered email
    * user take screenshot "forgot-password-with-unregistered-email"
    #9.  Verify that the user has successfully passed the email input step in the password forgot using a valid email. (input valid email)
    When user input valid email on forgot password page
    * user click Reset Password button
    Then user will redirect to input OTP page
    * user take screenshot "forgot-password-without-filling-in-the-email-field"
    #10.  Verify that the validation on OTP code input in the forgot password feature works for incorrect OTP codes. (incorrect OTP codes)
    When user input incorret OTP code
    * user click Continue button
    Then user should see an snackbar error message that invalid OTP

    #   Login User    #
    Given back to login page
    #11.  Verify that the user has failed to login with the wrong password. (wrong password)
    When user input valid email
    * user input incorrect password
    * user click Login button
    Then user should see an snackbar error message for incorrect password
    * user take screenshot "login-using-incorrect-password"
    #12.  Verify that the user has failed to login with an unregistered/unactivated account. (unregistered/unactivated account)
    When user input unregistered email
    * user input correct password
    * user click Login button
    Then user should see an snackbar error message for unregistered email
    * user take screenshot "login-using-unregistered-email"
    #13.  Verify that the user failed to log in with no email and password. (empty fields)
    When user click Login button
    Then user should see an error message indicating empty fields
    * user take screenshot "login-using-empty-fields"
    #14.  Verify that the user failed to log in using an email with an invalid format. (invalid email formatted)
    When user input invalid email format
    Then user should see an error message indicating invalid email format
    * user take screenshot "login-using-invalid-email-formatted"
    #15.  Verify that the user is successfully logged in with a valid and registered email and password. (valid email & password)
    When user input valid email
    * user input correct password
    * user click Login button
    Then user should be successfully login
    * user take screenshot "user-successfully-login"

    #   Update Profile    #
    #16.  Verify that the user failed to update the profile by filling in the cell phone number with the alphabet. (invalid phone number formated)
    Given user navigate to profile page
    When user changes phone number with alphabet
    * user click Save Button
    Then user should see an inline error message that Invalid phone number
    #17.  Verify that the user has successfully updated the user profile data. (update profile successfully)
    When user change profile data
    * user click Save Button
    Then user should see an snackbar message that update profile successfully
    * user take screenshot "update-profile-data-successfully"

    #   Ticket Booking    #
    #18.  Verify that the user has successfully booked a flight ticket. (e2e flight ticket booked)
    #19.  Verify that the validations on the order details are all working (e2e order details validation)
    Given user back to home page
    When user add number of passenger
    * user select airlines type
    * user input departure airport
    * user input destination airport
    * user click Search button
    * user click Choose button on list
    * user filled in all mandatory data in order details
    * user click Pay Now button
    Then user redirect to My Booking Page
    * user take screenshot "ticket-booking-successfully"

    # Notification   #
    #20.  Verify that there is a notification feature for users.
    When user click notification button
    Then user will see the item on the notification page
