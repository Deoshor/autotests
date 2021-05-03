package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BugReportPage {
    protected WebDriver driver;
    public BugReportPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"select-project-form\"]/div/div[2]/div[2]/input") private WebElement btnToAcceptProject;
    @FindBy(id = "category_id") private WebElement select;
    @FindBy(id = "summary") private WebElement topicField;
    @FindBy(id = "description") private WebElement descField;
    @FindBy(css = "input[value='Создать задачу']") private WebElement btnToMakeTask;
    @FindBy(className = "bold bigger-110") private WebElement acceptMakeTask;

    public void clickBtnToAcceptProject() { btnToAcceptProject.click(); }
    public void getCategory(String value){
        Select dropdown = new Select(select);
        dropdown.selectByVisibleText(value);
    }
    public void inputTopic(String topic) { topicField.sendKeys(topic); }
    public void inputDesc(String desc) { descField.sendKeys(desc); }
    public void clickBtnToMakeTask() { btnToMakeTask.click(); }
    public String getAccept() { return acceptMakeTask.getText(); }

}


