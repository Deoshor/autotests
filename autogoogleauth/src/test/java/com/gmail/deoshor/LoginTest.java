package com.gmail.deoshor;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    //первоначальная настройка теста
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        //окно полноэкранного режима
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    //тестирование процесса аутентификации пользователя
    @Test
    public void loginTest() {
        //вводим логин для входа
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //нажимаем кнопку ввода "Далее"
        loginPage.clickLoginBtn();
        //вводим пароль для входа
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку ввода "Далее"
        loginPage.clickLoginBtn();
        //получаем отображаемый логин
        String user = profilePage.getUserName();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("login"), user);
    }
    //выход из аккаунта и закрытие окна браузера
    @AfterClass
    public static void shutDown() {
        profilePage.clickProfileMenu();
        profilePage.clickLogoutBtn();
        driver.quit();
    }
}