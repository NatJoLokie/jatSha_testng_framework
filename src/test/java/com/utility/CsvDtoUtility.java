package com.utility;

import com.dto.UserDTO;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvDtoUtility {
    public static List<UserDTO> readCsvDtoUtility(String csvFileName) {
        List<UserDTO> userDTOList = new ArrayList<>();
        Path csvFilePath = Paths.get(System.getProperty("user.dir"), "testData", csvFileName + ".csv");
//C:\Users\User\IdeaProjects\TechWithJatan\TestNGFrameWork\testData\loginData.csv
        FileReader fileReader;
        CSVReader csvReader;

        try {
            fileReader = new FileReader(csvFilePath.toFile());
            csvReader = new CSVReader(fileReader);
            String[] headers = csvReader.readNext();
            String[] row;

            while ((row = csvReader.readNext()) != null) {
                Map<String, String> rowData = mapRow(headers, row);

                UserDTO userDTO = new UserDTO(
                        rowData.get("emailAddress"),
                        rowData.get("password"),
                        rowData.get("loginVerify"),
                        rowData

                );

                userDTOList.add(userDTO);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Executing from Csv Dto Utility ");

        return userDTOList;
    }

    private static Map<String, String> mapRow(String[] headers, String[] row) {
        Map<String, String> data = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            data.put(headers[i], row[i]);
        }
        return data;

    }

}