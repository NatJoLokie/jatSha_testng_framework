package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<User> readExcelFile(String excelFileName) {

        System.out.println("Reading Excel file: " + excelFileName);

//        Path excelFilePath = Paths.get(System.getProperty("user.dir"), "testData", excelFileName + ".xlsx");

        File xssfFile = new File(System.getProperty("user.dir") + "/testData/" + excelFileName + ".xlsx");

        XSSFWorkbook xssfWorkbook = null;
        List<User> userList=null;
        User user;
        XSSFSheet xssfSheet;
        Row row;
        Cell firstCell;
        Cell secondCell;
        Iterator<Row> rowIterator;
        try {
            xssfWorkbook = new XSSFWorkbook(xssfFile);
            userList = new ArrayList<User>();
            xssfSheet = xssfWorkbook.getSheet("loginTestData");
            rowIterator = xssfSheet.iterator();
            rowIterator.next(); //skips the first row if it contains headers

            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                firstCell = row.getCell(0);
                secondCell = row.getCell(1);
                user = new User(firstCell.toString(), secondCell.toString());
                userList.add(user);
                xssfWorkbook.close();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
    }
}
