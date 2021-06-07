package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class LoginPage extends BasePage {
    private static final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();

    @FindBy(css = "[name='username']")
    private WebElement login;
    @FindBy(css = "[name='password']")
    private WebElement password;

    @FindBy(css = "[class='btn-small full']")
    private WebElement loginButton;


    public LoginPage() {
        open(getUrl());
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage init() {
        PageFactory.initElements(getDriver(), this);
        return this;
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/login?next=%252Fdiscover";
    }


    public void setItemInLocalStorage(String item, String value) {
        javascriptExecutor.executeScript(String.format(
                "window.localStorage.setItem('%s','%s');", item, value));
    }

    public void typeLogin() {
        // WaitHelper.getInstance().waitForElementDisplay(login);
        type(login, "razo96@gmail.com");
    }

    public void typePassword() {
        // WaitHelper.getInstance().waitForElementDisplay(password);
        type(password, "Raz123mik");
    }

    public void clickOnLoginButton() {
        click(loginButton);
    }

}
