package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String projectPath;
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
	public static void main(String[] args) {
		getCellData(1,0);
	}

	public  ExcelUtils(String excelPath ,String sheetName) {

		try {
			workBook = new XSSFWorkbook(excelPath);
			sheet=workBook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}


	public static  String getCellData(int row,int col) {

		String data =sheet.getRow(row).getCell(col).getStringCellValue();
		//		System.out.println(data);

		return data;

	}

	public static double getCellNumaricData(int row,int col) {

		double data =sheet.getRow(row).getCell(col).getNumericCellValue();
		//		System.out.println(data);

		return data;

	}
	public static void getRowCount() {


		int rowcount=sheet.getPhysicalNumberOfRows();
		System.out.println("Num of rows is: "+rowcount);




	}
}
