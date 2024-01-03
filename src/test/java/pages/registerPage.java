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

public class registerPage {
    protected WebDriver webDriver;
    public registerPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "user_name")
    private static WebElement input_username;
    @FindBy(id = "user_email")
    private static WebElement input_email;
    @FindBy(id = "user_password")
    private static WebElement input_password;
    @FindBy(xpath = "//input[@type='submit']")
    private static WebElement button_daftar;
    @FindBy(xpath = "//h2[@class='fw-bold mb-5']")
    private WebElement title_page;
    @FindBy(xpath = "//div[@class='form-text text-danger']")
    private static WebElement inline_error;

    public void userRegister(String userName, String email, String password) {
        keyword.inputText(input_username, userName);
        keyword.inputText(input_email, email);
        keyword.inputText(input_password, password);
        keyword.tapElement(button_daftar);
    }
    public void verifyTitlePage(String expectedMessage) {
        String actual = title_page.getText();
        Assert.assertEquals(actual, expectedMessage);
    }
    public static void verifyErrorMessage(String expectedMessage) {
        String actual = inline_error.getText();
        Assert.assertEquals(actual, expectedMessage);
    }
}
