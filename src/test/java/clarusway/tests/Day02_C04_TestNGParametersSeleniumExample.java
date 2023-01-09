package clarusway.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day02_C04_TestNGParametersSeleniumExample {
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browserValue) {
        switch (browserValue){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    @Test
    @Parameters("aranacakKelime")
    public void parametersTest(String kelime) throws Exception {
        driver.get("https://www.amazon.com");

        WebElement searchText = driver.findElement(By.id("twotabsearchtextbox"));

        searchText.sendKeys(kelime);

        Thread.sleep(5000);
        WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultText.getText().contains(kelime));



    }
}