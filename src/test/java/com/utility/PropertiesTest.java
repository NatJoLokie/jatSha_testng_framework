package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {

        File file = new File(System.getProperty("user.dir") + "\\config\\QA.properties");

        System.out.println(file.toString());

        FileReader fileReader = new FileReader(file);

        Properties properties = new Properties();

        properties.load(fileReader);
        String url = properties.getProperty("URL");
        System.out.println(url);

    }
}
