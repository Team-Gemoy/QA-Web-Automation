package pages;

import helpers.keyword;
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

    public void verifyUserAlreadyOnDashboard() {
        keyword.verifyWordingOnElement(title_dashboard, "WeFly - Limitless Travel Solutions");
    }

}
