package steps;

import factories.driverManager;
import helpers.keyword;
import pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStep {

    @When("user login using {string}")
    public void loginAs(String credentialType) {

        String email;
        String password;

        switch (credentialType) {
            case "correct registered credential" -> {
                email = "shidqiadiatma@mail.com";
                password = "P@ssw0rd123";
            }
            case "wrong password" -> {
                email = "shidqiadiatma@mail.com";
                password = "wrong_password";
            }
            default -> throw new RuntimeException("credential type doesn't exist");
        }
        loginPage loginPage = new loginPage(driverManager.getInstance().getDriver());
        loginPage.userLogin(email, password);
    }

    @Then("user verify snackbar error with value {string} exists")
    public void  userVerifySnackbarErrorWithValue(String value) {
        new loginPage(driverManager.getInstance().getDriver()).
                verify_snackbar_error_exist(value);
    }

}
