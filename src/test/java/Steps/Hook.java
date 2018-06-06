package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Hook extends BaseUtil {

    public BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {

        System.out.println("Opening the browser : Firefox");

        System.setProperty("webdriver.gecko.driver", "geckodriver");
        base.Driver = new FirefoxDriver();
        base.Driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @After
    public void TearDownTest(Scenario scenario) {

        // take screenshot
        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
        }

        System.out.println("Closing the browser : MOCK");
    }
}
