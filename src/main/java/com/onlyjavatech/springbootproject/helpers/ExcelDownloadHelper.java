package com.onlyjavatech.springbootproject.helpers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.onlyjavatech.springbootproject.model.BooksModel;

public class ExcelDownloadHelper {
	public static String[] HEADERS = { "id", "name", "genre" };

	public static String SHEET_NAME = "category_data";

	public static ByteArrayInputStream dataToExcel(List<BooksModel> list) throws IOException {

		Workbook workbook = new XSSFWorkbook();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {

			Sheet createSheet = workbook.createSheet(SHEET_NAME);

			Row createRow = createSheet.createRow(0);

			for (int i = 0; i < HEADERS.length; i++) {
				Cell createCell = createRow.createCell(i);
				createCell.setCellValue(HEADERS[i]);

			}

			int rowIndex = 1;

			for (BooksModel cell : list) {
				Row createRow2 = createSheet.createRow(rowIndex);
				rowIndex++;
				createRow2.createCell(0).setCellValue(cell.getId());
				createRow2.createCell(1).setCellValue(cell.getName());
				createRow2.createCell(2).setCellValue(cell.getGenre());
			}

			workbook.write(byteArrayOutputStream);

			return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			workbook.close();
			byteArrayOutputStream.close();
		}

	}

	public static boolean checkExcelFormat(MultipartFile file) {
		try {
			String contentType = file.getContentType();
			if (contentType == "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static List<BooksModel> convertExcelToListOfBooks(InputStream is) {
		List<BooksModel> arrayList = new ArrayList<>();
		try {

			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

			XSSFSheet sheet = xssfWorkbook.getSheet("data");

			int rowNumber = 0;

			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row row = iterator.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cells = row.iterator();

				int cid = 0;

				BooksModel booksModel = new BooksModel();
				while (cells.hasNext()) {
					Cell cell = cells.next();
					System.out.println(cid + cell.getStringCellValue());

					switch (cid) {
					case 0: {

						booksModel.setName(cell.getStringCellValue());
					}
					case 1: {

						booksModel.setGenre(cell.getStringCellValue());
					}
					default:
						break;

					}
					cid++;
				}
				arrayList.add(booksModel);
				System.out.println(booksModel + "--" + arrayList);
			}

			System.out.println(arrayList + "" + arrayList.size());

		} catch (Exception e) {
			return null;
		}
		return arrayList;
	}
}
