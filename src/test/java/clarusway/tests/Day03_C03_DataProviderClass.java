package clarusway.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day03_C03_DataProviderClass {


    @DataProvider(name="testData")
    public  Object[][] data(){
        Object[][] returnData={{"First test","Birinci Test"},
                {"Second Test","Ikinci Test"},
                {"Thirt Test","Ucuncu Test"}
        };
            return returnData;
    }
}
