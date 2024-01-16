package pages;

import helpers.keyword;
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
    }



}
