import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.BeforeClass;
import org.junit.Test;

public class  TestScript1 {

    public static void main(String[] args) throws Exception {	  


    	//Setup Firefox driver
    	System.setProperty("webdriver.gecko.driver","http://localhost:4444/wd/hub");
		WebDriver driver = new GeckoDriver();
    	String baseUrl = "http://www.demo.guru99.com/V4/"
    	// launch Firefox and direct it to the Base URL
    	driver.get(baseUrl);

	    // Enter username
	    driver.findElement(By.name("uid")).sendKeys("mngr289770");

	    // Enter Password
	    driver.findElement(By.name("password")).sendKeys("henusUd");
   
	    // Click button "Login"
	    driver.findElement(By.name("btnLogin")).click();


	    }
	

    }

