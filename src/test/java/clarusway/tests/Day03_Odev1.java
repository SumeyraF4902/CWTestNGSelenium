package clarusway.tests;

import clarusway.utilities.BaseCrossBrowserTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day03_Odev1 extends BaseCrossBrowserTest {
    //Go to URL:
//https://opensource demo.orangehrmlive.com/
//Login with negative credentilas by Data Provider.
//Then assert that ‘’Invalid credentials’’ is displayed.

    //URL'ye git:
//https://opensource demo.orangehrmlive.com/
//Veri Sağlayıcı tarafından negatif kimlik bilgileriyle giriş yapın.
//Ardından "Geçersiz kimlik bilgileri"nin görüntülendiğini onaylayın.


    @Test
            (dataProvider = "dataProvider")
    public void test(String name, String passwordd) {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys(name);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(passwordd +Keys.ENTER);
        WebElement message = driver.findElement(By.xpath("//p[.='Invalid credentials']"));
        Assert.assertTrue(message.isDisplayed());
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {"sumeyra", "ss123456"}};

    }
}