import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class AutoTest2 {

    private WebDriver driver;
    private SignInPage signInPage;

    @BeforeMethod
    public void setUp() {
        //Указываем путь где хранится geckodriver
        System.setProperty("webdriver.gecko.driver", "C://webdrivers/geckodriver.exe");
        //Создаем новый драйвер
        driver = new FirefoxDriver();
        signInPage = new SignInPage(driver);
        //Добавляем неявное ожидание, используемое при поиске любого из элементов
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        //Открываем url в браузере с помощью метода get
        driver.get("http://www.demo.guru99.com/V4/");
    }

    @Test
    public void signIn() {
        //Вводим логин
        signInPage.inputLogin(ConfProperties.getProperty("login"));
        //Вводим пароль
        signInPage.inputPasswd(ConfProperties.getProperty("password"));
        //Отправляем данные на сервер
        signInPage.clickLoginBtn();

        //Проверяем заголовок страницы
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Guru99 Bank Manager HomePage")) {
            System.out.println("Test case: Passed");
        } else {
            System.out.println("Test case : Failed");
        }
    }

    @AfterMethod
    //Метод, закрывающий браузер
    public void endSession() {
        driver.quit();
    }

}