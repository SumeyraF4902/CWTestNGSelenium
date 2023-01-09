package clarusway.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day03_C01_DataProvider {
    ////verileri dataProvider methodundan alarak calisacak olan test
    //COOOKKK ONEMMLIIIIIMULAKAT SORUSU
    //dataProvider objectc ile return eder. TESTNG anatasyonudur, TESTNG İCİN KULLANİLİR
    /*
   1----> @DataProvider(name = "xxxx")   bu sekilde isim atayarakta dataProvider cagırabiliriz o zaman methot ismi kullanmamiza gerek kalmaz
    public Object[][] getData() {
      2--->@Test(
      dataProvider ='"xxxx"-->name ismiyle  VEYA
      dataProviderClass="Day03_C01_DataProvider.class"    class ismiyle cagirabiliriz
      */


    @Test(dataProvider = "dataProvider")
    public void test01(String name) {
        System.out.println(name);

    }
    @DataProvider
    public Object [][] dataProvider() {
        //verileri teste saglayacak olan deger
        Object [][] data={{"Ali"},{"Veli"},{"Sevi"}};
return  data;
    }

}
