package com.shidqiadiatma.pages;

import com.shidqiadiatma.helpers.keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

/**
 * @author Shidqi Adiatma a.k.a. hipstertester on 07/12/23
 * @project secondhand-web-selenium-cucumber
 */

public class sellProductPage {
    protected WebDriver webDriver;
    public sellProductPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);}

    @FindBy(id = "product_name")
    private static WebElement input_productName;
    @FindBy(id = "product_price")
    private static WebElement input_price;
    @FindBy(id = "product_category_id")
    private static WebElement select_category;
    @FindBy(id = "product_description")
    private static WebElement input_description;
    @FindBy(xpath = "//label[@class='btn btn-outline-primary w-50 rounded-4 p-3']")
    private static WebElement preview_button;
    @FindBy(xpath = "//label[@class='btn btn-primary w-50 rounded-4 p-3']")
    private static WebElement terbitkan_button;
    @FindBy(xpath = "//h5[@class='card-title fs-5 fw-bolder']")
    private static WebElement title_product;

    @FindBy(xpath = "//input[@value='Terbitkan']")
    private static WebElement TerbitkanButton_onPreviewScreen;


    public static void productSell(String productName, String productPrice, String option, String description) {
        keyword.inputText(input_productName, productName);
        keyword.inputText(input_price, productPrice);
        keyword.selectOption(select_category,option);
        keyword.inputText(input_description, description);
    }
    public static void tapTerbitkanButton() {
        keyword.tapElement(terbitkan_button);
    }

    public static void tapPreviewButton() {
        keyword.tapElement(preview_button);
    }


    public static void verifyProduct() {
        keyword.validate_element_is_visible_and_enabled(title_product);
    }

    public static void verifyUserIsOnPreviewScreen() {
        keyword.validate_element_is_visible_and_enabled(TerbitkanButton_onPreviewScreen);
    }
}
