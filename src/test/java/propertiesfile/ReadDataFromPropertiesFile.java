package propertiesfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile
{
public static void main(String[] args) throws IOException 
{
//step 1:convert physical file into java readable object
	FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
	//step 2: create an instance for properties class
	// properties class is available in java.util package
	Properties p=new Properties();
	//step 3: load all the key value pairs to properties object
	p.load(fis);//ioException
	//java concept involved- map interface-hashTable
	//step 4 : Read data
	String url= p.getProperty("url");
	long time = Long.parseLong(p.getProperty("timeouts"));
	System.out.println(url+"\t"+time);
	
}
}
