package pages;

import helpers.keyword;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class orderDetailsPage {

    protected WebDriver webDriver;

    public orderDetailsPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/section/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/label/div")
    private static WebElement switchButton;

    @FindBy(css = ".text-primary-blue.text-lg.cursor-pointer:nth-of-type(1)")
    private static WebElement pencil_icon1;

    @FindBy(css = ".text-primary-blue.text-lg.cursor-pointer:nth-of-type(2)")
    private static WebElement pencil_icon2;

    @FindBy(name = "nationality")
    private static WebElement input_nationality;

    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div[2]/button")
    private static WebElement saveButton;

    @FindBy(id = "First Name")
    private static WebElement input_firstName;

    @FindBy(id = "Last Name")
    private static WebElement input_lastName;

    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div[2]/div[4]/div/div[1]/div/div/div[1]/div[2]/input")
    private static WebElement input_day;

    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div[2]/div[4]/div/div[2]/div/div/div[1]/div[2]/input")
    private static WebElement input_month;

    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div[2]/div[4]/div/div[3]/div/div/div[1]/div[2]/input")
    private static WebElement input_year;

    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div[2]/div[5]/div[3]/input")
    private static WebElement missRadioButton;

    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div[2]/div[1]/p")
    private static WebElement inlineErrorFirstName;

    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div[2]/div[2]/p")
    private static WebElement inlineErrorLastName;

    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div[2]/div[3]/p")
    private static WebElement inlineErrorNationality;

    @FindBy(xpath = "/html/body/div[1]/section/div[1]/div/div[2]/div[2]/button")
    private static WebElement PayNowButton;

    @FindBy(xpath = "/html/body/div/div/div[1]/div[2]/div/div[1]/div[3]/button")
    private static WebElement OpenPaymentLinkButtonOnMyBookingPage;

    public void verifyStepUpTicketBookingSuccessfully() {
        keyword.verifyWordingOnElement(OpenPaymentLinkButtonOnMyBookingPage, "Open Payment Link");
        keyword.wait(7);
    }

    public void clickPayNowButton() {
        keyword.tapElement(PayNowButton);
    }

    public void clickSwitchButton() {
        keyword.tapElement(switchButton);
    }

    public void clickPencilIcon1() {
        keyword.tapElement(pencil_icon1);
        keyword.wait(1);
    }

    public void clickPencilIcon2() {
        keyword.tapElement(pencil_icon2);
        keyword.wait(1);
    }
    public void fillInAdultPassengerData() {
        keyword.inputText(input_nationality, "Indonesia");
    }

    public void fillInChildPassengerData() {
        keyword.inputText(input_firstName, "Tina");
        keyword.inputText(input_lastName, "Agustina");
        keyword.inputText(input_nationality, "Indonesia");
        keyword.inputText(input_day, "13" + Keys.ENTER);
        keyword.inputText(input_month, "January" + Keys.ENTER);
        keyword.inputText(input_year, "2016" + Keys.ENTER);
        keyword.tapElement(missRadioButton);
    }

    public void clickSaveButton() {
        keyword.tapElement(saveButton);
        keyword.wait(2);
    }

    public void inlineErrorExistOnOrderDetails() {
        keyword.verifyWordingOnElement(inlineErrorFirstName, "First Name is required");
        keyword.verifyWordingOnElement(inlineErrorLastName, "Last Name is required");
        keyword.verifyWordingOnElement(inlineErrorNationality, "Nationality is required");
    }
}
