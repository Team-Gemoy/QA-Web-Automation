package steps;

import factories.driverManager;
import helpers.keyword;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.loginPage;

public class commonStep {
    private loginPage getLoginPage() {
        return new loginPage(driverManager.getInstance().getDriver());
    }

    @Given("user navigate to the login page {string}")
    public void navigateToUrl(String url) {
        keyword.navigateToUrl(url);
        getLoginPage().verifyCurrentURL("https://dev-team8.netlify.app/login");
        getLoginPage().verifyComponentOnLoginPage("WELCOME BACK", "Email", "Password", "Remember me", "Forgot password");
    }
    @And("user take screenshot {string}")
    public void user_take_screenshot (String screenshot) {
        keyword.take_screenshot(screenshot);
    }
}