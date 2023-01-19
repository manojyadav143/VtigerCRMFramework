package propertiesfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataToPropertiesFile
{
public static void main(String[] args) throws IOException 
{
FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
Properties p=new Properties();
p.load(fis);
//used to write data into properties file
p.put("username", "manoj");
FileOutputStream fos=new FileOutputStream("./src/test/resources/commonData.properties");
//save data into properties 
p.store(fos, "Username Modified");	
}
}
