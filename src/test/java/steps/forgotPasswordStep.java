package steps;

import factories.driverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.forgotPasswordPage;
import pages.loginPage;

public class forgotPasswordStep {
    private forgotPasswordPage getForgotPasswordPage() {
        return new forgotPasswordPage(driverManager.getInstance().getDriver());
    }
    private loginPage getLoginPage() {
        return new loginPage(driverManager.getInstance().getDriver());
    }
    @When("user click Forgot Password button")
    public void clickForgotPassword(){
        getLoginPage().navigateToForgotPasswordPage();
    }

    @And("user input invalid email format on forgot password page")
    public void inputInvalidEmailFormat(){
        getForgotPasswordPage().inputInvalidEmailFormat("haiyaaa_walawe.com");
    }

    @And("user click Reset Password button")
    public void clickResetbutton() {
        getForgotPasswordPage().clickResetPasswordButton();
    }
    @Then("user should see Forgot Password page")
    public void verifyForgotPasswordPage(){
        getForgotPasswordPage().verifyUserIsOnForgotPasswordPage("FORGOT PASSWORD");
    }

    @Then("user should see an inline error message that invalid email formatted")
    public void inlineErrorInvalidEmail() {
        getForgotPasswordPage().verifyThereIsInlineError("Please input a valid email format");
    }

    @Then("user should see an inline error message that empty email field")
    public void inlineErrorEmptyField() {
        getForgotPasswordPage().verifyThereIsInlineError("Email is required");
    }

    @Then("user should see an snackbar error message that unregistered email")
    public void inlineErrorUnregisteredEmail() {
        getForgotPasswordPage().verifyThereIsSnackbarError("User credential don't match an account in our system");
    }

    @When("user input unregistered email on forgot password page")
    public void inputUnregisteredEmail() {
        getLoginPage().inputEmail("walawepheiaphei@mail.com");
    }

    @And("user input valid email on forgot password page")
    public void inputValidEmailUser() {
        getLoginPage().inputEmail("m88mbutftc@waterisgone.com");
    }

    @Then("user will redirect to input OTP page")
    public void redirectToInputOTPpage() {
        getForgotPasswordPage().verifyUserIsOnOTPpage();
    }

    @When("user input incorret OTP code")
    public void inputOTPCode() {
        getForgotPasswordPage().inputOTP();
    }

    @And("user click Continue button")
    public void clickContinueButton() {
        getForgotPasswordPage().clickContinueButton();
    }

    @Then("user should see an snackbar error message that invalid OTP")
    public void snackbarErrorExist() {
        getForgotPasswordPage().verifyThereIsSnackBarError();
    }

    @And("back to login page")
    public void backToLoginPage() {
        getForgotPasswordPage().backToLoginPage();
    }
}
