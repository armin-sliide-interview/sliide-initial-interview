package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static AppiumDriver driver;
    public static String serverURL = "http://0.0.0.0:4723/wd/hub";
    private final String userDirectory = System.getProperty("user.dir");
    private final String platformVersion = System.getProperty("platformVersion");
    private final String deviceName = System.getProperty("deviceName");
    private final String androidAppPath = userDirectory + "/src/main/resources/sliide-initial-interview.apk";

    public static void setAndroidDeviceAirplaneMode(boolean status) {
        try {
            String airplaneModeStatus = "";
            if (status) {
                airplaneModeStatus = "1";
            } else {
                airplaneModeStatus = "0";
            }
            String sdkPath = System.getenv("ANDROID_HOME") + "/platform-tools/";
            Runtime.getRuntime().exec(sdkPath + "adb shell settings put global airplane_mode_on " + airplaneModeStatus);
            Thread.sleep(1000);
            Process process = Runtime.getRuntime()
                    .exec(sdkPath + "adb shell am broadcast -a android.intent.action.AIRPLANE_MODE");
            process.waitFor();
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeMethod
    public void driverSetup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.APP, androidAppPath);
        driver = new AppiumDriver(new URL(serverURL), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        if (null != driver) {
            driver.quit();
        }
    }
}