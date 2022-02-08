package utils.page.data;

import com.google.gson.Gson;
import test.CredsData;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataObjectBuilder {

    public static CredsData[] buildCredObject(String jsonDataFileLocation){
        CredsData[] credsData = null;
        String currentProjectLocation = System.getProperty("user.dir");
        try(
                Reader jsonContentReader = Files.newBufferedReader(Paths.get(currentProjectLocation + jsonDataFileLocation));
        ) {
            Gson gson = new Gson();
            credsData = gson.fromJson(jsonContentReader, CredsData[].class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return credsData;
    }

    public static void main(String[] args) {
        String jsonDataFileLocation = "/src/test/resources/test_data_authentication/InvalidCreds.json";
        CredsData[] credsData = DataObjectBuilder.buildCredObject(jsonDataFileLocation);
        for (CredsData credsDatum : credsData) {
            System.out.println(credsDatum.toString());

        }
    }
}
