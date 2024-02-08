package steps;

import factories.driverManager;
import helpers.randomData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;
import pages.profilePage;

public class updateProfileStep {

    private homePage getHomePage() {
        return new homePage(driverManager.getInstance().getDriver());
    }

    private profilePage getProfilePage() {
        return new profilePage(driverManager.getInstance().getDriver());
    }

    @And("user navigate to profile page")
    public void navigateToProfilePage() {
        getHomePage().userClickProfileButton();
    }

    @When("user change profile data")
    public void changeDataProfile() {
        getProfilePage().inputFullname(randomData.getFullName());
        getProfilePage().inputCity(randomData.getCity());
        getProfilePage().inputPhoneNumber("083275432432");
    }

    @And("user click Save Button")
    public void clickSaveButton() {
        getProfilePage().clickSaveButton();
    }

    @Then("user should see an snackbar message that update profile successfully")
    public void updateSuccessfully() {
        getProfilePage().verifyUpdateProfileSuccessfully("Your account has been updated");
    }

    @When("user clear all mandatory field")
    public void clearAllData() {
        getProfilePage().clearMandatoryData();
    }

    @Then("user should see an inline error message that required data must be filled in")
    public void inlineErrorRequiredMstFilledInExist() {
        getProfilePage().inlineErrorAllRequiredData("Full Name is required", "City of Residence is required", "Phone Number is required");
    }
}
