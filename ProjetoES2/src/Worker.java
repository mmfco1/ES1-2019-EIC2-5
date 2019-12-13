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

//	private final int ROW_LENGTH = 12;
	public enum RuleType {
		BIGGER, SMALLER, EQUAL
	};

	public enum Metric {
		LOC, CYCLO, ATFD, LAA
	};

	public Worker() {

	}

	public String[][] createCols(File file) throws InvalidFormatException, IOException {
		wb = new XSSFWorkbook(file);
		sheet = wb.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		int length = 0;
		for (Row row : sheet) {
			if (length < row.getLastCellNum())
				length = row.getLastCellNum();
		}
		DataFormatter dataFormatter = new DataFormatter();
		String[][] cols = new String[lastRowNum + 1][length];

		// PERCORRER O EXCEL E PREENCHER A MATRIZ
		for (Row row : sheet) {
			for (Cell cell : row) {
				String cellValue = dataFormatter.formatCellValue(cell);
				cols[cell.getRowIndex()][cell.getColumnIndex()] = cellValue;
			}
		}
		return cols;
	}

	public boolean testar(int a, int b, RuleType rt) {
		boolean bool = false;
		switch (rt) {
		case BIGGER: bool = a > b; break;
		case SMALLER: bool = a < b; break;
		case EQUAL: bool = a == b; break;
		}
		return bool;
	}

	public boolean[] checkMetric(String[][] sheet, Metric m, int a, RuleType rt) {
		boolean[] bool = new boolean[sheet.length];
		int col = 0;
		switch (m) {
		case LOC: col = 5; break;
		case CYCLO: col = 6; break;
		case ATFD: col = 7; break;
		case LAA: col = 8; break;
		}
		for (int i = 0; i < sheet.length; i++) {
			if (testar(Integer.valueOf(sheet[i][col]), a, rt)) {
				bool[i] = true;
			} else {
				bool[i] = false;
			}
		}
		return bool;
	}

	public String[][] applyRule(String[][] sheet){
		
		
		return sheet;
	}

	public void adicionaRegra(Regras regras) {
		
	}
	
	
	
	
}
