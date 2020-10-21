package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreviewBRPage {
    protected WebDriver driver;
    public PreviewBRPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "btn btn-primary btn-white btn-round") private WebElement btnChooseProject;

    public void clickBtnChooseProject() {
        btnChooseProject.click();
    }
}
