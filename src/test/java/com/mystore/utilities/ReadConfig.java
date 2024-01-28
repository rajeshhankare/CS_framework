package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	String path = "C:\\Users\\Rajesh\\eclipse-workspace\\TEstNG\\configuration\\config.properties";

	//create consturctor

	public ReadConfig()
	{
		try {
			properties = new Properties();

			// to read file value crate FileInputStream class

			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
   public String getBaseurl()
   {
	  String value =  properties.getProperty("baseurl");
	  
	  if (value!=null)
		  return value;
	  else
		  throw new RuntimeException("url not specified in config file.");
	  
   }
   public String getBrowser()
   {
	  String value =  properties.getProperty("browser");
	  
	  if (value!=null)
		  return value;
	  else
		  throw new RuntimeException("url not specified in config file.");
	  
   }

}
