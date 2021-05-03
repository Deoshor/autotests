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

    @FindBy(xpath = "//*[contains(@id, 'username')]") private WebElement loginField;
    @FindBy(xpath = "//*[contains(@id, 'email-field')]") private WebElement emailField;
    @FindBy(xpath = "//*[contains(@id, 'captcha-field')]") private WebElement captchaField;
    @FindBy(xpath = "//*[contains(@value, 'Зарегистрироваться')]") private WebElement btnRegistration;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }
    public void inputCaptcha(String captcha) {
        captchaField.sendKeys(captcha);
    }
    public void clickBtnRegistration() {
        btnRegistration.click();
    }
}
