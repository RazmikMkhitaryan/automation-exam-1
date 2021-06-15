package pages;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import helpers.ApiClient;
import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProjectsPage extends BasePage {
    @FindBy(css = "[class='list-itemtype-project tg-scope']")
    private WebElement allProjects;
    @FindBy(css = ".user-avatar")
    private WebElement avatar;


    public ProjectsPage() {
        open(getUrl());
        PageFactory.initElements(DriverHelper.get().driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        WaitHelper.getInstance().waitForElementDisplay(avatar);

    }


    public void init() {
        PageFactory.initElements(driver, this);

    }

    @Override
    public String getUrl() {
        return BASE_URL + "/projects/";
    }

    public boolean isDisplayedAvatar(){
        return isDisplayed(avatar);
    }

    public boolean isProjectAdded(){
       return isDisplayed(allProjects);
    }



}
