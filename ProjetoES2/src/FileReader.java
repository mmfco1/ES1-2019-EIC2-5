import java.io.File;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReader {

	private XSSFWorkbook wb;
	private XSSFSheet sheet;
	private final int ROW_LENGTH = 12;

	public FileReader() {

	};
	


	
	/*
	 * Leitura do Excel e criacao da Sheet
	 * Afonso Belard
	 */

	public String[][] createCols(File file) throws InvalidFormatException, IOException {
		wb = new XSSFWorkbook(file);
		sheet = wb.getSheetAt(0);
		int introws = sheet.getPhysicalNumberOfRows();
		DataFormatter dataFormatter = new DataFormatter();
		String[][] cols = new String[introws][ROW_LENGTH];

		for (Row row : sheet) {
			for (Cell cell : row) {
				String cellValue = dataFormatter.formatCellValue(cell);
				cols[cell.getRowIndex()][cell.getColumnIndex()] = cellValue;
			}
		}
		return cols;
	}

}
