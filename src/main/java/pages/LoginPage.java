package pages;

import helpers.WaitHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

    @FindBy(css = "[name='username']")
    private WebElement login;
    @FindBy(css = "[name='password']")
    private WebElement password;

    @FindBy(css = "[class='btn-small full']")
    private WebElement loginButton;


    public LoginPage() {
        open(getUrl());
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {


    }

    public LoginPage init() {
        PageFactory.initElements(driver, this);
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
        init();
         WaitHelper.getInstance().waitForElementDisplay(login);
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
