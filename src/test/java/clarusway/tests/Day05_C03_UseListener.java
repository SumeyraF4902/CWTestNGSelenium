package clarusway.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Day05_C02_ITestListener.class)
public class Day05_C03_UseListener {

    @Test
    public void passettest() {
        System.out.println(" PassedTest");
    }
    @Test
    public void failedtest2() {
        System.out.println(" Failed Test2");
        Assert.fail();
    }
    @Test(
            timeOut = 500
    )
            public void timeOuttest3() throws InterruptedException {
                System.out.println("Timed outest3");
                Thread.sleep(600);
            }

}
