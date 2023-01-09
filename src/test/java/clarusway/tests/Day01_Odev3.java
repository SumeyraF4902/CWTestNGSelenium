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

public class Day01_Odev3 {
    /*
    Test Case1: Positive Login Test
Open page https://practicetestautomation.com/practice-test-login/
Type username student into Username field
Type password Password123 into Password field
Puch Submit button.
Verify new page URL contains practicetestautomation.com/logged-in-successfully/
Verify new page contains expected text ('Congratulations' or 'successfully logged in')
Verify button Log out is displayed on the new page.

Test Durumu1: Pozitif Oturum Açma Testi
Sayfayı aç https://practicetestautomation.com/practice-test-login/
Kullanıcı adı öğrenciyi Kullanıcı adı alanına yazın
Parola alanına Parola123 yazın
Gönder düğmesine basın.
Yeni sayfa URL'sinin pratiktestautomation.com/logged-in-successfully/ içerdiğini doğrulayın
Yeni sayfanın beklenen metni içerdiğini doğrulayın ("Tebrikler" veya "başarıyla giriş yaptınız")
Doğrula düğmesi Oturumu kapat yeni sayfada görüntülenir.
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
    public  void testCase1(){
        //Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //Type username student into Username field
            WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
            userName.sendKeys("student");

            //Type password Password123 into Password field
            WebElement passWord=driver.findElement(By.xpath("//input[@id='password']"));
            passWord.sendKeys("Password123");

            //Puch Submit button.
            driver.findElement(By.className("btn")).click();

            //Verify new page URL contains practicetestautomation.com/logged-in-successfully/
            String url = driver.getCurrentUrl();
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertTrue(url.contains("practicetestautomation.com/logged-in-successfully/"));

            //Verify new page contains expected text ('Congratulations' or 'successfully logged in')
            WebElement message = driver.findElement(By.className("has-text-align-center"));
            softAssert.assertTrue(message.getText().contains("You successfully logged in!"));

            //Verify button Log out is displayed on the new page.
            WebElement logOut=driver.findElement(By.linkText("Log out"));
           softAssert.assertTrue(logOut.isDisplayed(),"Log out goruntulenemiyor");
           softAssert.assertAll();
        }
    }


