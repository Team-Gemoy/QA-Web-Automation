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
    @FindBy(xpath = "//li[@class='nav-item dropdown fs-5 d-none d-lg-block']")
    private static WebElement profile_icon;
    @FindBy(xpath = "//a[@class='btn btn-alt-primary col rounded-4 py-2 px-4 d-inline-flex align-items-center active']")
    private static WebElement wording_telusuri_kategori;
    @FindBy(xpath = "//div[@class='fs-5 fw-bold']")
    private static WebElement wording_username;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-lg rounded-4 d-inline-flex align-items-center justify-content-space-between px-5']")
    private static WebElement jual_button;

    public static void verify_telusuri_kategori_exist() {
        keyword.validate_element_is_visible_and_enabled(wording_telusuri_kategori);
    }

    public static void verify_profile_user_exist() {
        keyword.tapElement(profile_icon);
        keyword.validate_element_is_visible_and_enabled(wording_username);
    }

    public static void tap_username() {
        keyword.tapElement(wording_username);
    }

    public static void do_verify_profile_data_is_changes(){
        keyword.tapElement(profile_icon);
        keyword.tapElement(wording_username);

    }

    public static void tap_jual_button(){
        keyword.tapElement(jual_button);
    }
}
