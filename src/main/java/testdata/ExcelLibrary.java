package testdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import autoconstant.AutoConstant;

public class ExcelLibrary implements AutoConstant
{
	public static String getStringValueFromCell(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	public static double getNumericValueFromCell(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		double value = wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		return value;
	}
	public static boolean getBooleanValueFromCell(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		boolean value = wb.getSheet(sheet).getRow(row).getCell(cell).getBooleanCellValue();
		return value;
	}
	public static Date getDateValueFromCell(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		Date value = wb.getSheet(sheet).getRow(row).getCell(cell).getDateCellValue();
		return value;
	}
	public static int rowCount(String sheet) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		int rowCount = wb.getSheet(sheet).getLastRowNum();
		return rowCount;
	}
	public static void cellCount(String sheet) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		for(int i=0;i<=wb.getSheet(sheet).getLastRowNum();i++)
		{
			short cellCount = wb.getSheet(sheet).getRow(i).getLastCellNum(); 
			System.out.println("number of cells present in " +i+ "row " +"is :" +cellCount);
		}
	}
}