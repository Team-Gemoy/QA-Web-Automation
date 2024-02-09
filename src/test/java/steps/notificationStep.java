package steps;

import factories.driverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.homePage;
import pages.notificationPage;

public class notificationStep {
    private notificationPage getnotificationPage() {
        return new notificationPage(driverManager.getInstance().getDriver());
    }

    private homePage getHomePage() {
        return new homePage(driverManager.getInstance().getDriver());
    }

    @And("user navigate to My Booking page")
    public void navigateToMyBookingPage() {
        getHomePage().clickMyBookingButton();
    }
    @When("user click notification button")
    public void clickNotifButton() {
        getnotificationPage().clickNotifButton();
    }

    @Then("user will see the item on the notification page")
    public void verifyItemOnNotifPageExist() {
        getnotificationPage().verifyItemOnNotifPageExist();
    }

}
