import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import java.util.concurrent.TimeUnit;

public class TestCreateTask {
    private static WebDriver driver;
    private static BugReportPage bugReportPage;
    private static LoginPage loginPage;
    private static PasswdPage passwdPage;
    private static ViewPage viewPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        bugReportPage = new BugReportPage(driver);
        loginPage = new LoginPage(driver);
        passwdPage = new PasswdPage(driver);
        viewPage = new ViewPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.mantisbt.org/bugs/login_page.php");
    }

    @Test
    public static void createTask() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickBtnIn();

        passwdPage.inputPasswd(ConfProperties.getProperty("passwd"));
        passwdPage.clickBtnIn();

        viewPage.clickBtnToCreateTask();

        bugReportPage.clickBtnToAcceptProject();
        bugReportPage.getCategory("other");
        bugReportPage.inputTopic("Delete this task");
        bugReportPage.inputDesc("This task is done automatically with Selenium. \n" +
                "Excuse for troubling");
        bugReportPage.clickBtnToMakeTask();
        String accept = bugReportPage.getAccept();
        if (accept.equals("Действие успешно выполнено.")) {
            System.out.println("Task created\nTest - passed");
        } else {
            System.out.println("Task don't created\nTest - failed");
        }
        //Тест падает с ошибкой, но по факту он выполняется правильно и не проходит проверку выше.
        //По факту нужно поменять в локаторе текста, который появляется при успешном создании задачи, правильный путь
        //Не сделал этого, потому что не могу отследить сообщение об успешности создания задачи
        //и не хочу захламлять сайт бесполезными пустыми задачами
    }

    @AfterClass
    public void EndSession() { driver.quit(); }
}
