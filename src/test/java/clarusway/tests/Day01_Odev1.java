package clarusway.tests;

import org.testng.annotations.*;

public class Day01_Odev1 {
    /*
    Create a class.
Create 2 test methods.
Use TestNG annotations that can be used in the class.
Interpret output in console.
Bir sınıf oluşturun.
2 test yöntemi oluşturun.
Sınıfta kullanılabilecek TestNG ek açıklamalarını kullanın.
Çıktıyı konsolda yorumlayın.
     */
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite calisiyor");}
    @BeforeTest
    public void beforeTest(){
        System.out.println( "BeforeTest calisiyor");

    }
    @BeforeClass
    public void beforeClass(){
        System.out.println( "Before  Class calisiyor");
    }
    @BeforeMethod
    public void afterMethod(){
        System.out.println( "Before Method calisiyor");
    }
    @Test
    public void test01(){
        System.out.println( "Test 01 calisiyor");
    }
    @AfterMethod
    public void afteeMethod(){
        System.out.println("After Method run");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class calisiyor");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("After Test run");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite run");
    }
    @Test
    public void test02(){
        System.out.println("Test 02 calisiyor");
    }
}



