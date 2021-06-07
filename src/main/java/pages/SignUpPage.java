package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

import static setup.DriverSetup.getDriver;

public class SignUpPage extends BasePage{
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
        PageFactory.initElements(getDriver(), this);
    }

    public SignUpPage init() {
        PageFactory.initElements(getDriver(), this);
        return this;
    }



    @Override
    public String getUrl() {
        return BASE_URL+"/register";
    }

    public void typeUsername(){
       type(username,usernameGenerator);
    }
    public void typePassword(){
        type(password,passwordGenerator+"R123");
    }
    public void typeEmail(){
        type(email,emailGenerator+"@gmail.com");

    }
    public void typeFullname(){
        type(fullName,"A"+fullNameGenerator+" R"+fullNameGenerator);
    }

    public void clickOnCheck(){
        click(checkBox);
    }
    public void clickOnSignUop(){
        click(button);
    }
}
