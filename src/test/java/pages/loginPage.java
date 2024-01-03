package com.shidqiadiatma.pages;

import com.shidqiadiatma.helpers.keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

/**
 * @author Shidqi Adiatma a.k.a. hipstertester on 07/12/23
 * @project secondhand-web-selenium-cucumber
 */

public class loginPage {
    protected WebDriver webDriver;

    public loginPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "user_email")
    private static WebElement input_email;
    @FindBy(id = "user_password")
    private static WebElement input_password;
    @FindBy(xpath = "//input[@type='submit']")
    private static WebElement button_login;
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement title_page;
    @FindBy(xpath = "//div[@role='alert']")
    private WebElement snackbar_error;

    public void userLogin(String email, String password) {
        keyword.inputText(input_email, email);
        keyword.inputText(input_password, password);
        keyword.tapElement(button_login);
    }

    public void verifyTitlePage(String expectedMessage) {
        String actual = title_page.getText();
        Assert.assertEquals(actual, expectedMessage);
    }
    public void verify_snackbar_error_exist(String expectedMessage) {
        String actual = snackbar_error.getText();
        Assert.assertEquals(actual, expectedMessage);
    }

    public static void verifyCurrentURL(String url) {
        keyword.assert_current_url(url);
    }
}
