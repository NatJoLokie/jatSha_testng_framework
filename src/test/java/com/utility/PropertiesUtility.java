package com.utility;

import com.constants.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
    public static String readProperty(Env env, String propertyValue) {

        File file = new File(System.getProperty("user.dir") + "\\config\\" + env + ".properties");

        System.out.println(file.toString());

        FileReader fileReader = null;
        Properties properties = new Properties();

        try {
            fileReader = new FileReader(file);
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String url = properties.getProperty("URL");
        return url;
    }
}
