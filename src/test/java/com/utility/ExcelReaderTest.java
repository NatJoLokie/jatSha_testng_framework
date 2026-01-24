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

public class ExcelReaderTest {
    public static void main(String[] args) throws IOException, InvalidFormatException {

//        Path excelFilePath = Paths.get(System.getProperty("user.dir"), "testData", "loginData.xlsx");

        File xssfFile = new File(System.getProperty("user.dir") + "/testData/loginData.xlsx");

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(xssfFile);
        List<User> userList = new ArrayList<User>();
        Row row;
        Cell firstCell;
        Cell secondCell;
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("loginTestData");
        Iterator<Row> rowIterator = xssfSheet.iterator();

        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            firstCell = row.getCell(0);
            secondCell = row.getCell(1);
            User user = new User(firstCell.toString(), secondCell.toString());
            userList.add(user);

            System.out.println(firstCell.toString());
            System.out.println(secondCell.toString());

        }
        xssfWorkbook.close();
    }
}
