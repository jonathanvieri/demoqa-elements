import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Elements {

    // Variables
    WebDriver driver = null;
    final String url = "https://demoqa.com/";

    @BeforeTest(description = "Setup ChromeDriver")
    public void setup() {
        final String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", dir+"\\driver\\chromedriver.exe");  // Set property of ChromeDriver to the chromedriver folder
        driver = new ChromeDriver();    // Create a new instance of ChromeDriver
    }

    @Test(description = "Go into DemoQA website and open Elements")
    public void step1() {
        driver.get(url);
        driver.findElement(By.xpath("//div//h5[contains(text(),'Elements')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='main-header' and text()='Elements']")).isDisplayed(),
                "Elements header not found / Not in Elements page");
    }

    @Test(description = "Go to Text Box section and fill in the details")
    public void step2() {
        driver.findElement(By.xpath("//li//span[text()='Text Box']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='main-header' and text()='Text Box']")).isDisplayed(),
                "Text Box header not found / not in Text Box page");

        // Fill details variables
        String fullName = "Rocks D. Shanks";
        String email = "shanks@redhair.com";
        String currentAddress = "Elbas";
        String permanentAddress = "West Blue";

        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(fullName);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(currentAddress);
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys(permanentAddress);

        driver.findElement(By.xpath("//button[@id='submit']")).click();

        // Verify the value
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='output' and .//p[contains(.,'" + fullName + "')]]")).isDisplayed(),
                fullName + " is not found");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='output' and .//p[contains(.,'" + email + "')]]")).isDisplayed(),
                email + " is not found");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='output' and .//p[contains(.,'" + currentAddress + "')]]")).isDisplayed(),
                currentAddress + " is not found");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='output' and .//p[contains(.,'" + permanentAddress + "')]]")).isDisplayed(),
                permanentAddress + " is not found");
    }

    @Test(description = "Go to Check Box section and check some boxes")
    public void step3() {
        driver.findElement(By.xpath("//li//span[text()='Check Box']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='main-header' and text()='Check Box']")).isDisplayed(),
                "Check Box header not found / not in Check Box page");

        driver.findElement(By.cssSelector(".rct-collapse")).click();    // Toggle the list
        driver.findElement(By.xpath("//label[@for='tree-node-downloads']//span[@class='rct-checkbox']")).click();

        // Verify the values
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='result' and .//span[text()='downloads']]")).isDisplayed(),
                "Downloads is not selected");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='result' and .//span[text()='wordFile']]")).isDisplayed(),
                "wordFile is not selected");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='result' and .//span[text()='excelFile']]")).isDisplayed(),
                "excelFile is not selected");
    }

    @AfterTest(description = "Finished the test, cleaning up ChromeDriver instance")
    public void finish() {
       driver.quit();
    }
}
