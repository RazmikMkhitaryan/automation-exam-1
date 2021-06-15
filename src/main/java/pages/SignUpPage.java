package pages;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;


public class SignUpPage extends BasePage {
    private static String usernameGenerator = UUID.randomUUID().toString();
    private static String emailGenerator = UUID.randomUUID().toString();
    private static String passwordGenerator = UUID.randomUUID().toString();
    private static String fullNameGenerator = UUID.randomUUID().toString();


    @FindBy(css = "[name='username']")
    private WebElement username;
    @FindBy(css = "[name='full_name']")
    private WebElement fullName;
    @FindBy(css = "[name='email']")
    private WebElement email;
    @FindBy(css = "[name='password']")
    private WebElement password;
    @FindBy(css = "[name='accepted_terms']")
    private WebElement checkBox;

    @FindBy(css = "[class='btn-small full']")
    private WebElement button;


    public SignUpPage() {
        open(getUrl());
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public SignUpPage init() {
        PageFactory.initElements(driver, this);
        return this;
    }


    @Override
    public String getUrl() {
        return BASE_URL + "/register";
    }

    public void typeUsername() {
        type(username, usernameGenerator);
    }

    public void typePassword() {
        type(password, passwordGenerator + "R123");
    }

    public void typeEmail() {
        type(email, emailGenerator + "@gmail.com");

    }

    public void typeFullname() {
        type(fullName, "Aaskbjhsabdjhasbd");
    }

    public void clickOnCheck() {
        click(checkBox);
    }

    public void clickOnSignUop() {
        click(button);
//        WaitHelper.getInstance().waitForElementDisplay()
    }
}
