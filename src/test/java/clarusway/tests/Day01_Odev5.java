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

public class Day01_Odev5 {
      /*
Test Case3: Negative Password Test
Open page https://practicetestautomation.com/practice-test-login/
Type username student into Username field.
Type password incorrectPassword into Password field.
Puch Submit button.
Verify error message is displayed.
Verify error message text is Your password is invalid!

Test Durumu3: Negatif Parola Testi
Sayfayı aç https://practicetestautomation.com/practice-test-login/
Kullanıcı Adı alanına öğrenci kullanıcı adını yazın.
Password alanına password falsePassword yazın.
Gönder düğmesine basın.
Hata mesajının görüntülendiğini doğrulayın.
Hata mesajı metninin Parolanız geçersiz olduğunu doğrulayın!
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
    public void testCase3() {
        //Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //Type username student into Username field.
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("student");

        //Type password incorrectPassword into Password field.
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("incorrectPassword ");

        //Puch Submit button.
        WebElement submit = driver.findElement(By.className("btn"));
        submit.click();

        //Verify error message is displayed.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.className("show")).isDisplayed());

        //Verify error message text is Your password is invalid!
        softAssert.assertEquals(driver.findElement(By.className("show")).getText(), "Your password is invalid!");

        softAssert.assertAll();
    }
}
