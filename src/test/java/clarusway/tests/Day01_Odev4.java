package clarusway.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Day01_Odev4 {

    /*
    Test Case2: Negative Username Test
Open page https://practicetestautomation.com/practice-test-login/
Type username incorrectUser into Username field.
Type password Password123 into Password field.
Puch Submit button.
Verify error message is displayed.
Verify error message text is Your username is invalid!

Test Durumu2: Negatif Kullanıcı Adı Testi
Sayfayı aç https://practicetestautomation.com/practice-test-login/
Kullanıcı Adı alanına username falseUser yazın.
Parola alanına Parola123 yazın.
Gönder düğmesine basın.
Hata mesajının görüntülendiğini doğrulayın.
Hata mesajı metninin Kullanıcı adınız geçersiz olduğunu doğrulayın!

     */
        WebDriver driver;
        @BeforeMethod
        public  void  setUp(){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));}

    @AfterMethod
    public void tearDown(){
        // driver.quit();
    }
    @Test
    public void testCase2(){
            //Open page https://practicetestautomation.com/practice-test-login/
            driver.get("https://practicetestautomation.com/practice-test-login/");

            //Type username incorrectUser into Username field.
        WebElement username= driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("incorrectUser");

        //Type password Password123 into Password field.
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
                password.sendKeys("Password123");

       // Puch Submit button.
        WebElement submit= driver.findElement(By.className("btn"));
        submit.click();

        //Verify error message is displayed.
        WebElement error= driver.findElement(By.className("show"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(!error.isDisplayed());

        //  Verify error message text is Your username is invalid!
        softAssert.assertEquals(error.getText(),"Your username is invalid!", "Istenilen mesaji icermiyor");
        softAssert.assertAll();


    }
}
