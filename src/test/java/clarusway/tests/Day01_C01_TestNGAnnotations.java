package clarusway.tests;

import org.testng.annotations.*;

public class Day01_C01_TestNGAnnotations {

        // @Before/After Suite  BU PAKETTEKI TUM TESTLERDEN ONCE / SONRA CALISIR
        // @Before/After Test  TUM TEST METHODLARINDAN ONCE / SONRA CALISIR
        // @Before/After Class  HERHANGI BELIRLI TEST GRUBUNDAN ONCE / SONRA CALISIR
        // @Before/After Method  HER TEST METHODUNDAN ONCE / SONRA CALISIR
    //Before/After Groups  -->BIR TEST SINIFINDA KI TUM TEST YONTEMLERINDEN ONCE / SONRA CALISIR

  /*  Annotation helper(yardimci)  Attributes(ozellikleri)
  priority--> oncelik belirler . sayısal degeri daha kucuk olan daha once calisir - degerlerde verilebilir. deger verilmemisse 0 alir.
      dependsOnMethods--> bir methodun calismasini baska bir methoda baglıyor.. yani bagimli oldugu method calisirsa bu methodda  calisir , calismazsa oda calismaz
      enabled-->  @Test(enabled = true) enabled true oldugunda  testimiz calisir , enabled  false oldugunda testimiz calizmaz
      timeOut-->bir milliseconds belirliyoruz testimiz bu surenin ustune ciktiginde otomatik olarak testimiz fail oluyor, surenin altinda kaldiginda calısmaya devam eder
     description-->Aciklama demek. test hakkinda bilgi vermek icin kullanilir. ornek: @Test(description = "Bu test sistemimizin Home Page fonksiyonlarini kontrol eder")
     groups-->testlerimizi groplara ariyabiliyoruz. sarisinlar , gozlukluler gibi.
   */

        // @Test


    @Test
    public void test01(){
        System.out.println("\t\t\t\tTest 01 calisiyor");
    }

    @Test
    public void test02(){
        System.out.println("\t\t\t\tTest 02 calisiyor");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite calisti");
    }

    @AfterSuite
    public void afterSuite(){

        System.out.println("After suite calisti");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("\tBefore test calisti");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("\tAfter test calisti");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("\t\tBefore class calisti");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("\t\tAfter class calisti");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\t\t\tBefore method calisti");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("\t\t\tAfter method calisti");
    }


}
