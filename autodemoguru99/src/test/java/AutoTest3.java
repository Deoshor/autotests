import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class AutoTest3 {

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
        driver.manage().timeouts().implicitlyWait(Utilite3.WAIT_TIME, TimeUnit.SECONDS);
        //Открываем url в браузере с помощью метода get
        driver.get(Utilite3.BASE_URL);
    }

    @Test
    public void signIn() throws Exception {
        String[][] testData = Utilite3.getDataFromExcel(Utilite3.FILE_PATH,
                Utilite3.SHEET_NAME, Utilite3.TABLE_NAME);

        //Сохраняем тестируемые параметры в таблице Excel
        for (int i = 0; i < testData.length; i++) {
            String username = testData[i][0]; // get username
            String password = testData[i][1]; // get password

            //Вводим логин
            signInPage.inputLogin(username);
            //Вводим пароль
            signInPage.inputPasswd(password);
            //Отправляем данные на сервер
            signInPage.clickLoginBtn();

            try{
                Alert alt = driver.switchTo().alert();
                String actualBoxtitle = alt.getText(); //Получаем заголок из алерта
                alt.accept();
                if (actualBoxtitle.contains(Utilite3.EXPECT_ERROR)) {
                    System.out.println("Test case SS[" + i + "]: Passed");
                } else {
                    System.out.println("Test case SS[" + i + "]: Failed");
                }
            }
            catch (NoAlertPresentException Ex){
                String actualTitle = driver.getTitle();
                if (actualTitle.contains(Utilite3.EXPECT_TITLE)) {
                    System.out.println("Test case SS[" + i + "]: Passed");
                } else {
                    System.out.println("Test case SS[" + i + "]: Failed");
                }

            }
        }

    }

    @AfterMethod
    //Метод, закрывающий браузер
    public void endSession() {
        driver.quit();
    }

}