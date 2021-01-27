package com.autotrader.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
  /**
   * To retrieve data from configuration.properties file.
   */
  private static Properties configFile;

  static Logger logger = LoggerFactory.getLogger(ConfigurationReader.class);

  static {
    try {

      //File path of configuration.properties
      FileInputStream fileInputStream = new FileInputStream("config.properties");
      //initialize properties object
      configFile = new Properties();
      //load configuration.properties file
      configFile.load(fileInputStream);
      //close input stream
      fileInputStream.close();
    } catch (IOException e) {
      logger.info("Failed to load properties file!");
      e.printStackTrace();
    }
  }

  public static String getProperty(String key) {
    return configFile.getProperty(key);
  }

}
