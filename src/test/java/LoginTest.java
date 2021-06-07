import com.google.gson.JsonObject;
import helpers.ApiHelper;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UserPage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getDriver;

public class LoginTest {

//    @BeforeMethod
//    public void login(){
//        LocalStorage local = ((WebStorage) getDriver()).getLocalStorage();
//        local.setItem("userinfo","{\"id\":481059,\"username\":\"ewkjfhwekljfbwelk\",\"full_name\":\"sdfkjhsklfhkl\",\"full_name_display\":\"sdfkjhsklfhkl\",\"color\":\"#a81ab5\",\"bio\":\"\",\"lang\":\"\",\"theme\":\"\",\"timezone\":\"\",\"is_active\":true,\"photo\":null,\"big_photo\":null,\"gravatar_id\":\"e4fa23bd0e71dd0f8c3dc5f0ad33219b\",\"roles\":[],\"total_private_projects\":0,\"total_public_projects\":0,\"email\":\"djkfhelh@hgjh.com\",\"uuid\":\"df71260eed574388a14a62eb9d952a42\",\"date_joined\":\"2021-06-07T15:06:22.889Z\",\"read_new_terms\":true,\"accepted_terms\":true,\"max_private_projects\":1,\"max_public_projects\":null,\"max_memberships_private_projects\":3,\"max_memberships_public_projects\":null,\"verified_email\":false,\"auth_token\":\"eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjo0ODEwNTl9:1lqGpb:EFPXIAUinQhB2eoO8baaC054xsg\"}");
//        local.setItem("token","eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjo0ODEwNTl9:1lqGpb:EFPXIAUinQhB2eoO8baaC054xsg");
//        getDriver().navigate().refresh();
//    }

    @Test
    public void loginTest() {

        HomePage homePage = new HomePage();
        homePage.clickOnLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.typeLogin();
        loginPage.typePassword();
        loginPage.clickOnLoginButton();
        UserPage userPage = new UserPage();
        assertTrue(userPage.isAvatarDisplayed(), "log in failed");
    }


    @Test
    public void loginWithApi() throws IOException {
        HomePage homePage = new HomePage();
        JsonObject jsonObject = ApiHelper.logIn();
        assertEquals(jsonObject.getAsJsonObject().get("status").toString(),"success","log in failed");
    }

}



