package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    protected WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    //Определение локатора кнопки "Зарегистрировать новую учетную запись"
    @FindBy(xpath = "//*[contains(@class, 'btn btn-primary btn-xs')]") private WebElement btnToRegistration;
    //Определение локатора кнопки "Создать задачу"
    @FindBy(xpath = "//*[contains(@class, 'btn btn-primary btn-sm')]") private WebElement btnToCreateTask;

    //метод для осуществления нажатия кнопки "Зарегистрировать новую учетную запись"
    public void clickBtnToRegistration() {
        btnToRegistration.click();
    }
    //метод для осуществления нажатия кнопки "Создать задачу"
    public void clickBtnToCreateTask() {
        btnToCreateTask.click();
    }

}
