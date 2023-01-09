package clarusway.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day04_C03_ParalelTestDataProvider {


    @Test(
           dataProvider = "getData"
    )
    public  void test01(String name,String surname){
        System.out.println(name + " " +surname);
        System.out.println("Current thread Id: "+Thread.currentThread().getId());//PARALEL CALISIP CALISMADIGINI ANLAMAK ICIN YAZARIZ


    }

    @DataProvider(parallel  =true)
    public  Object[][] getData(){
        return  new Object[][]{
                {"yusuf", "Celik"},
                {"can", "efe"},
                {"merve", "Delik"}

                };
    }



}
