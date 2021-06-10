package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class DriverSetup {
    public static WebDriver driver;
    private static ChromeOptions options;

    public static WebDriver getDriver() {
        if (driver == null) {
            //System.setProperty("webdriver.chrome.driver", "/Users/razmkhitaryan/Downloads/chromedriver");
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

            options = new ChromeOptions();
            List<String> arguments = new ArrayList<>();
            arguments.add("--disable-notifications");
            options.addArguments(arguments);
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quit() {
        getDriver().close();
        driver = null;
    }


}
