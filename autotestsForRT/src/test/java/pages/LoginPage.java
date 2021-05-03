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

    @FindBy(xpath = "//*[contains(@id, 'username')]") private WebElement loginField;
    @FindBy(xpath = "//*[contains(@value, 'Вход')]") private WebElement btnIn;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    public void clickBtnIn() {
        btnIn.click();
    }

}
