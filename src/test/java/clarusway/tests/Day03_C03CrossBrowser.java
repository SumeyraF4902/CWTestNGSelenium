package clarusway.tests;

import clarusway.utilities.BaseCrossBrowserTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day03_C03CrossBrowser extends BaseCrossBrowserTest {

    //browser bilgisi testng.xml dosyasindan alinacagi icin kod asamasinda herhangibir bir degisiklik goruntulenmeyecektir
// Birebir ayni testlerimizi farkli browserlardan acip kontrol etmek islemidir

    @Test
    public void crossBrowserTest() throws InterruptedException {
        driver.get("http://www.google.com");

        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(),"Google");

    }

}
