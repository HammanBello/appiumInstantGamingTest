package steps;

import drivers.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageObjects.HomePage;
import pageObjects.Page;

public class Hooks {
    private HomePage homePage;
    private AppiumDriver<MobileElement> driver = AppiumDriverManager.getDriver();

    public Hooks(HomePage homePage) {
        this.homePage = homePage;
    }

    @After
    public void closeApp() {
        driver.closeApp();
    }

    @Before()
    public void launchApp() {
        driver.launchApp();
    }
}
