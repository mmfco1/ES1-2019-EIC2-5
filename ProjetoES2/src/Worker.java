import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Worker {

	private XSSFWorkbook wb;
	private XSSFSheet sheet;
	private final int ROW_LENGTH = 12;

	public Worker() {

	}

	public boolean is_long_method(int loc, int locThreshold, int cyclo, int cycloThreshold) {
		if (loc > locThreshold && cyclo > cycloThreshold)
			return true;
		return false;
	}

	public boolean is_feature_envy(int atfd, int atfdThreshold, int laa, int laaThreshold) {
		if (atfd > atfdThreshold && laa < laaThreshold)
			return true;
		return false;
	}

	public String[][] createCols(File file) throws InvalidFormatException, IOException {
		wb = new XSSFWorkbook(file);
		sheet = wb.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		DataFormatter dataFormatter = new DataFormatter();
		String[][] cols = new String[lastRowNum + 1][ROW_LENGTH];

		//PERCORRER O EXCEL E PREENCHER A MATRIZ
		for (Row row : sheet) {
			for (Cell cell : row) {
				String cellValue = dataFormatter.formatCellValue(cell);
				cols[cell.getRowIndex()][cell.getColumnIndex()] = cellValue;
			}
		}
		return cols;
	}

	public void checkMethods(String[][] sheet, int loc, int cyclo, int atfd, int laa) {

		for (int j = 0; j < sheet.length; j++) {
			if (is_long_method(Integer.valueOf(sheet[j][5]), loc, Integer.valueOf(sheet[j][6]), cyclo)) {
				sheet[j][9] = "TRUE";
			} else {
				sheet[j][9] = "FALSE";
			}
		}

		for (int j = 0; j < sheet.length; j++) {
			if (is_feature_envy(Integer.valueOf(sheet[j][7]), atfd, Integer.valueOf(sheet[j][8]), laa)) {
				sheet[j][12] = "TRUE";
			} else {
				sheet[j][12] = "FALSE";
			}
		}

	}

} 
