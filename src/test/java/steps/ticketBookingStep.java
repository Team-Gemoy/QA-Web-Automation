package steps;

import factories.driverManager;
import helpers.keyword;
import helpers.randomData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.airlinesListPage;
import pages.homePage;
import pages.orderDetailsPage;

public class ticketBookingStep {

    private homePage getHomePage() {
        return new homePage(driverManager.getInstance().getDriver());
    }
    private airlinesListPage getAirlinesListPage() {
        return new airlinesListPage(driverManager.getInstance().getDriver());
    }

    private orderDetailsPage getOrderDetailsPage() {
        return new orderDetailsPage(driverManager.getInstance().getDriver());
    }

    @And("user click Choose button on list")
    public void clickChoose() {
        getAirlinesListPage().clickChooseButton();
    }


    @When("user input departure airport")
    public void selectDepartureAirport() {
        getHomePage().inputDepartureAirport();
    }

    @And("user input destination airport")
    public void selectDestinationAirport() {
        getHomePage().inputDestinationAirport();
    }

    @And("user click Search button")
    public void clickSearch() {
        getHomePage().clickSearchButton();
    }

    @When("user add number of passenger")
    public void addNumberOfPassenger() {
        getHomePage().enterPassengerType();
    }

    @And("user select airlines type")
    public void selectAirlinesType() {
        getHomePage().enterAirlinesType();
    }

    @And("user click Pay Now button")
    public void clickPayNowButton() {
        getOrderDetailsPage().clickPayNowButton();
    }
    @And("user filled in all mandatory data in order details")
    public void filledInAllMandatoryDataPassengers() {
        getOrderDetailsPage().clickSwitchButton();
        getOrderDetailsPage().clickPencilIcon1();
        keyword.wait(3);
        getOrderDetailsPage().clickSaveButton();
        getOrderDetailsPage().fillInAdultPassengerData(randomData.getNationality());
        getOrderDetailsPage().clickSaveButton();
        getOrderDetailsPage().clickPencilIcon2();
        keyword.wait(3);
        getOrderDetailsPage().clickSaveButton();
        getOrderDetailsPage().inlineErrorExistOnOrderDetails();
        getOrderDetailsPage().fillInChildPassengerData(randomData.getFirstName(), randomData.getLastName(), randomData.getNationality(), "16", "January", "2017");
        getOrderDetailsPage().clickSaveButton();
    }

    @Then("user redirect to My Booking Page")
    public void verifyPaymentGateway() {
        getOrderDetailsPage().verifyStepUpTicketBookingSuccessfully();
    }
}
