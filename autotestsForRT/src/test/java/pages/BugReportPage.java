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
    WebElement btnToMakeTask = driver.findElement(By.xpath("//*[contains(@value, 'Создать задачу')]"));
    //Определяем локатор абзаца с надписью "Действие успешно выполнено."
    private By acceptMakeTask = By.className("bold bigger-110");



    //Метод для ввода текста в поле "Тема"
    public void inputTopic(String topic){
        topicField.sendKeys(topic);
    }
    //Метод для ввода текста в поле "Описание"
    public void inputDesc(String desc){
        descField.sendKeys(desc);
    }
    //Метод выбора категории
    public void getCategory(String value) {
        category.selectByVisibleText(value);
    }
    //Метод для создания задачи
    public void clickBtnToMakeTask() {
        btnToMakeTask.click();
    }
    //Метод для получения текста из абзаца
    public String getAccept(){
        return driver.findElement(acceptMakeTask).getText();
    }



}
