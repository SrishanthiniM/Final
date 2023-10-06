package ApachePOI;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelsheet {
	public static void main(String[] args) throws IOException {
		//location of the excel path
		String excelFilePath=".\\data\\Admission sheet.xlsx";
		//connected the stream
		FileInputStream inputstream=new FileInputStream(excelFilePath);
	
	//workbook creation
		XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
		
		//sheet
		//XSSFSheet sheet=workbook.getSheet("Sheet1");
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		//////////   Iterator ///////////////
		
		java.util.Iterator<Row> iterator=sheet.iterator();
		//we have read the all columns and  rows we are using the iterator method.
		while(iterator.hasNext()) {// has next will check the particular object there are not
			
			XSSFRow row=(XSSFRow) iterator.next();//capture each individual value  
		//this row contain the multiple cell
			
			java.util.Iterator<Cell> cellIterator=row.cellIterator();
			while(cellIterator.hasNext()) {
		
				XSSFCell cell= (XSSFCell) cellIterator.next();	
				
				switch(cell.getCellType())//type of cell
				{
					case STRING: System.out.print(cell.getStringCellValue());break;
					case NUMERIC:System.out.print(cell.getNumericCellValue());break;
					case BOOLEAN: System.out.print(cell.getBooleanCellValue());break;
				}
				System.out.print(" | ");
			}
			System.out.println();
			}
		
		}

	public static String[][] getExcelData() {
		// TODO Auto-generated method stub
		return null;
	}
			

	}

