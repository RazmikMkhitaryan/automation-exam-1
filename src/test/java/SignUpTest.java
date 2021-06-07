import pages.HomePage;
import org.testng.annotations.Test;
import pages.SignUpPage;
import pages.UserPage;

import static org.testng.Assert.assertTrue;

public class SignUpTest extends TestBase {

    @Test
    public void signUp() {
        HomePage homePage = new HomePage();
        homePage.clickOnSignUp();
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.typeUsername();
        signUpPage.typeFullname();
        signUpPage.typeEmail();
        signUpPage.typePassword();
        signUpPage.clickOnCheck();
        signUpPage.clickOnSignUop();
        UserPage userPage = new UserPage();
        userPage.closePopUp();
        assertTrue(userPage.isAvatarDisplayed(), "User was not created");
    }
}
