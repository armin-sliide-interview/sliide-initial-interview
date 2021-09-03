import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewsPage;

import java.time.Duration;

import static base.Constants.*;

public class LoginTests extends BaseClass {
    LoginPage loginPage;
    NewsPage newsPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        newsPage = new NewsPage(driver);
    }

    // Feature 1, Scenario 1 - user opens the android app first time (when not logged in yet)
    @Test
    public void loginPageVisibilityTest() {
        loginPage.isLoginPageVisible();
    }

    // Feature 1, Scenario 2 - user login failed
    @Test(priority = 1)
    public void loginWithWrongCredentialsTest() {
        loginPage.loginWithSpecificUser(VALID_USERNAME, INVALID_PASSWORD);
        loginPage.isLoginPageVisible();
        loginPage.loginWithSpecificUser(INVALID_USERNAME, VALID_PASSWORD);
        loginPage.isLoginPageVisible();
        loginPage.loginWithSpecificUser(INVALID_USERNAME, INVALID_PASSWORD);
        loginPage.isLoginPageVisible();
    }

    // Feature 1, Scenario 3 - user login succeed (credentials provided below)
    @Test(priority = 2)
    public void loginWithProperCredentialsTest() {
        loginPage.loginWithSpecificUser(VALID_USERNAME, VALID_PASSWORD);
        newsPage.isNewsPageVisible();
    }

    // Feature 1, Scenario 4 - user opens app next time (when previously logged in)
    @Test(priority = 3)
    public void verifyUserIsLoggedInTest() {
        loginPage.loginWithSpecificUser(VALID_USERNAME, VALID_PASSWORD);
        newsPage.isNewsPageVisible();
        driver.runAppInBackground(Duration.ofSeconds(3));
        driver.launchApp();
        newsPage.isNewsPageVisible();
    }
}