package com.ui.dataProviders;

import com.dto.UserDTO;
import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.CsvDtoUtility;
import com.utility.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "loginDataProvider")
    public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {

        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir") + "/testData/loginData.json");
        System.out.println(testDataFile);

        FileReader fileReader = new FileReader(testDataFile);
        TestData testData = gson.fromJson(fileReader, TestData.class); //deserialization

        System.out.println(testData.toString());

        List<Object[]> dataToReturn = new ArrayList<Object[]>();
        for (User user : testData.getData()) {
            Object[] wrapperArr = new Object[]{user};
            dataToReturn.add(wrapperArr);
        }
/*
//        List<Object[]> dataToReturn = testData.getData().stream()
//                .map(user -> new Object[]{user}) // Wrap each user in an Object array
//                .collect(Collectors.toList());
*/
/*
//        @DataProvider(name = "userData") // TestNG example
//        public Object[][] provideData() {
//            return testData.getData().stream()
//                    .map(user -> new Object[]{user})
//                    .toArray(Object[][]::new); // Converting List to 2D Array is often preferred
//        }
*/
        return dataToReturn.iterator();
    }

    @DataProvider(name = "loginTestCsvDataProvider")
    public Iterator<User> loginCsvDataProvider() {
        return CSVReaderUtility.readCsvFile("loginData");
    }

    @DataProvider(name = "loginTestExcelDataProvider")
    public Iterator<User> loginExcelDataProvider() {
        return ExcelReaderUtility.readExcelFile("loginData");
    }

    @DataProvider(name = "loginTestCsvDtoDataProvider")
    public Iterator<Object[]> userData() {
        List<Object[]> data = new ArrayList<>();

        for (UserDTO user : CsvDtoUtility.readCsvDtoUtility("loginData")) {
            data.add(new Object[]{user});
        }
        System.out.println("Executing from Login Data Provider > loginTestCsvDtoDataProvider ");

        return data.iterator();

    }


}
