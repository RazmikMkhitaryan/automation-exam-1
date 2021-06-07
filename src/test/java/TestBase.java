import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static setup.DriverSetup.getDriver;

public class TestBase {

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }


}
