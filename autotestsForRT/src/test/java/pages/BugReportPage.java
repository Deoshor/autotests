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

    //Определяем локатор выбора "Категория"
    private final By category = By.id("category_id");
    Select categorySelect = new Select((WebElement) category);
    //Определяем локатор поля "Тема"
    private final By topicField = By.id("summary");
    //Определяем локатор поля "Описание"
    private final By descField = By.id("description");
    //Определяем локатор кнопки "Создать задачу"
    private final By btnToMakeTask = By.cssSelector("input[value='Создать задачу']");
    //Определяем локатор абзаца с надписью "Действие успешно выполнено."
    private final By acceptMakeTask = By.className("bold bigger-110");



    //Метод для ввода текста в поле "Тема"
    public void inputTopic(String topic){
        driver.findElement(topicField).sendKeys(topic);
    }
    //Метод для ввода текста в поле "Описание"
    public void inputDesc(String desc){
        driver.findElement(descField).sendKeys(desc);
    }
    //Метод выбора категории
    public void getCategory(String value) {
        categorySelect.selectByVisibleText(value);
    }
    //Метод для создания задачи
    public void clickBtnToMakeTask() {
        driver.findElement(btnToMakeTask).click();
    }
    //Метод для получения текста из абзаца
    public String getAccept(){
        return driver.findElement(acceptMakeTask).getText();
    }



}
