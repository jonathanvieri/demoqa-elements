import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Elements {
    WebDriver driver = null;
    final String url = "https://demoqa.com/";

    @BeforeTest(description = "Setup ChromeDriver")
    public void setup() {
        final String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", dir+"\\driver\\chromedriver.exe");  // Set property of ChromeDriver to the chromedriver folder
        driver = new ChromeDriver();    // Create a new instance of ChromeDriver
    }

    @AfterTest(description = "Finished the test, cleaning up ChromeDriver instance")
    public void finish() {
       driver.close();
       driver.quit();
    }
}
