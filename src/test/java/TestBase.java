import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static setup.DriverSetup.getDriver;
import static setup.DriverSetup.quit;

public class TestBase {

    @AfterMethod
    public void tearDown() {
        quit();
    }


}
