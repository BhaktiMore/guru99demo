package com.medo.utilities;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	static String projectpath;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	// constructor
	public ReadExcel(String excelpath, String sheetname) {

		try {
			projectpath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(excelpath);
			sheet = workbook.getSheet(sheetname);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static int getRowCount() {
		int rowcount = 0;
		try {
			rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println(rowcount);
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return rowcount;
	}

	public static int getColCount() {
		int colcount = 0;
		try {
			colcount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println(colcount);
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return colcount;

	}

	public static String getCellDataString(int rowNum, int colNum) {
		String celldata = null;
		try {
			celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(celldata);
		}

		catch (Exception e1) {
			System.out.println(e1.getMessage());
			System.out.println(e1.getCause());
			e1.printStackTrace();

		}

		return celldata;
	}

	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
			double celldata1 = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();

			System.out.println(celldata1);
		} catch (Exception e2) {

			System.out.println(e2.getMessage());
			System.out.println(e2.getCause());
			e2.printStackTrace();
		}
	}
}
