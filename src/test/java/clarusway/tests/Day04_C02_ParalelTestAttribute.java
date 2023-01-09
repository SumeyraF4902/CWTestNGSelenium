package clarusway.tests;

import clarusway.utilities.BaseCrossBrowserTest;
import org.testng.annotations.Test;

public class Day04_C02_ParalelTestAttribute  {


    @Test(
            threadPoolSize=2,       //testimizin      kac cekirdekte paralel olarak calisacagini belirler
             invocationCount = 7     //testimizin kac defa calistirilacagini belirler
    )
    public  void test01(){
        System.out.println("Current thread Id: "+Thread.currentThread().getId());


    }

    @Test(
            threadPoolSize=4,       //testimizin      kac cekirdekte paralel olarak calisacagini belirler
            invocationCount = 2     //testimizin kac defa calistirilacagini belirler
    )
    public  void test02(){
        System.out.println("Current thread Id: "+Thread.currentThread().getId());
    }



}
