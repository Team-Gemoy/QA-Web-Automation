package pages;

import helpers.keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class loginPage {
    protected WebDriver webDriver;

    public loginPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[1]/label")
    private static WebElement label_email;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[2]/label")
    private static WebElement label_password;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[3]/div/label")
    private static WebElement label_rememberMe;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/div[3]/a")
    private static WebElement label_forgotPassword;

    @FindBy(id = "Email")
    private static WebElement input_email;
    @FindBy(id = "password")
    private static WebElement input_password;

    @FindBy(id = "signin")
    private static WebElement button_login;
    @FindBy(xpath = "//span[@class='block sm:inline']")
    private static WebElement alert_message;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/p[1]")
    private static WebElement inlineEmail;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/form/p[2]")
    private static WebElement inlinePassword;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/h1")
    private WebElement title_page;
    @FindBy(id = "check")
    private WebElement checkbox_rememberMe;
    @FindBy(xpath = "//a[@href='/register']")
    private WebElement btnLink_signUp;

    @FindBy(xpath = "/html/body/div/div/div[1]/div[2]/span[2]")
    private static WebElement closeSnackbar;

    public void navigateToForgotPasswordPage() {
        keyword.tapElement(label_forgotPassword);
    }

    public void verifyComponentOnLoginPage(String text1, String text2, String text3,String text4, String text5, String text6) {
        keyword.verifyWordingOnElement(title_page, text1);
        keyword.verifyWordingOnElement(label_email, text2);
        keyword.verifyWordingOnElement(label_password, text3);
        keyword.verifyWordingOnElement(label_rememberMe, text4);
        keyword.verifyWordingOnElement(label_forgotPassword, text5);
        keyword.verifyWordingOnElement(btnLink_signUp, text6);
    }

    public void inputEmail(String email) {
        keyword.clearText(input_email);
        keyword.inputText(input_email, email);
    }

    public void inputPassword(String password) {
        keyword.inputText(input_password, password);
    }

    public void clickLogin() {
        keyword.tapElement(button_login);
    }

    public void clickCheckbox() {
        keyword.tapElement(checkbox_rememberMe);
    }

    public void alertSnackbarMessage(String text) {
        keyword.verifyWordingOnElement(alert_message,text);
        keyword.wait(2);
    }

    public void closeSnackbar() {
        keyword.tapElement(closeSnackbar);
        keyword.wait(2);
    }

    public void alertInlineMessageForEmptyScenario(String text1, String text2) {
        keyword.verifyWordingOnElement(inlineEmail,text1);
        keyword.verifyWordingOnElement(inlinePassword,text2);
        keyword.wait(2);

    }
    public void alertInlineMessageForInvalidFormatEmail(String text1) {
        keyword.verifyWordingOnElement(inlineEmail,text1);
        keyword.wait(2);
    }

    public void verifyCurrentURL(String url) {
        keyword.assert_current_url(url);
        keyword.wait(2);
    }

    public void userClickForgotPassword() {
        keyword.tapElement(label_forgotPassword);
        keyword.wait(2);
    }
}
