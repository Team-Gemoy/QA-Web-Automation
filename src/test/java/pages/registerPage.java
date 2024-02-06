package pages;

import helpers.keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import org.openqa.selenium.Keys;

public class registerPage {

    protected WebDriver webDriver;

    public registerPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/h1")
    private static WebElement title_page;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div[1]/label")
    private static WebElement label_email;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div[2]/label")
    private static WebElement label_fullname;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div[3]/label")
    private static WebElement label_dateofbirth;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div[4]/label")
    private static WebElement label_phonenumber;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div[5]/label")
    private static WebElement label_password;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div[6]/label")
    private static WebElement label_tnc;

    @FindBy(id = "email")
    private static WebElement input_email;

    @FindBy(id = "fullname")
    private static WebElement input_fullname;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div[3]/div/div[1]/div/div/div[1]/div[2]/input")
    private static WebElement input_day;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div[3]/div/div[2]/div/div/div[1]/div[2]/input")
    private static WebElement input_month;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div[3]/div/div[3]/div/div/div[1]/div[2]/input")
    private static WebElement input_year;

    @FindBy(id = "phoneNumber")
    private static WebElement input_phoneNumber;

    @FindBy(id = "password")
    private static WebElement input_password;

    @FindBy(id = "signup")
    private static WebElement button_register;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/p[1]")
    private static WebElement inlineError_Email;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/p[2]")
    private static WebElement inlineError_Fullname;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/p[3]")
    private static WebElement inlineError_PhoneNumber1;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/p")
    private static WebElement inlineError_PhoneNumber2;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/p[4]")
    private static WebElement inlineError_Password1;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/p")
    private static WebElement inlineError_Password2;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[3]/span[1]")
    private static WebElement snackbar_successfullyRegister;



    public void inputEmail(String email) {
        keyword.clearText(input_email);
        keyword.inputText(input_email, email);
    }

    public void inputFullname(String fullname) {
        keyword.clearText(input_fullname);
        keyword.inputText(input_fullname, fullname);
    }

    public void inputDayOfBirth(String day, String month, String year) {
        keyword.inputText(input_day, day + Keys.ENTER);
        keyword.inputText(input_month, month + Keys.ENTER);
        keyword.inputText(input_year, year + Keys.ENTER);
    }

    public void inputPhonenumber(String phonenumber) {
        keyword.clearText(input_phoneNumber);
        keyword.inputText(input_phoneNumber, phonenumber);
    }

    public void inputPassword(String password) {
        keyword.clearText(input_password);
        keyword.inputText(input_password, password);
    }

    public void clickSignUpButton() {
        keyword.tapElement(button_register);
    }

    public void verifyInlineErrorForEmptyField(String inlineEmail, String inlineFullname, String inlinePhonenumber, String inlinePassword) {
        keyword.verifyWordingOnElement(inlineError_Email, inlineEmail);
        keyword.verifyWordingOnElement(inlineError_Fullname, inlineFullname);
        keyword.verifyWordingOnElement(inlineError_PhoneNumber1, inlinePhonenumber);
        keyword.verifyWordingOnElement(inlineError_Password1, inlinePassword);

    }
    public void verifyInlineErrorForInvalidEmailFormat(String inlineEmail) {
        keyword.verifyWordingOnElement(inlineError_Email, inlineEmail);
        keyword.wait(3);
    }

    public void verifyInlineErrorForInvalidPhoneNumber(String inlinePhoneNumber) {
        keyword.verifyWordingOnElement(inlineError_PhoneNumber2, inlinePhoneNumber);
        keyword.wait(3);
    }

    public void verifyInlineErrorForPasswordNotMatchCriteria(String inlinePassword) {
        keyword.verifyWordingOnElement(inlineError_Password2, inlinePassword);
        keyword.wait(3);
    }

    public void verifyUserSuccessfullyRegister(String text) {
        keyword.verifyWordingOnElement(snackbar_successfullyRegister, text);
        keyword.wait(3);
    }

    public void userClearAllData() {
        keyword.clearText(input_email);
        keyword.clearText(input_fullname);
        keyword.clearText(input_phoneNumber);
        keyword.clearText(input_password);
        keyword.wait(3);
    }

}
