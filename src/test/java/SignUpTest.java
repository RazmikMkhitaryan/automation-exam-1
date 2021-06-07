import pages.HomePage;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class SignUpTest {
    @Test
    public void signUp(){
        HomePage homePage = new HomePage();
        homePage.clickOnSignUp();
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.typeUsername();
        signUpPage.typeFullname();
        signUpPage.typeEmail();
        signUpPage.clickOnCheck();
        signUpPage.clickOnSignUop();
        assertTrue()
    }
}
