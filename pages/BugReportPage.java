package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BugReportPage {
    protected WebDriver driver;
    public BugReportPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Определяем локатор выбора "Категория" 27
    Select category = new Select(driver.findElement(By.id("category_id")));
    //Определяем локатор поля "Тема"
    WebElement topicField = driver.findElement(By.id("summary"));
    //Определяем локатор поля "Описание"
    WebElement descField = driver.findElement(By.id("description"));
    //Определяем локатор кнопки "Создать задачу"
    WebElement btnToMakeTask = driver.findElement(By.xpath("//*contains[(@value, 'Создать задачу')]"));

    //Метод для ввода текста в поле "Тема"
    public void inputTopic(String topic){
        topicField.sendKeys(topic);
    }
    //Метод для ввода текста в поле "Описание"
    public void inputDesc(String desc){
        topicField.sendKeys(desc);
    }
    //Метод выбора категории
    public void getCategory(String value) {
        category.selectByVisibleText(value);
    }
    //Метод выбора категории
    public void clickBtnToMakeTask() {
        btnToMakeTask.click();
    }
}
