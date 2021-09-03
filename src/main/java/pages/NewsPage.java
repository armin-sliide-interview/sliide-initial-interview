package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static base.Constants.FIRST_IMAGE_URL;
import static org.testng.Assert.*;

public class NewsPage extends BasePage {

    // Locators section
    @AndroidFindBy(id = "action_bar")
    private MobileElement topActionBar;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[1]//android.widget.ImageView")
    private MobileElement firstVerticalItemOnTheList;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[2]//android.widget.ImageView")
    private MobileElement secondVerticalItemOnTheList;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[3]//android.widget.ImageView")
    private MobileElement thirdVerticalItemOnTheList;

    @AndroidFindBy(id = "textViewError")
    private MobileElement newsNotLoadedLabel;

    @AndroidFindBy(id = "retryButton")
    private MobileElement retryButton;

    @AndroidFindBy(id = "com.android.chrome:id/url_bar")
    private MobileElement urlBar;

    public NewsPage(AppiumDriver driver) {
        super(driver);
    }

    // Actions section
    public void clickOnTheFirstImageOnTheList() {
        firstVerticalItemOnTheList.click();
    }

    public String getCurrentUrl() {
        return urlBar.getText();
    }

    // Assertion section
    public void isNewsPageVisible() {
        assertTrue(topActionBar.isDisplayed());
        assertTrue(firstVerticalItemOnTheList.isDisplayed());
        assertTrue(secondVerticalItemOnTheList.isDisplayed());
        assertTrue(thirdVerticalItemOnTheList.isDisplayed());
        String initialElementBounds = firstVerticalItemOnTheList.getAttribute("bounds");
        swipe(true);
        String scrolledElementBounds = firstVerticalItemOnTheList.getAttribute("bounds");
        assertNotEquals(initialElementBounds, scrolledElementBounds);
    }

    public void isErrorNewsLoaded() {
        assertTrue(newsNotLoadedLabel.isDisplayed());
        assertTrue(retryButton.isDisplayed());
    }

    public void isNewImageLoaded() {
        assertEquals(getCurrentUrl(), FIRST_IMAGE_URL);
    }
}