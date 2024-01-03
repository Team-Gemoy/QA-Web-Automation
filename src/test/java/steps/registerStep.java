package com.shidqiadiatma.steps;

import com.shidqiadiatma.factories.driverManager;
import com.shidqiadiatma.helpers.keyword;
import com.shidqiadiatma.helpers.randomData;
import com.shidqiadiatma.pages.homePage;
import com.shidqiadiatma.pages.registerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Shidqi Adiatma a.k.a. hipstertester on 07/12/23
 * @project secondhand-web-selenium-cucumber
 */

public class registerStep {

    @When("user registration using {string}")
    public void userRegistrationUsing(String credentialData) {

        String userName = "";
        String email = "";
        String password = "";

        switch (credentialData) {
            case "correct unregistered data" -> {
                userName = randomData.getFullName();
                email    = randomData.getEmail();
                password = "P@ssw0rd123";
            }
            case "registered data" -> {
                userName = "Shidqi Ngetes";
                email    = "udahdiregister@nihbang.com";
                password = "passwordBinar";
            }
            default -> throw new RuntimeException("credential type doesn't exist");
        }
        registerPage RegisterPage = new registerPage(driverManager.getInstance().getDriver());
        RegisterPage.userRegister(userName, email, password);
    }

    @Then("user direct to dashboard screen")
    public void userDirectToDashboardScreen() {
        new homePage(driverManager.getInstance().getDriver());
        homePage.verify_telusuri_kategori_exist();
        homePage.verify_profile_user_exist();
    }

    @And("user take screenshot on dashboard screen {string}")
    public void userTakeScreenshotOnDashboardScreen (String screenshot_1) {
        keyword.take_screenshot(screenshot_1);
    }

    @Then("user verify inline error with value {string} exists")
    public void userVerifyInlineErrorWithValue(String value) {
        new registerPage(driverManager.getInstance().getDriver());
                registerPage.verifyErrorMessage(value);
    }
}
