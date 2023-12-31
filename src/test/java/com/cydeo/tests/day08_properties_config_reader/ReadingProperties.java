package com.cydeo.tests.day08_properties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_test() throws IOException {
        //1--> create the object of Properties
        Properties properties = new Properties();

        //2--> we need to open the file in java memory : FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");

        //3--> load the properties object
        properties.load(file);

        //4--> user properties object to read value
        System.out.println("browser = " + properties.getProperty("browser"));
        System.out.println("env = " + properties.getProperty("env"));
        System.out.println("username = " + properties.getProperty("username"));

    }

}
