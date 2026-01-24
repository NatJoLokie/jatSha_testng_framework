///*
//package com.utility;
//
//import com.dto.UserDTO;
//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;
//
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class CsvDtoTest {
//    public static void main(String[] args) throws IOException, CsvValidationException {
//        List<UserDTO> userDTOList = new ArrayList<>();
//
//        File csvFilePath = new File(System.getProperty("user.dir") + "/testData/" + "loginData.csv");
//
//        FileReader fileReader = new FileReader(csvFilePath);
//
//        CSVReader csvReader = new CSVReader(fileReader);
//        String[] headers = csvReader.readNext();
//        String[] row;
//
//        while ((row = csvReader.readNext()) != null) {
//            Map<String, String> rowData = mapRow(headers, row);
//
//
//            UserDTO userDTO = new UserDTO(
//                    rowData.get("emailAddress"),
//                    rowData.get("password"),
//                    rowData.get("loginVerify"));
//
//            userDTOList.add(userDTO);
//        }
//
//        csvReader.close();
//    }
//
//
//    private static Map<String, String> mapRow(String[] headers, String[] row) {
//        Map<String, String> data = new HashMap<>();
//        for (int i = 0; i < headers.length; i++) {
//            data.put(headers[i], row[i]);
//        }
//        return data;
//
//    }
//}
//*/
