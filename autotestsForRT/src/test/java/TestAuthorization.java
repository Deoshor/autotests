import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAuthorization {
    private WebDriver driver;
    private LoginPage loginPage;
    private PasswdPage passwdPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webriver.chrome.driver", "C://webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        passwdPage = new PasswdPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mantisbt.org/bugs/login_page.php");
    }

    @Test
    public void signIn() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickBtnIn();

        //Проверяем заголок страницы
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("?????????")) {
            passwdPage.inputPasswd(ConfProperties.getProperty("passwd"));
            passwdPage.clickBtnIn();
        } else {
            System.out.println("Test case : Failed");
        }
    }

    @AfterMethod
    public void endSession(){
        driver.quit();
    }
}