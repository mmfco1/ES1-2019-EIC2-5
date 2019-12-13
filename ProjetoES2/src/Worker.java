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
	private Gui gui;

//	private final int ROW_LENGTH = 12;
	public enum RuleType {
		BIGGER, SMALLER, EQUAL
	};

	public enum Metric {
		LOC, CYCLO, ATFD, LAA
	};

	public Worker(Gui gui) {
		this.gui = gui;
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

	public boolean testar(double a, double b) {
		boolean bool = true;
		if (b < 0) {
			b = b * (-1);
			return a < b;
		} else if (b > 0)
			return a > b;
		else
			return bool;
	}

	public String[][] adicionaRegra(Regras regra, String[][] sheet) {
		String[][] batata = sheet;
		int lastsheetCol = sheet[0].length;
		int lastCol = lastsheetCol + 1;

		String[][] temp = new String[sheet.length][lastCol];

		int loc = regra.getLoc();
		int cyclo = regra.getCyclos();
		int atfd = regra.getAftd();
		double laa = regra.getLaa();
		int erros = 0;

		for (int i = 0; i < sheet.length; i++) {

			for (int j = 0; j < lastCol; j++) {
				if (i == 14 && j == 12) {
					System.out.println("TAKE COVER");
				}
				if (j < lastsheetCol) {
					temp[i][j] = sheet[i][j];
				} else {
					if (i == 0) {
						temp[i][lastsheetCol] = regra.getNome();
					} else {
						if (testar(Integer.parseInt(sheet[i][4]), loc) && testar(Integer.parseInt(sheet[i][5]), cyclo)
								&& testar(Integer.parseInt(sheet[i][6]), atfd)
								&& testar(Double.parseDouble(sheet[i][7]), laa))
							temp[i][lastsheetCol] = "TRUE";

						else {
							temp[i][lastsheetCol] = "FALSE";
							erros++;
						}
					}
				}
				System.out.println(i + " " + j);
			}

		}
		gui.batata(erros);
		return temp;
	}

	public String[][] editarRegra(Regras regra, String[][] sheet) {

		String[][] temp = new String[sheet.length][sheet[0].length];

		int loc = regra.getLoc();
		int cyclo = regra.getCyclos();
		int atfd = regra.getAftd();
		double laa = regra.getLaa();
		int erros = 0;
		int colDaRegra = 0;
		
		if (regra.getNome().equals("is_long_method"))
			colDaRegra = 8;
		if (regra.getNome().equals("is_feature_envy"))
			colDaRegra = 11;

		for (int i = 0; i < sheet.length; i++) {
			for (int j = 0; j < sheet[0].length; j++) {
				if (!(j == colDaRegra)) {
					temp[i][j] = sheet[i][j];
				} else {
					if (i == 0) {
						temp[i][colDaRegra] = regra.getNome();
					} else {
						if (testar(Integer.parseInt(sheet[i][4]), loc) && testar(Integer.parseInt(sheet[i][5]), cyclo)
								&& testar(Integer.parseInt(sheet[i][6]), atfd)
								&& testar(Double.parseDouble(sheet[i][7]), laa))
							temp[i][colDaRegra] = "TRUE";

						else {
							temp[i][colDaRegra] = "FALSE";
							erros++;
						}
					}
				}

			}

		}
		gui.batata(erros);
		return temp;
	}
	
	public void detecaoDefeitos(String[][] sheet, int a) {
		int dci = 0, dii = 0, adci = 0, adii = 0;
		for(int i = 0; i < sheet.length; i++) {
			if(sheet[i][a].equals("TRUE") && sheet[i][8].equals("TRUE")) {
				dci++;
			} else if (sheet[i][a].equals("TRUE") && sheet[i][8].equals("FALSE")) {
				dii++;
			} else if (sheet[i][a].equals("FALSE") && sheet[i][8].equals("FALSE")) {
				adci++;
			} else {
				adii++;
			}
		}
		
	}

}
