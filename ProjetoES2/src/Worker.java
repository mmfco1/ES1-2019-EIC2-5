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

	public boolean testar(int a, int b) {
		boolean bool = true;
		if (b > 0)
			bool = a > b;
		if (b < 0)
			bool = a < (b * (-1));
		return bool;
	}

//	public boolean[] checkMetric(String[][] sheet, int a, int b) {
//		boolean[] bool = new boolean[sheet.length];
//
//		for (int i = 0; i < sheet.length; i++) {
//			if (testar(Integer.valueOf(sheet[i][a]), b)) {
//				bool[i] = true;
//			} else {
//				bool[i] = false;
//			}
//		}
//		return bool;
//	}

	public String[][] adicionaRegra(Regras regra, String[][] sheet) {
		int lastCol = sheet[0].length;
		String[][] temp = new String[sheet.length][lastCol + 1];
		temp[0][lastCol] = regra.getNome();
		int loc = regra.getLoc();
		int cyclo = regra.getCyclos();
		int atfd = regra.getAftd();
		int laa = regra.getLaa();

		for(int i = 1; i < sheet.length; i++) {
			if(testar(Integer.parseInt(sheet[i][5]), loc) &&
					testar(Integer.parseInt(sheet[i][6]), cyclo) &&
					testar(Integer.parseInt(sheet[i][7]), atfd) &&
					testar(Integer.parseInt(sheet[i][8]), laa)) {
				temp[i][lastCol] = "TRUE";
			}else {
				temp[i][lastCol] = "FALSE";
			}
		}
		
		return temp;
	}

	

}
