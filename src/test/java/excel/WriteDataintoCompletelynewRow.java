package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataintoCompletelynewRow 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	FileInputStream fis=new FileInputStream("./src/test/resources/Book1.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet s = wb.getSheet("Sheet1");
	//creates new row by deleting older values 
	Row r=s.createRow(4);
	Cell c=r.createCell(0);
	//writes data into the cell
	c.setCellValue("hi");
	//saves data into the excel 
	FileOutputStream fos=new FileOutputStream("./src/test/resources/Book1.xlsx");
	wb.write(fos);
	wb.close();
	
	
}
}
