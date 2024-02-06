package steps;

import factories.driverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.registerPage;
import helpers.randomData;
import org.openqa.selenium.Keys;

public class registerStep {
    private registerPage getRegisterPage() {
        return new registerPage(driverManager.getInstance().getDriver());
    }

    @When("user input a valid email")
    public void inputValidEmail() {
        getRegisterPage().inputEmail(randomData.generateFakeUUID() + "@gmail.com");
    }

    @When("user input a invalid email format")
    public void inputInValidEmail() {
        getRegisterPage().inputEmail("IkanHiuMakanTomatILoveYouSoMuch.CoM");
    }
    @And("user input a fullname")
    public void inputFullname() {
        getRegisterPage().inputFullname(randomData.getFullName());
    }
    @And("user input a date of birth")
    public void inputDateOfBirth() {
        getRegisterPage().inputDayOfBirth("12","July", "1990");
    }
    @And("user input a phone number")
    public void inputPhoneNumber() {
        getRegisterPage().inputPhonenumber("084732543524");
    }
    @And("user input a phone number using alphabetic characters")
    public void inputPhoneNumberAlphabeticCharacters() {
        getRegisterPage().inputPhonenumber("pakealphabethehe");
    }
    @And("user input a password that matches the criteria")
    public void inputPassword() {
        getRegisterPage().inputPassword("P@ssw0rd123");
    }

    @And("user input a password that does not match the criteria")
    public void inputPasswordNotMatchCriteria() {
        getRegisterPage().inputPassword("walawe");
    }

    @And("user click Sign Up button")
    public void clickSignUpButton() {
        getRegisterPage().clickSignUpButton();
    }

    @Then("inline error message appears for each required field")
    public void inlineErrorAppearsEmptyField() {
        getRegisterPage().verifyInlineErrorForEmptyField("Email is required", "Full Name is required", "Phone Number is required", "Password is required");
    }

    @Then("inline error message appears for invalid email format")
    public void inlineErrorAppearsInvalidEmailFormat() {
        getRegisterPage().verifyInlineErrorForInvalidEmailFormat("Please input a valid email format");
    }

    @Then("inline error message appears for phone number using alphabetic characters")
    public void inlineErrorAppearsInvalidPhoneNumber() {
        getRegisterPage().verifyInlineErrorForInvalidPhoneNumber("Invalid phone number");
    }

    @Then("inline error message appears that Password require minimum eight characters, at least one letter and one number")
    public void inlineErrorAppearsPasswordNotMatchCriteria() {
        getRegisterPage().verifyInlineErrorForPasswordNotMatchCriteria("Password require minimum eight characters, at least one uppercase and one number");
    }

    @Then("user should be successfully register")
    public void verifyUserSuccessfullyRegister() {
        getRegisterPage().verifyUserSuccessfullyRegister("Please check email for activation");
    }

    @When("user clear all data on register page")
    public void clearAllData() {
        getRegisterPage().userClearAllData();
    }


}
