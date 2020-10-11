package com.gmail.deoshor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ProfilePage {
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //определение локатора кнопки профиля
    @FindBy(xpath = "//*[contains(@class, 'gb_D gb_Ra gb_i')]")
    private WebElement profileMenu;
    //определение локатора кнопки выхода из аккаунта
    @FindBy(xpath = "//*[contains(text(), 'Выйти')]/..")
    private WebElement logoutBtn;
    //метод для получения имени пользователя из меню пользователя
    public String getUserName() {
        String userName = profileMenu.getText();
        return userName;
    }
    //метод для осуществления нажатия кнопки профиля
    public void clickProfileMenu() {
        profileMenu.click();
    }
    //метод для осуществления нажатия кнопки выхода из аккаунта
    public void clickLogoutBtn() {
        logoutBtn.click();
    }
}

