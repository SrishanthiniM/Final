package Edubridge;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exceldata {
	
	public static String[][] getExcelData() throws IOException{
		//providing file location where to get our excel data
			 String FileLocation ="./Exceldata/Exceldata.xlsx";
			 //passing the location of workbook
			 XSSFWorkbook wbook = null;
			try {
				wbook = new XSSFWorkbook(FileLocation);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//getting sheet by using index
			 XSSFSheet sheet=wbook.getSheetAt(0);
			 //getting row value using lastrownum
			 int lastRowNum = sheet.getLastRowNum();
			 //physical number will include header (username,password)
			 int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			 System.out.println("Inclusive of Header: " +physicalNumberOfRows);
			 System.out.println("No.of Rows :" + lastRowNum);
			 //getting last cell value
			 short lastCellNum = sheet.getRow(0).getLastCellNum();
			 //storing row and cell in two dimensional array
			 String[][] data = new String[lastRowNum][lastCellNum];
			 System.out.println("no.of cells: "+lastCellNum);
			 //using for loop to get no of data present in the excel sheet
			 for(int i = 1;i<=lastRowNum;i++) {
				 XSSFRow row = sheet.getRow(i);
			for(int j=0;j<lastCellNum;j++) {
				 XSSFCell cell = row.getCell(j);
			//accept different data types
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
	        //storing the value in data 
				data[i-1][j] = value;
				 }
			 }
			 //closing the workbook
			wbook.close();
			//returning the data
			return data;
	
	}
}