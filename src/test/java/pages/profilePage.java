package pages;

import helpers.keyword;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class profilePage {

    protected WebDriver webDriver;

    public profilePage (WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[1]/h2")
    private static WebElement titlePage;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[1]/p")
    private static WebElement descPage;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/h2")
    private static WebElement PersonalDataCopy;

    @FindBy(id = "fullname")
    private static WebElement input_fullname;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div[1]/div[2]")
    private static WebElement input_day;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div/div/div[1]/div[2]")
    private static WebElement input_month;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[1]/div[2]")
    private static WebElement input_year;

    @FindBy(id = "city")
    private static WebElement input_city;

    @FindBy(id = "phoneNumber")
    private static WebElement input_phoneNumber;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[2]/button[2]")
    private static WebElement saveButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]")
    private static  WebElement snackbarSuccessUpdate;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/p")
    private static WebElement inlineMessageFullname;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div[3]/div[1]/p")
    private static WebElement inlineMessageCity;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div[3]/div[2]/p")
    private static WebElement inlineMessagePhoneNumber;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[2]/button[1]")
    private static WebElement cancelButton;

    public void clearMandatoryData() {
        keyword.clearText(input_fullname);
        keyword.clearText(input_city);
        keyword.clearText(input_phoneNumber);
        keyword.tapElement(input_phoneNumber);
        keyword.tapElement(cancelButton);
        keyword.wait(2);
    }

    public void inlineErrorAllRequiredData(String text1, String text2, String text3) {
        keyword.verifyWordingOnElement(inlineMessageFullname, text1);
        keyword.verifyWordingOnElement(inlineMessageCity, text2);
        keyword.verifyWordingOnElement(inlineMessagePhoneNumber, text3);

    }

    public void inputFullname(String fullname) {
        keyword.clearText(input_fullname);
        keyword.inputText(input_fullname, fullname);
    }

    public void inputDayOfBirth(String day, String month, String year) {
        keyword.tapElement(input_day);
        keyword.wait(1);
        keyword.inputText(input_day, day + Keys.ENTER);
        keyword.tapElement(input_month);
        keyword.wait(1);
        keyword.inputText(input_month, month + Keys.ENTER);
        keyword.tapElement(input_year);
        keyword.wait(1);
        keyword.inputText(input_year, year + Keys.ENTER);
    }

    public void inputCity(String city) {
        keyword.clearText(input_city);
        keyword.inputText(input_city, city);
    }

    public void inputPhoneNumber(String phoneNumber) {
        keyword.clearText(input_phoneNumber);
        keyword.inputText(input_phoneNumber, phoneNumber);
    }

    public void clickSaveButton() {
        keyword.tapElement(saveButton);
        keyword.wait(2);
    }

    public void verifyUpdateProfileSuccessfully(String text) {
        keyword.verifyWordingOnElement(snackbarSuccessUpdate, text);
    }
}
