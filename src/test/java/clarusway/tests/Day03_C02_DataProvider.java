package clarusway.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day03_C02_DataProvider {

    //user name, email, password,number

    @Test(dataProvider = "getData")
    public void test(String userName, String email, String password,int number){
        System.out.println("userName:"+userName);
        System.out.println("email = " + email);
        System.out.println("password = " + password);
        System.out.println("number = " + number);


    }
    @DataProvider
    public Object [][] getData(){
        Object [][] data = {
                {"Karl","karl@cw.com","123",1},
                {"Drake","drake@cw.com","369",2},
                {"Garry","garry@cw.com","987",3},
                {"Elly","elly@cw.com","9541",4},

        };
        return data;

        }
    }

