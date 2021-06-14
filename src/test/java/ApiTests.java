import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import helpers.ApiClient;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import setup.DriverSetup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getDriver;

public class ApiTests {
    private static String ACCESS_TOKEN ="Bearer eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjo0ODEwNjF9:1lrMMs:LXHRbszHNHN5uAlyJl6oocNUkOQ";
    private String username="razo96@gmail.com";
    private String password="Raz123mik";


    @BeforeMethod
    public void login(){
        HomePage homePage = new HomePage();
        LoginPage.setItemInLocalStorage("token", "\"eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjo0ODEwNjF9:1lrK8z:IkJMXNdSiYzKkBanHyVW7ExPv8c\"");
        LoginPage.setItemInLocalStorage("userInfo", "{\"id\":481061,\"username\":\"razmik\",\"full_name\":\"Razmik Mkhitaryan\",\"full_name_display\":\"Razmik Mkhitaryan\",\"color\":\"#682a4c\",\"bio\":\"\",\"lang\":\"\",\"theme\":\"\",\"timezone\":\"\",\"is_active\":true,\"photo\":null,\"big_photo\":null,\"gravatar_id\":\"d70bc2ab36be838a5c06a7db72275814\",\"roles\":[],\"total_private_projects\":0,\"total_public_projects\":0,\"email\":\"razo96@gmail.com\",\"uuid\":\"6c94f73a28114ad182bcdd387fcddf9a\",\"date_joined\":\"2021-06-07T15:17:33.312Z\",\"read_new_terms\":true,\"accepted_terms\":true,\"max_private_projects\":1,\"max_public_projects\":null,\"max_memberships_private_projects\":3,\"max_memberships_public_projects\":null,\"verified_email\":false,\"auth_token\":\"eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjo0ODEwNjF9:1lrK8z:IkJMXNdSiYzKkBanHyVW7ExPv8c\"}");
        UserPage userPage = new UserPage();
    }

    @AfterMethod
    public void deleteAll() throws IOException {
        JsonArray allProjects = ApiClient.getAllProjects();
        for (int i = 0; i < allProjects.size(); i++) {
            ApiClient.deleteProject(allProjects.get(i).getAsJsonObject());
        }
        DriverSetup.quit();
    }

    @Test
    public void addProjectTest() throws IOException {
        ApiClient.CreateProject("Test1",ACCESS_TOKEN);
        ProjectsPage projectsPage= new ProjectsPage();
        assertTrue(projectsPage.isProjectAdded(),"project was not added");
    }

    @Test
    public void addBookmarkTest() throws IOException {
        JsonObject jsonObject = ApiClient.CreateProject("Test1", ACCESS_TOKEN);
        ApiClient.addBookmark(jsonObject);
        WikiPage wikiPage = new WikiPage();
        assertTrue(wikiPage.isBookmarkAdded(),"Bookmark was not added");

    }
}
