import base.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewsPage;

import static base.Constants.VALID_PASSWORD;
import static base.Constants.VALID_USERNAME;

public class NewsTests extends BaseClass {
    LoginPage loginPage;
    NewsPage newsPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        newsPage = new NewsPage(driver);
        loginPage.loginWithSpecificUser(VALID_USERNAME, VALID_PASSWORD);
    }

    // Feature 2, Scenario 1 - news images are loaded
//    @Test
//    public void newsPageLoadTest() {
//        newsPage.isNewsPageVisible();
//    }
//
//    // Feature 2, Scenario 2 - failed to load images
//    @Test(priority = 1)
//    public void newsPageNegativeLoadTest() {
//        setAndroidDeviceAirplaneMode(true);
//        driver.runAppInBackground(Duration.ofSeconds(1));
//        driver.launchApp();
//        loginPage.loginWithSpecificUser(VALID_USERNAME, VALID_PASSWORD);
//        newsPage.isErrorNewsLoaded();
//        setAndroidDeviceAirplaneMode(false);
//    }


    // Feature 2, Scenario 3 - news image is clicked
    @Test(priority = 2)
    public void navigateToExternalBrowserTest() {
        newsPage.clickOnTheFirstImageOnTheList();
        newsPage.isNewImageLoaded();
    }

    @AfterMethod
    public void teardown() {
        setAndroidDeviceAirplaneMode(false);
    }
}