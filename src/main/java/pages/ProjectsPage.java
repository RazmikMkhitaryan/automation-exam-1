package pages;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import helpers.ApiClient;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static setup.DriverSetup.getDriver;

public class ProjectsPage extends BasePage {
    @FindBy(css = "[class='list-itemtype-project tg-scope']")
    private WebElement allProjects;
    @FindBy(css = ".user-avatar")
    private WebElement avatar;


    public ProjectsPage() {
        open(getUrl());
        PageFactory.initElements(getDriver(), this);
    }


    public void init() {
        PageFactory.initElements(getDriver(), this);

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
