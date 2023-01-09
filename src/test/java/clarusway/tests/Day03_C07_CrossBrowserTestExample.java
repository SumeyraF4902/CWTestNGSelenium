package clarusway.tests;

import clarusway.utilities.BaseCrossBrowserTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Day03_C07_CrossBrowserTestExample extends BaseCrossBrowserTest {
    //Go to https://www.amazon.com/
    // Search for 'headset' 'mouse' 'keyboard' in order with dataProvider
// Assert that first item contains searched keyword in the item description
// Go to product page
// Add first item to cart
// Click Go to cart on cart section
// Assert shopping cart heading
// Assert that added item is in shopping cart
// Check this is a gift
// Assert that checkbox is checked
// Click on proceed to checkout
// Assert that login page is opened

// Do it for chrome and firefox with crossbrowser testing

    //dataProvider ile sırayla 'kulaklık' 'fare' 'klavye'yi arayın
// İlk öğenin, öğe açıklamasında aranan anahtar kelimeyi içerdiğini onaylayın
// ürün sayfasına git
// İlk ürünü sepete ekle
// Sepet bölümünde Sepete Git'e tıklayın
// Alışveriş sepeti başlığını onayla
// Eklenen ürünün alışveriş sepetinde olduğunu onaylayın
// Bunun bir hediye olup olmadığını kontrol edin
// Onay kutusunun işaretli olduğunu onaylayın
// Ödeme yapmak için devam et'e tıklayın
// Oturum açma sayfasının açıldığını onaylayın

// Çapraz tarayıcı testi ile chrome ve firefox için yapın

    @Test (
            dataProvider = "data"// " test in icine dataprovider tanimlandi"
    )
    public void amazonTest(String key) {
        //Go to https://www.amazon.com/
        driver.get("https://www.amazon.com");

// Search for 'headset' 'mouse' 'keyboard' in order with dataProvider . dataProvider olusturdugumuz icin key anahtariyla sirasşyle hepsini arayacak
        WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys(key+ Keys.ENTER);

// Assert that first item contains searched keyword in the item description
        WebElement firstProduct = driver.findElement(By.xpath("//div[@data-component-type='s-search-result']"));
        String firstProductDescription=firstProduct.getText().toLowerCase();
        Assert.assertTrue(firstProductDescription.contains(key));//acilan sayfa aradigim kelimeyi iceriyor mu

        // Go to product page
        firstProduct.findElement(By.tagName("img")).click();//zaten urunu yukarida bulmustuk onun icin uzerine tiklamak yeterli, veya onun uzerinden baska bir element de bulabiliriz

        // Add first item to cart urunu sepete ekle
        WebElement addToCardBtn=driver.findElement(By.id("add-to-cart-button"));
        addToCardBtn.click();


        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sw-atc-details-single-container")))); // bu element bulunana kadar bekle dedik daha sonra alttaki isleme devam et dedik


        // Click Go to cart on cart section sepete git
        WebElement goToCardLink=driver.findElement(By.xpath("(//a[@class='a-button-text'])[1]"));//partialLinkText kullanmamizin sebebi yazinin kenarlarinda bosluk varsa hata vermeden temizlesin
        goToCardLink.click();

        // Assert shopping cart heading alıs veris sepeti  nin yazisini kontrol et
      List< WebElement> shoppingCartHeaderList = driver.findElements(By.tagName("h1"));//bulamadigi durumda hata verecegi icin list e cevirip size nin 0 dan
        //buyuk olmasiyle elementi locate etiigimizi dogrulamis oluyoruz
        Assert.assertTrue(shoppingCartHeaderList.size()>0);
        WebElement shoppingCartHeader=shoppingCartHeaderList.get(0);// ilk indextekini getir diyoruz
        Assert.assertTrue(shoppingCartHeader.isDisplayed());
        Assert.assertEquals(shoppingCartHeader.getText(), "Shopping Cart");


// Check this is a gift  THİS A GİFT BUTONUNU tikle
        WebElement thisIsAGiftCb=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        thisIsAGiftCb.click();

        // Assert that checkbox is checked checkbox kutusu tikli mi kontrol et
        Assert.assertTrue(thisIsAGiftCb.isSelected());

// Click on proceed to checkout  checkout butonuna tIkla
        WebElement proceedToCheckout=driver.findElement(By.name("proceedToRetailCheckout"));
        proceedToCheckout.click();

        // Assert that login page is opened login page acildi mi kontrol et
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://www.amazon.com/ap/signin"));

// Do it for chrome and firefox with crossbrowser testing bunlari capraz tarayici ile chrome ve fire fox ile yapin
    }
    @DataProvider// dataprovider olusturuldu
                public Object[][] data() {
            return new Object[][]{
                    {"headset"},
                    {"mouse"},
                    {"keyboard"}};
        }
}
