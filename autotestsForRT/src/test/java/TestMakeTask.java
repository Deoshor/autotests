import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BugReportPage;
import pages.MainPage;
import pages.PreviewBRPage;

import java.util.concurrent.TimeUnit;

public class TestMakeTask {
    private static WebDriver driver;
    private static MainPage mainPage;
    private static PreviewBRPage previewBRPage;
    private static BugReportPage bugReportPage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        previewBRPage = new PreviewBRPage(driver);
        bugReportPage = new BugReportPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.mantisbt.org/bugs/my_view_page.php");
    }

    @Test
    public void makeTask() {
        //Нажимаем кнопку "Создать задачу"
        mainPage.clickBtnToMakeTask();
        //Нажимаем кнопку "Выбрать проект"
        previewBRPage.clickBtnChooseProject();
        //Выбираем категорию бага
        bugReportPage.getCategory("27");
        //Заполняем поле "Тема"
        bugReportPage.inputTopic("testing_topic");
        //Заполняем поле "Описание"
        bugReportPage.inputDesc("testing_desc");
        //Нажимаем клавишу "Создать задачу"
        bugReportPage.clickBtnToMakeTask();
    }

    @AfterClass
    //Закрываем окно браузера
    public static void EndSession() {
        driver.quit();
    }
}
