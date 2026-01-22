package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {

    public static Iterator<User> readCsvFile(String CsvFileName) {

        File csvFile = new File(System.getProperty("user.dir") + "/testData/" + CsvFileName + ".csv");
        FileReader fileReader = null;
        CSVReader csvReader;
        String[] line;
        List<User> userList = null;
        User userData;
        try {
            fileReader = new FileReader(csvFile);
            csvReader = new CSVReader(fileReader);
//            csvReader.readNext();// Reads the immediate line in the cvs file in this case the header line Row No 1
//            csvReader.readNext(); //Row No 2
            csvReader.readNext(); //Row No 3
            userList = new ArrayList<>();
            while ((line = csvReader.readNext()) != null) {
                userData = new User(line[0], line[1]);
                userList.add(userData);
            }
//            for (User user : userList) {
//                System.out.println(user.toString());
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        return userList.iterator();

    }
}
