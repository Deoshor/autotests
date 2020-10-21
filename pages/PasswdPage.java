package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswdPage {
    protected WebDriver driver;
    public PasswdPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //определение локатора поля ввода пароля
    @FindBy(xpath = "//*[contains(@id, 'password')]") private WebElement passwdField;
    //Определение локатора кнопки "Вход"
    @FindBy(xpath = "//*[contains(@value, 'Вход')]") private WebElement btnIn;


    //Метод для ввода пароля
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }
    //метод для осуществления нажатия кнопки "Вход"
    public void clickBtnIn() {
        btnIn.click();
    }
}
