import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
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
        //Указываем путь, где хранится driver
        System.setProperty("webdriver.chrome.driver", "C://webdrivers/chromedriver.exe");
        //Создаем новый драйвер
        driver = new ChromeDriver();
        //Создаем объект страницы
        registerPage = new RegisterPage(driver);
        //Добавляем неявное ожидание, используемое при поиске элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Открываем нужный URl
        driver.get("http://www.mantisbt.org/bugs/signup_page.php");
        final Cookie COOKIE = new Cookie(
                "autotester_9999",
                "PHPSESSID=1be1i44vkhn54gb08oe5kjoir4; _ga=GA1.2.1145167744.1603133616; __atuvc=7%7C43",
                "https://www.mantisbt.org/bugs/signup_page.php");
        driver.manage().addCookie(COOKIE);
    }

    @Test
    public void signUp() {
        //Вводим имя пользователя
        registerPage.inputLogin(ConfProperties.getProperty("login"));
        //Вводим электронную почту
        registerPage.inputEmail(ConfProperties.getProperty("email"));
        //Вводим капчу
        registerPage.inputCaptcha("nd5xE5");
        //Отправляем данные на сервер
        registerPage.clickBtnRegistration();
    }

    @AfterClass
    //Закрываем окно браузера
    public static void EndSession() {
        driver.quit();
    }
}
