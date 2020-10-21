package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //определение локатора поля ввода логина
    @FindBy(xpath = "//*[contains(@id, 'username')]") private WebElement loginField;
    //Определение локатора кнопки "Вход"
    @FindBy(xpath = "//*[contains(@value, 'Вход')]") private WebElement btnIn;

    //Метод для ввода логина
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    //метод для осуществления нажатия кнопки "Вход"
    public void clickBtnIn() {
        btnIn.click();
    }
}
