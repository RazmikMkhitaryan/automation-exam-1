package pages;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class HomePage extends BasePage {
    @FindBy(css = ".login")
    private WebElement loginButton;

    @FindBy(css = ".register")
    private WebElement signUp;

    public HomePage() {
        open(getUrl());
        PageFactory.initElements(getDriver(), this);
    }

    public HomePage init() {
        PageFactory.initElements(getDriver(), this);
        return this;
    }


    @Override
    public String getUrl() {
        return BASE_URL;
    }

    public void open() {
        getUrl();
    }


    public void clickOnLogin() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(loginButton);
    }

    public void clickOnSignUp() {
        WaitHelper.getInstance().waitForElementDisplay(signUp);
        click(signUp);
    }


}
