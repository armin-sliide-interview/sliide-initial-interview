package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

    // Locators section
    @AndroidFindBy(id = "textViewLogo")
    private MobileElement loginImage;

    @AndroidFindBy(id = "editTextUserName")
    private MobileElement usernameTextfield;

    @AndroidFindBy(id = "editTextPassword")
    private MobileElement passwordTextfield;

    @AndroidFindBy(id = "buttonLogin")
    private MobileElement loginButton;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    // Actions section
    public void enterUsername(String username) {
        usernameTextfield.clear();
        usernameTextfield.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordTextfield.clear();
        passwordTextfield.sendKeys(password);
    }

    public void tapOnLoginButton() {
        loginButton.click();
    }

    public void loginWithSpecificUser(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tapOnLoginButton();
    }

    // Assertion section
    public void isLoginPageVisible() {
        assertTrue(loginImage.isDisplayed());
        assertTrue(usernameTextfield.isDisplayed());
        assertTrue(passwordTextfield.isDisplayed());
        assertTrue(loginButton.isDisplayed());
    }
}