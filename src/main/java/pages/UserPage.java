package pages;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class UserPage extends BasePage {
    @FindBy(css = "[class='user-avatar']")
    private WebElement avatar;
    @FindBy(css = "[class='up-x-to-close xbutton-injected']")
    private WebElement xButton;


    public UserPage() {
        //open(getUrl());
        PageFactory.initElements(getDriver(), this);
    }

    public UserPage init() {
        PageFactory.initElements(getDriver(), this);
        return this;
    }

    @Override
    public String getUrl() {
        return null;
    }

    public boolean isAvatarDisplayed() {
        WaitHelper.getInstance().waitForElementDisplay(avatar);
        return isDisplayed(avatar);
    }

    public void closePopUp() {
        WaitHelper.getInstance().waitForElementDisplay(xButton);
        click(xButton);
    }
}
