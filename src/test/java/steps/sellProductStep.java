package com.shidqiadiatma.steps;

import com.shidqiadiatma.factories.driverManager;
import com.shidqiadiatma.helpers.randomData;
import com.shidqiadiatma.pages.homePage;
import com.shidqiadiatma.pages.loginPage;
import com.shidqiadiatma.pages.sellProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

/**
 * @author Shidqi Adiatma a.k.a. hipstertester on 07/12/23
 * @project secondhand-web-selenium-cucumber
 */

public class sellProductStep {

    @And("user click jual button")
    public void userClickJualButton(){
        new homePage(driverManager.getInstance().getDriver());
        homePage.tap_jual_button();
    }

    @And("user fills in all product data")
    public void userFillsInAllProductData() {
        new sellProductPage(driverManager.getInstance().getDriver());
        sellProductPage.productSell(
                randomData.getProductName(),
                randomData.getProductPrice(),
                randomData.getValue(),
                randomData.getDescription()
        );
    }

    @And("user click Terbitkan button")
    public void userClickTerbitkanButton() {
        new sellProductPage(driverManager.getInstance().getDriver());
        sellProductPage.tapTerbitkanButton();
    }

    @And("user click Preview button")
    public void userClickPreviewButton() {
        new sellProductPage(driverManager.getInstance().getDriver());
        sellProductPage.tapPreviewButton();
    }

    @Then("user verify product uploaded successfully")
    public void userVerifyProductUploadedSuccessfully() {
        new sellProductPage(driverManager.getInstance().getDriver());
        sellProductPage.verifyProduct();
    }

    @Then("user verify can see the preview screen")
    public void userVerifyCanSeeThePreviewScreen() {
        new sellProductPage(driverManager.getInstance().getDriver());
        sellProductPage.verifyUserIsOnPreviewScreen();
    }

    @Then("user redirect to login page {string}")
    public void userRedirectToLoginPage(String url) {
        new loginPage(driverManager.getInstance().getDriver());
        loginPage.verifyCurrentURL(url);
    }
}
