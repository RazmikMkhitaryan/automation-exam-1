import pages.HomePage;
import org.testng.annotations.Test;

public class SignUpTest {
    @Test
    public void signUp(){
        HomePage homePage = new HomePage();
        homePage.clickOnSignUp();
    }
}
