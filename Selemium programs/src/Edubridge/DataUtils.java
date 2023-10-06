package Edubridge;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import ApachePOI.excelsheet;

public class DataUtils {
	@DataProvider()
public String[][] getData() throws IOException {
//calling the exceldata class and it will return string data type
		String[][] excelData = Exceldata.getExcelData();
	
	return excelData;
}
}
