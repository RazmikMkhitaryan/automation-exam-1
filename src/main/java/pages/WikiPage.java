package pages;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WikiPage extends BasePage{
    @FindBy(css = ".activity-item")
    private WebElement bookmark;

    public WikiPage() {
        open(getUrl());
        PageFactory.initElements(driver,this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    @Override
    public String getUrl() {
        return BASE_URL+"/project/razmik-test1/timeline";
    }


    public boolean isBookmarkAdded(){
        WaitHelper.getInstance().waitForElementDisplay(bookmark);
        return isDisplayed(bookmark);
    }
}
