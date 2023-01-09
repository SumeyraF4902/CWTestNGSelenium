package clarusway.tests;


    import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

    public class Day01_C09_AssertionTypes {//TESTNG de iki TIPI  assertion vardir HARD ve SOFT ASSERTION
        /*
        ikiside TESTNG den gelir
        kuullanim amaclari farklidir
        yontemleri aynidir. Assert lerin iki ana katagorisidir
        Assert-->Assertion fail olursa diger stepler icin execution durur ve test failed olarak isaretlenir
        Verification -->Assertion fail olursa diger stepler icin execution durmaz ve devam eder
        Testin sonunda, sonuclari goruntulemek icin assertAll () yonteminin cagrilmasi gerekir.

         */


        @Test
        public void hardAssertion() {//Beklenen sonuc ile girilen sonuc fail oldugunda kodun geri KALANI EXECUTION ETMEDEN KODU SONLANDIRIYOR.
            // diger assert ifadeleri dogrulanmaz..geri kalan adimlar calısmaz. konsolda AssertionError gorulur.. ornek oturum acma islemleri.


            System.out.println("Assertion oncesi calisiyor");
            Assert.assertEquals(1, 2);// 1 ve 2 esitmi
            System.out.println("Assertion sonrasi calisiyor");// burasi calismaz


        }

        @Test
        public void softAssertion() {//HardAssertionun tam tersi, Herhangi bir hatayla karsilastiginda testin geri kalanini execution(calistirir) edip testimizi fail olarak isaretliyor.  SoftAssertion default olarak
            //TESTNG yi icermez, bunun icin org.testng.asserts.SoftAssertion paketini eklemek gerekir. normal assertionlar hard assertion. softAssertion icin softAssertion classi kullanilir
            System.out.println("Soft Assertion oncesi calisiyor");
            SoftAssert softAssert = new SoftAssert();// obje olusturmamiz lazim cunku farkli classtan calisiyor

            softAssert.assertEquals(1, 2); // Fail
            softAssert.assertTrue(true); // Pass


            System.out.println("Soft Assertion sonrasi calisiyor");  // burasi calisir


            softAssert.assertAll(); // Method sonunda kesinlikle cagirilmali
        }
    }
