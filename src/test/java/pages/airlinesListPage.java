package pages;

import helpers.keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class airlinesListPage {

    protected WebDriver webDriver;
    public airlinesListPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[3]/button")
    private static WebElement chooseButton;

    public void clickChooseButton() {
        keyword.tapElement(chooseButton);
        keyword.wait(1);
    }
}
