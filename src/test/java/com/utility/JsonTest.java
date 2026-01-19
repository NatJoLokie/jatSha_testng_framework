package com.utility;

import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonTest {
    public static void main(String[] args) throws FileNotFoundException {

        Gson gson = new Gson();
        File jsonFile = new File(System.getProperty("user.dir") + "\\config\\config.json");
        FileReader fileReader = new FileReader(jsonFile);
        Config config = gson.fromJson(fileReader, Config.class);
        Environment environment = config.getEnvironments().get("QA");
        System.out.println(environment.getUrl());

    }
}
