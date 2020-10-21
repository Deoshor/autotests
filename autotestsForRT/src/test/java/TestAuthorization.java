import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.PasswdPage;

import java.util.concurrent.TimeUnit;

public class TestAuthorization {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static PasswdPage passwdPage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        passwdPage = new PasswdPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.mantisbt.org/bugs/login_page.php");
    }

    @Test
    public void signIn() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickBtnIn();

        passwdPage.inputPasswd(ConfProperties.getProperty("passwd"));
        passwdPage.clickBtnIn();
    }

    @AfterClass
    public static void endSession(){
        driver.quit();
    }
}