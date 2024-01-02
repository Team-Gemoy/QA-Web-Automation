package factories;

import org.openqa.selenium.WebDriver;

/**
 * @author Shidqi Adiatma a.k.a. hipstertester on 07/12/23
 * @project secondhand-web-selenium-cucumber
 */

public class driverManager {

    private static final driverManager instance = new driverManager();
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private driverManager() {
    }

    public static driverManager getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }
}
