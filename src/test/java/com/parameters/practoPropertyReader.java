package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class practoPropertyReader {
 private final Properties props = new Properties();

 public practoPropertyReader() {
     try (FileInputStream fis = new FileInputStream("src\\test\\resource\\propertyData\\practoData.properties")) {
         props.load(fis);
     } catch (IOException e) {
         throw new RuntimeException("Unable to load makemytrip.properties", e);
     }
 }

 public String get(String key) {
     return props.getProperty(key);
    }
}

