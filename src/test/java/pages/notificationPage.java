package pages;

import com.google.j2objc.annotations.Weak;
import helpers.keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class notificationPage {

    protected WebDriver webDriver;

    public notificationPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/div/div[2]/a[3]")
    private static WebElement notifButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div[2]/h1")
    private static WebElement flightUpdateCopy;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/h1")
    private static WebElement boarding0ReminderCopy;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div[3]/div[2]/h1")
    private static WebElement arrivalInformationCopy;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div[4]/div[2]/h1")
    private static WebElement weatherAdvisoryCopy;

    public void clickNotifButton() {
        keyword.tapElement(notifButton);
        keyword.wait(5);
    }

    public void verifyItemOnNotifPageExist() {
        keyword.verifyWordingOnElement(flightUpdateCopy, "Flight Update");
        keyword.verifyWordingOnElement(boarding0ReminderCopy, "Boarding Reminder");
        keyword.verifyWordingOnElement(arrivalInformationCopy, "Arrival Information");
        keyword.verifyWordingOnElement(weatherAdvisoryCopy, "Weather Advisory");
        keyword.wait(5);
    }
}
