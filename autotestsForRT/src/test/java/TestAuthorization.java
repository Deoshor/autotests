import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
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
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        passwdPage = new PasswdPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.mantisbt.org/bugs/login_page.php");
    }

    @Test
    public static void signIn() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickBtnIn();

        passwdPage.inputPasswd(ConfProperties.getProperty("passwd"));
        passwdPage.clickBtnIn();

        String text = passwdPage.getText();
        if (text.equals(ConfProperties.getProperty("login"))) {
            System.out.println("Sign in is successfully!\nTest - passed");
        } else {
            System.out.println("Sign in isn't successfully\nTest - failed");
        }
    }

    @AfterClass
    public static void endSession(){
        driver.quit();
    }
}