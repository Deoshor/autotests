package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    protected WebDriver driver;
    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //определение локатора поля ввода логина
    @FindBy(xpath = "//*[contains(@id, 'username')]") private WebElement loginField;
    //определение локатора поля ввода email
    @FindBy(xpath = "//*[contains(@id, 'email-field')]") private WebElement emailField;
    //определение локатора поля ввода captcha
    @FindBy(xpath = "//*[contains(@id, 'captcha-field')]") private WebElement captchaField;
    //Определение локатора кнопки "Зарегистрироваться"
    @FindBy(xpath = "//*[contains(@value, 'Зарегистрироваться')]") private WebElement btnRegistration;

    //Метод для ввода логина
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    //Метод для ввода email
    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }
    //Метод для ввода капчи
    public void inputCaptcha(String captcha) {
        captchaField.sendKeys(captcha);
    }
    //метод для осуществления нажатия кнопки "Зарегистрироваться"
    public void clickBtnRegistration() {
        btnRegistration.click();
    }
}
