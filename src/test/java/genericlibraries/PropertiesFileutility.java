package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains reusable methods related to actions perfromed on properties file
 * @author manoj
 *
 */

public class PropertiesFileutility
{
	private Properties property;
	/**
	 * This method is used to initialize Properties file
	 * @param path
	 */
	public void propertyfileinitilization(String path)
	{
		FileInputStream fis=null;
		try
		{
		fis=new FileInputStream(path);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method  is used to fetch the data from properties file
	 * @param key
	 * @param value
	 * @param path
	 * @param message
	 */
	public String fetchProperty(String key)
	{
		return property.getProperty(key);
	}
	/**
	 * this method
	 * @param key
	 * @param value
	 * @param path
	 * @param message
	 */
	public void modifyProperties(String key,String value ,String path , String message)
	{
		property.put(key, value);
		FileOutputStream fos=null;
		try
		{
			fos=new FileOutputStream(path);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			property.store(fos, message);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			}
		}
		}
