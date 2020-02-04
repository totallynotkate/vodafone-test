package test.kotsiievska;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by totallynotkate on 2020-02-02.
 */
public abstract class
WebTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @AfterClass
    public static void teardownDriver() {
        driver.close();
    }

    @After
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }
}
