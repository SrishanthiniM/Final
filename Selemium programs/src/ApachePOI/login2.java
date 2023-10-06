package ApachePOI;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;
public class login2 {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter your username: ");
	        String username = sc.nextLine();
	        System.out.print("Enter your password: ");
	        int password = sc.nextInt();
	        sc.close();

	        try {
	            boolean loginValid = isLoginValid("D://loginsheet.xlsx",username,password);

	            // Append the result to the output Excel file
	            writeToResultExcel(loginValid);

	            if (loginValid) {
	                System.out.println("Login successful!");
	            } else {
	                System.out.println("Check the credentials!");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static boolean isLoginValid(String filePath, String username, int password) throws IOException {
	        try (FileInputStream file = new FileInputStream(new File(filePath));
	             Workbook workbook = new XSSFWorkbook(file)) {

	            Sheet sheet = workbook.getSheetAt(0);

	            Iterator<Row> rowIterator = sheet.iterator();
	            while (rowIterator.hasNext()) {
	                Row row = rowIterator.next();
	                Cell usernameCell = row.getCell(0); // username is in the first column
	                Cell passwordCell = row.getCell(1); // password is in the second column

	                String storedUsername = usernameCell.getStringCellValue();
	                int storedPassword;
	                
	                if (passwordCell.getCellType() == CellType.NUMERIC) {
	                    storedPassword = (int) passwordCell.getNumericCellValue();
	                } else if (passwordCell.getCellType() == CellType.STRING) {
	                    try {
	                	storedPassword = Integer.parseInt(passwordCell.getStringCellValue());
	                    }catch(NumberFormatException e) { 
	                    	storedPassword = -1;
	                    }
	                } else {
	                    // Handle other cell types as needed
	                    storedPassword = -1; // Default value or appropriate handling
	                }

	                if (storedUsername.equals(username) && storedPassword == password) {
	                    return true; // Login successful
	                }
	            }
	        }

	        return false; // Check credentials
	    }

	    public static void writeToResultExcel(boolean loginValid) throws IOException {
	    	 FileInputStream resultFile = null;
		      Workbook workbook = null;
		      try {
		          // Open the existing result Excel illana it create automatiaclly
		          File outputFile = new File("D://login_result.xlsx");
		          if (outputFile.exists()) {
		              resultFile = new FileInputStream(outputFile);
		            		  workbook = new XSSFWorkbook(resultFile);
		          } else {
		              workbook = new XSSFWorkbook();
		          }
	            Sheet sheet = workbook.getSheet("Login Result");
	            if (sheet == null) {
	                sheet = workbook.createSheet("Login Result");
	            }

	            int lastRowNum = sheet.getLastRowNum();
	            Row row = sheet.createRow(lastRowNum + 1);
	            Cell cell = row.createCell(0);

	            if (loginValid) {
	                cell.setCellValue("Pass");
	            } else {
	                cell.setCellValue("Fail");
	            }
	            FileOutputStream fileOut = new FileOutputStream(outputFile);
		          workbook.write(fileOut);
		          fileOut.close();
		      } finally {
		          if (workbook != null) {
		              workbook.close();
		          }
		          if (resultFile != null) {
		              resultFile.close();
		          }
		      }
		  }
		}

