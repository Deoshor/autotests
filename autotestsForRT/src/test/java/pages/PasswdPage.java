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

    @FindBy(xpath = "//*[contains(@id, 'password')]") private WebElement passwdField;
    @FindBy(xpath = "//*[contains(@value, 'Вход')]") private WebElement btnIn;

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }
    public void clickBtnIn() {
        btnIn.click();
    }

    @FindBy(xpath = "//*[@id=\"breadcrumbs\"]/ul/li/a") private WebElement text;
    public String getText() { return text.getText(); }

}
