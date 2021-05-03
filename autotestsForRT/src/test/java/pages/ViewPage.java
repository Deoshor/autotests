package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewPage {
    protected WebDriver driver;
    public ViewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#sidebar > ul > li:nth-child(3) > a") private WebElement btnToCreateTask;

    public void clickBtnToCreateTask() { btnToCreateTask.click(); }

}
