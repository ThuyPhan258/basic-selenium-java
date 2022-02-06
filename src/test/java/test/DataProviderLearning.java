package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.page.data.DataObjectBuilder;

public class DataProviderLearning {

    @Test(dataProvider = "wrongCredData")
    public void loginWithIncorrectCreds(CredsData credsData){
        System.out.println(credsData.getUsername());
        System.out.println(credsData.getPassword());
        System.out.println("=====================\n");
    }

    @DataProvider
    public CredsData[] wrongCredData(){
        String jsonDataFileLocation = "/src/test/resources/test_data_authentication/LoginCreds.json";
        return DataObjectBuilder.buildCredObject(jsonDataFileLocation);
    }

    @DataProvider
    public Object[][] wrongCredDatabk(){
        return new Object[][] {
                {"Cedric", "password_1"},
                {"Anne", "password_2"},
        };
    }
}
