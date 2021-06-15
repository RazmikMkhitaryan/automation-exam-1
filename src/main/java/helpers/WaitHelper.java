package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.DriverHelper;


public class WaitHelper {
    private static final int DEFAULT_TIMEOUT = 10;
    private WebDriver driver = DriverHelper.get().getDriver();
    public static WaitHelper getInstance() {
        WaitHelper waitHelper = new WaitHelper();
        return waitHelper;
    }

    public WaitHelper waitForElementDisplay(WebElement element) {
        try {
            WebElement until = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOf((element)));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator was not displayed" + element.toString());
        }
    }

    public WaitHelper waitForElementDisplay(By location) {
        try {
            WebElement until = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated((location)));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator was not displayed" + location.toString());
        }
    }


    public WaitHelper waitForBeClickable(By location) {
        try {
            WebElement until = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.elementToBeClickable((location)));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator was not displayed" + location.toString());
        }
    }


}

