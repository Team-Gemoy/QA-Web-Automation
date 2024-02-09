package pages;

import helpers.keyword;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class homePage {
    protected WebDriver webDriver;
    public homePage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/section/div/div/div/h1")
    private static WebElement title_dashboard;

    @FindBy(xpath = "/html/body/div[1]/nav/div[1]/div/div/a[1]")
    private static WebElement loginButtonOnHeader;

    @FindBy(xpath = "/html/body/div[1]/nav/div[1]/div/div/a[2]")
    private static WebElement SignUpButtonOnHeader;

    @FindBy(xpath = "/html/body/div[1]/nav/div[1]/div/div/a")
    private static WebElement profileButtonOnHeader;

    @FindBy(xpath = "/html/body/div/div/nav/div[2]/ul/li[1]")
    private static WebElement homeButtonOnHeader;

    @FindBy(xpath = "/html/body/div[1]/section[1]/div[1]/div/div/div[2]/div[1]/div[1]/div/div/div/div[1]/div[2]/input")
    private static WebElement input_from;

    @FindBy(xpath = "/html/body/div[1]/section[1]/div[1]/div/div/div[2]/div[1]/div[2]/div/div/div/div[1]/div[2]/input")
    private static WebElement input_to;

    @FindBy(xpath = "/html/body/div[1]/section[1]/div[1]/div/div/div[2]/div[3]/button")
    private static WebElement searchButton;

    @FindBy(xpath = "/html/body/div[1]/section[1]/div[1]/div/div/div[1]/div[2]/div[1]/button")
    private static WebElement numberOfPassengerTypes;

    @FindBy(xpath = "/html/body/div[1]/section[1]/div[1]/div/div/div[1]/div[2]/div[1]/div/div/div/div[3]/div/div[2]/button[2]")
    private static WebElement addChildPassengers;

    @FindBy(xpath = "/html/body/div[1]/section[1]/div[1]/div/div/div[1]/div[2]/div[1]/div/div/div/div[4]/button")
    private static WebElement doneButton;

    @FindBy(xpath = "/html/body/div[1]/section[1]/div[1]/div/div/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/input")
    private static WebElement typeOfAirlines;

    @FindBy(xpath = "/html/body/div[1]/nav/div[2]/ul/li[2]")
    private static WebElement MyBookingButton;

    public void clickMyBookingButton() {
        keyword.tapElement(MyBookingButton);
        keyword.wait(1);
    }

    public void enterPassengerType() {
        keyword.tapElement(numberOfPassengerTypes);
        keyword.tapElement(addChildPassengers);
        keyword.tapElement(doneButton);
    }

    public void enterAirlinesType() {
        keyword.tapElement(typeOfAirlines);
        keyword.wait(1);
        keyword.inputText(typeOfAirlines, "Business" + Keys.ENTER);
    }

    public void inputDepartureAirport() {
        keyword.tapElement(input_from);
        keyword.wait(2);
        keyword.inputText(input_from, "CGK" + Keys.ENTER);
    }

    public void inputDestinationAirport() {
        keyword.tapElement(input_to);
        keyword.wait(2);
        keyword.inputText(input_to, "DPS" + Keys.ENTER);
    }

    public void clickSearchButton() {
        keyword.tapElement(searchButton);
        keyword.wait(2);
    }

    public void clickHomeButton() {
        keyword.tapElement(homeButtonOnHeader);
        keyword.wait(2);
    }
    public void userClickProfileButton() {
        keyword.tapElement(profileButtonOnHeader);
        keyword.wait(3);
    }
    public void verifyUserAlreadyOnDashboard() {
        keyword.verifyWordingOnElement(title_dashboard, "WeFly - Limitless Travel Solutions");
        keyword.wait(2);
    }

    public void verifyUserIsNotLogin() {
        keyword.verifyWordingOnElement(loginButtonOnHeader, "Log In");
        keyword.verifyWordingOnElement(SignUpButtonOnHeader, "Sign Up");
    }

    public void userClickLoginButton() {
        keyword.tapElement(loginButtonOnHeader);
        keyword.wait(2);
    }

    public void userClickSignInButton() {
        keyword.tapElement(SignUpButtonOnHeader);
        keyword.wait(2);
    }



}
