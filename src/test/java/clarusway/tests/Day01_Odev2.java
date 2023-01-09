package clarusway.tests;

import clarusway.utilities.BaseTest;
import org.testng.annotations.Test;

public class Day01_Odev2 extends BaseTest {
  /*  Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.

    Birbirine bağlı testler oluşturun
BeforeClass oluşturun ve ayarları yapın.
Birbirine bağlı testler oluşturarak;
İlk önce Facebook'a gidin.
Ardından Facebook'a bağlı olarak Google'a gidin,
Ardından Google'a bağlı olarak Amazon'a gidin
Sürücüyü kapatın.
   */

    @Test
    public void faceBook(){
        driver.get("https://www.facebook.com/");
    }
    @Test (dependsOnMethods = {"faceBook"})
    public  void google(){
        driver.get("https://www.google.com/");
    }
    @Test(dependsOnMethods = {"google"})
    public void amazon(){
        driver.get("https://www.amazon.com/");
    }
}
