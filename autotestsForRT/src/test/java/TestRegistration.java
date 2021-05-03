import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterPage;

import java.util.concurrent.TimeUnit;

public class TestRegistration {
    private static WebDriver driver;
    private static RegisterPage registerPage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        registerPage = new RegisterPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.mantisbt.org/bugs/signup_page.php");
        final Cookie COOKIE = new Cookie(
                "PHPSESSID",
                "rprvfk0bu0jholq0ca8rlh2tem",
                "/");
        driver.manage().addCookie(COOKIE);
    }

    @Test
    public static void signUp() {
        registerPage.inputLogin(ConfProperties.getProperty("loginForRegistration"));
        registerPage.inputEmail(ConfProperties.getProperty("emailForRegistration"));
        registerPage.inputCaptcha("YQsJs0");
        registerPage.clickBtnRegistration();
    }

    @AfterClass
    public static void EndSession() {
        driver.quit();
    }
}
