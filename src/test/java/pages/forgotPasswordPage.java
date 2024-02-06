package pages;

import helpers.keyword;
import org.bouncycastle.cms.PasswordRecipientId;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class forgotPasswordPage {
    protected WebDriver webDriver;

    public forgotPasswordPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/h1")
    private static WebElement titlePage;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/h2")
    private static WebElement underTitlePage;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/input")
    private static WebElement inputEmail;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/button")
    private static WebElement btn_resetPassword;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/p")
    private static WebElement inlineError;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/span[1]")
    private static WebElement snacbarError;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/p")
    private static WebElement copyOnInputOTP;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/input[1]")
    private static WebElement input_otp;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/button")
    private static WebElement continue_button;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div[1]/span[1]")
    private static WebElement snackbarError;

    public void verifyUserIsOnForgotPasswordPage(String text) {
        keyword.verifyWordingOnElement(titlePage, text);
    }

    public void inputInvalidEmailFormat(String Email) {
        keyword.inputText(inputEmail, Email);
    }

    public void clickResetPasswordButton() {
        keyword.tapElement(btn_resetPassword);
    }

    public void verifyThereIsInlineError(String text) {
        keyword.verifyWordingOnElement(inlineError, text);
        keyword.wait(3);
    }

    public void verifyThereIsSnackbarError(String text) {
        keyword.verifyWordingOnElement(snacbarError, text);
        keyword.wait(3);
    }

    public void verifyUserIsOnOTPpage() {
        keyword.verifyWordingOnElement(copyOnInputOTP, "Didn't recieve the email? Click to resend");
    }

    public void inputOTP() {
        keyword.inputText(input_otp, "1111");
    }

    public void clickContinueButton() {
        keyword.tapElement(continue_button);
    }

    public void verifyThereIsSnackBarError() {
        keyword.verifyWordingOnElement(snackbarError, "Check Token Validity Error: OTP is not valid");
        keyword.wait(3);
    }





}
