import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import java.util.concurrent.TimeUnit;

public class TestCreateTask {
    private static WebDriver driver;
    private static MainPage mainPage;
    private static BugReportPage bugReportPage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        bugReportPage = new BugReportPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mantisbt.org/bugs/my_view_page.php");

    }

    @Test
    public void createTask() {
        //Авторизуемся
        TestAuthorization.setUp();
        TestAuthorization.signIn();
        //Нажимаем кнопку "Создать задачу"
        mainPage.clickBtnToCreateTask();
        //Выбираем категорию бага
        bugReportPage.getCategory("other");
        //Заполняем поле "Тема"
        bugReportPage.inputTopic("testing_topic");
        //Заполняем поле "Описание"
        bugReportPage.inputDesc("testing_desc");
        //Нажимаем клавишу "Создать задачу"
        bugReportPage.clickBtnToMakeTask();
        //
        String accept = bugReportPage.getAccept();
        if (accept.equals("Действие успешно выполнено.")) {
            System.out.println("Task created\nTest - passed");
        } else {
            System.out.println("Task don't created\nTest - failed");
        }
    }

    @AfterClass
    //Закрываем окно браузера
    public static void EndSession() {
        driver.quit();
    }
}
