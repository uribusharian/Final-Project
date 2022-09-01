package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {

	private final String fileName;

	public ExcelUtils() {
		fileName = "data.xlsx";
	}

	public List<Object[]> readExcelFile(String fileName, int index) {
		FileInputStream inStream = null;
		XSSFWorkbook workbook = null;
		List<Object[]> lst = new ArrayList<>();
		try {
			inStream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inStream);
			XSSFSheet sheet = workbook.getSheetAt(index);
			Iterator<Row> rowIter = sheet.rowIterator();
			rowIter.next();
			while (rowIter.hasNext()) {
				Row row = rowIter.next();

				Iterator<Cell> cellIter = row.cellIterator();
				int colNum = row.getLastCellNum();
				Object[] obj = new Object[colNum];
				int i = 0;
				for(  Object curr : obj ) {
					obj[i] = cellIter.next().toString();
					i++;
				}
				lst.add(obj);
			}
			workbook.close();
			inStream.close();
			} catch (IOException e) {
						e.printStackTrace();
			}
		return lst;
	}

	public Object[][] initDataProvider(int sheetIndex,int startRow,int endRow ){
		ExcelUtils eu = new ExcelUtils();
		List<Object[]> lst = eu.readExcelFile(fileName,sheetIndex);

		Object[][] obj = new Object [lst.size()][];
		for (int i = startRow; i < endRow; i++)
			{ Object[] arr = lst.get(i); obj[i] = arr; }
		return obj;

	}

}
