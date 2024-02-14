package steps;

import factories.driverManager;
import helpers.keyword;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.homePage;
import pages.loginPage;

public class commonStep {
    private loginPage getLoginPage() {
        return new loginPage(driverManager.getInstance().getDriver());
    }

    private homePage getHomePage() {
        return new homePage(driverManager.getInstance().getDriver());
    }
    @Given("user navigate to the login page {string}")
    public void navigateToUrlLogin(String url) {
        keyword.navigateToUrl(url);
        getLoginPage().verifyCurrentURL("https://dev-team8.netlify.app/login");
        getLoginPage().verifyComponentOnLoginPage("WELCOME BACK", "Email", "Password", "Remember me", "Forgot password", "Sign Up");
    }

    @Given("user navigate to the home page {string}")
    public void navigateToHomePage(String url) {
        keyword.navigateToUrl(url);
        getLoginPage().verifyCurrentURL("https://dev-team8.netlify.app/");

    }
    @Given("user navigate to the register page {string}")
    public void navigateToUrlRegister(String url) {
        keyword.navigateToUrl(url);
        getLoginPage().verifyCurrentURL("https://dev-team8.netlify.app/register");
    }
    @And("user take screenshot {string}")
    public void user_take_screenshot (String screenshot) {
        keyword.take_screenshot(screenshot);
    }

    @And("user is not logged in to WeFLy")
    public void userIsNotLogin() {
        getHomePage().verifyUserIsNotLogin();
    }

    @And("user navigate to login page")
    public void navigateToLoginPage() {
        getHomePage().userClickLoginButton();
        getLoginPage().verifyCurrentURL("https://dev-team8.netlify.app/login");
        getLoginPage().verifyComponentOnLoginPage("WELCOME BACK", "Email", "Password", "Remember me", "Forgot password", "Sign Up");
    }

    @And("user navigate to login page after click Choose button")
    public void navigateToLoginPageAfterTapChoose() {
        getLoginPage().verifyCurrentURL("https://dev-team8.netlify.app/login");
        getLoginPage().verifyComponentOnLoginPage("WELCOME BACK", "Email", "Password", "Remember me", "Forgot password", "Sign Up");
    }

    @Given("user is already login WeFly")
    public void stepUpLogin() {
        getHomePage().verifyUserIsNotLogin();
        getHomePage().userClickLoginButton();
        getLoginPage().inputEmail("m88mbutftc@waterisgone.com");
        getLoginPage().inputPassword("P@ssw0rd123");
        getLoginPage().clickLogin();
    }

    @Given("user back to home page")
    public void navigateToHomePage(){
        getHomePage().clickHomeButton();

    }

    @And("user navigate to register page")
    public void navigateToRegisterPage() {
        getHomePage().userClickSignInButton();
    }
}