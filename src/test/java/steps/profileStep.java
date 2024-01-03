package com.shidqiadiatma.steps;

import com.shidqiadiatma.factories.driverManager;
import com.shidqiadiatma.helpers.randomData;
import com.shidqiadiatma.pages.homePage;
import com.shidqiadiatma.pages.profilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

/**
 * @author Shidqi Adiatma a.k.a. hipstertester on 07/12/23
 * @project secondhand-web-selenium-cucumber
 */

public class profileStep {

    @And("user click profile icon")
    public void userClickProfileIcon(){
        new homePage(driverManager.getInstance().getDriver());
        homePage.verify_profile_user_exist();
        homePage.tap_username();
    }

    @And("user change user profile data")
    public void userChangeProfileData() {
        new profilePage(driverManager.getInstance().getDriver());
        profilePage.user_do_update_profile(
                randomData.getFirstName(),
                randomData.getValue(),
                randomData.getStreetAddress(),
                randomData.getPhoneNumber()
        );
    }

    @Then("user verify profile data is changes")
    public void  userVerifyProfileDataIsChanges() {
        new homePage(driverManager.getInstance().getDriver());
        homePage.do_verify_profile_data_is_changes();
    }
}
