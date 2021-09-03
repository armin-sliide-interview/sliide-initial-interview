package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage {

    public AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void swipe(boolean swipeRight) {
        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;
        TouchAction action = new TouchAction(driver);
        if (swipeRight) {
            action.press(point(width / 5, height / 3))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(point(width / 10, height / 3))
                    .release()
                    .perform();
        } else {
            action.press(point(width / 10, height / 3))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(point(width / 5, height / 3))
                    .release()
                    .perform();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}