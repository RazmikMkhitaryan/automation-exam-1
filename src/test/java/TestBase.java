import helpers.ApiClient;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestBase {

//    @AfterMethod
//    public void tearDown() {
//        quit();
//    }

    @Test
    public void test(){
        ApiClient.login("razo96@gmail.com","Raz123mik");

    }

}
