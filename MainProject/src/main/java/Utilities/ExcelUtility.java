package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;


public class ExcelUtility {
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream f;
	
	public static String getString(int i, int j, String filePath, String sheetName) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir")+filePath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		XSSFRow r = sh.getRow(i);
		XSSFCell c = r.getCell(j);
		return c.getStringCellValue();
	}
	
	public static String getNumeric(int i, int j, String filePath, String sheetName) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir")+filePath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		XSSFRow r = sh.getRow(i);
		XSSFCell c = r.getCell(j);
		int value = (int)c.getNumericCellValue();
		return String.valueOf(value);
		
	}

}
