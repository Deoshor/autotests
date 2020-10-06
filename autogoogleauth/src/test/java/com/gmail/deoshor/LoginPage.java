package com.gmail.deoshor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //определение локатора поля ввода логина
    @FindBy(xpath = "//*[contains(@id, 'identifierId')]")
    private WebElement loginField;
    //определение локатора кнопки входа в аккаунт
    @FindBy(xpath = "//*[contains(text(), 'Далее')]/..")
    private WebElement loginBtn;
    //определение локатора поля ввода пароля
    @FindBy(xpath = "//*[contains(@id, 'password')]")
    private WebElement passwordField;
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