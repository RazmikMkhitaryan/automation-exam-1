package pages;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserPage extends BasePage {
    @FindBy(css = "[class='user-avatar']")
    private WebElement avatar;
    @FindBy(css = "[class='up-x-to-close xbutton-injected']")
    private WebElement xButton;


    public UserPage() {
        //open(getUrl());
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        isDisplayed(avatar);
    }

    public UserPage init() {
        PageFactory.initElements(driver, this);
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
