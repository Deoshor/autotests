import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestRegistration {
    private WebDriver driver;
    private RegisterPage registerPage;

    @BeforeMethod
    public void setUp() {
        //Указываем путь, где хранится driver
        System.setProperty("webdriver.chrome.driver", "C://webdrivers/chromedriver.exe");
        //Создаем новый драйвер
        driver = new ChromeDriver();
        //Создаем объект страницы
        registerPage = new RegisterPage(driver);
        //Добавляем неявное ожидание, используемое при поиске элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Открываем нужный URl
        driver.get("https://www.mantisbt.org/bugs/signup_page.php");
    }

    @Test
    public void signUp() {
        //Вводим имя пользователя
        registerPage.inputLogin(ConfProperties.getProperty("login"));
        //Вводим электронную почту
        registerPage.inputEmail(ConfProperties.getProperty("email"));
        //Вводим капчу
        registerPage.inputCaptcha("???");
        //Отправляем данные на сервер
        registerPage.clickBtnRegistration();
    }

    @AfterMethod
    //Закрываем окно браузера
    public void EndSession() {
        driver.quit();
    }
}
