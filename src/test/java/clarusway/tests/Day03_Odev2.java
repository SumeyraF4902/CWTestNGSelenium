package clarusway.tests;

import clarusway.utilities.BaseCrossBrowserTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;

public class Day03_Odev2 extends BaseCrossBrowserTest {
    /*
Open the site http://opencart.abstracta.us/
Using the Search function do it with Data Provider for Mac, iPad and Samsung

Siteyi açın http://opencart.abstracta.us/
Arama işlevini kullanarak bunu Mac, iPad ve Samsung için Veri Sağlayıcı ile yapın
    */
    @Test
            (dataProvider = "data")
    public void test(String key) {
        driver.get("http://opencart.abstracta.us/");
        WebElement search= driver.findElement(By.name("search"));
        search.sendKeys(key+ Keys.ENTER);
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }
}
