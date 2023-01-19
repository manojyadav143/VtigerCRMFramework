package excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel1
{
public static void main(String[] args) throws EncryptedDocumentException, IOException
{
	//step 1:Convert physical file  to java readable object 
		FileInputStream fis=new FileInputStream("./src/test/resources/Book1.xlsx");
		DataFormatter df=new DataFormatter();
		
		//step 2: Open the excel workbook
		//Import workbook from org.apache.poi.ss.usermodel
		//the below statement  throws  EncryptedDocumentException and IOException
		Workbook wb = WorkbookFactory.create(fis);
		
		//System.out.println(wb.getSheet("Sheet1").getRow(3).getCell(0).getNumericCellValue());
		//System.out.println(df.formatCellValue(wb.getSheet("Sheet1").getRow(3).getCell(0)));
		String data=wb.getSheet("Sheet1").getRow(3).getCell(1).getStringCellValue();
		System.out.println(data);
		wb.close();
		
		
}
}
