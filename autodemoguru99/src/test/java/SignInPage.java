import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage {
    public WebDriver driver;
    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //определение локатора поля ввода логина
    @FindBy(xpath = "//*[contains(@name, 'uid')]")
    private WebElement loginField;
    //определение локатора поля ввода пароля
    @FindBy(xpath = "//*[contains(@name, 'password')]")
    private WebElement passwordField;
    //определение локатора кнопки входа в аккаунт
    @FindBy(xpath = "//*[contains(@name, 'btnLogin')]/..")
    private WebElement loginBtn;
    //метод для ввода логина
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    //метод для ввода пароля
    public void inputPasswd(String passwd) {
        passwordField.sendKeys(passwd);
    }
    //метод для осуществления нажатия кнопки входа в аккаунт
    public void clickLoginBtn() {
        loginBtn.click();
    }
}
