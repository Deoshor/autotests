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
    private static PreviewBRPage previewBRPage;
    private static BugReportPage bugReportPage;
    private static LoginPage loginPage;
    private static PasswdPage passwdPage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        passwdPage = new PasswdPage(driver);
        previewBRPage = new PreviewBRPage(driver);
        bugReportPage = new BugReportPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.mantisbt.org/bugs/my_view_page.php");
    }

    @Test
    public void createTask() {
        //Авторизуемся
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickBtnIn();
        passwdPage.inputPasswd(ConfProperties.getProperty("passwd"));
        passwdPage.clickBtnIn();
        //Нажимаем кнопку "Создать задачу"
        mainPage.clickBtnToMakeTask();
        //Нажимаем кнопку "Выбрать проект"
        previewBRPage.clickBtnChooseProject();
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
