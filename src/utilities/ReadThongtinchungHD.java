package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.ThongTinHD;

public class ReadThongtinchungHD {
	public static final String COLUMN_INDEX_Stt = "Stt";
	public static final String COLUMN_INDEX_Serial = "Serial";
	public static final String COLUMN_INDEX_Makhachhang = "Makhachhang";
	public static final String COLUMN_INDEX_Hotennguoimua = "Hotennguoimua";
	public static final String COLUMN_INDEX_Donvimua = "Donvimua";
	public static final String COLUMN_INDEX_Masothue = "Masothue";
	public static final String COLUMN_INDEX_Diachi = "Diachi";
	public static final String COLUMN_INDEX_Hinhthucthanhtoan = "Hinhthucthanhtoan";
	public static final String COLUMN_INDEX_Ghichu = "Ghichu ";
	public static final String COLUMN_INDEX_ThueGTGT = "ThueGTGT";
	
	public static List<ThongTinHD> readExcel(String excelFilePath, int sheetIndex) throws IOException {
		List<ThongTinHD> listthongtinhd = new ArrayList<>();

		// Get file
		InputStream inputStream = new FileInputStream(new File(excelFilePath));

		// Get workbook
		Workbook workbook = getWorkbook(inputStream, excelFilePath);

		// Get sheet
		Sheet sheet = workbook.getSheetAt(sheetIndex);

		// Get all rows
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				// Ignore header
				continue;
			}

			// Get all cells
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			// Read cells and set value for book object
			ThongTinHD thongtinhd = new ThongTinHD();
			while (cellIterator.hasNext()) {
				// Read cell
				Cell cell = cellIterator.next();
				Object cellValue = getCellValue(cell);
				if (cellValue == null || cellValue.toString().isEmpty()) {
					continue;
				}
				// Set value for thongtinchung object
				// lấy ra số cột
				int columnIndex = cell.getColumnIndex();
				// lấy ra tên cột bằng cách lấy dòng đầu tiên-> lấy ô theo số
				// cột-> xong lấy giá trị của ô đó
				String columnName = sheet.getRow(0).getCell(columnIndex).getStringCellValue().trim();
				// so sánh các trường hợp theo tên cột
				switch (columnName) {
				case COLUMN_INDEX_Stt:
					thongtinhd.setStt(getCellValue(cell).toString());
					break;
				case COLUMN_INDEX_Serial:
					thongtinhd.setSerial((String) getCellValue(cell));
					break;
				case COLUMN_INDEX_Makhachhang:
					thongtinhd.setMakhachhang((String) getCellValue(cell));
					break;
				case COLUMN_INDEX_Hotennguoimua:
					thongtinhd.setHotennguoimua((String) getCellValue(cell));
					break;
				case COLUMN_INDEX_Donvimua:
					thongtinhd.setDonvimua((String) getCellValue(cell));
					break;
				case COLUMN_INDEX_Masothue:
					thongtinhd.setMasothue((String) getCellValue(cell));
					break;
				case COLUMN_INDEX_Diachi:
					thongtinhd.setDiachi((String) getCellValue(cell));
					break;
				case COLUMN_INDEX_Hinhthucthanhtoan:
					thongtinhd.setHinhthucthanhtoan((String) getCellValue(cell));
					break;
				case COLUMN_INDEX_Ghichu:
					thongtinhd.setGhichu((String) getCellValue(cell));
					break;
					
				case COLUMN_INDEX_ThueGTGT:
					thongtinhd.setThueGTGT((String) getCellValue(cell));
					break;
	
				default:
					break;
				}

			}
			listthongtinhd.add(thongtinhd);
		}

		workbook.close();
		inputStream.close();

		return listthongtinhd;
	}

	// Get Workbook
	private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
		Workbook workbook = null;
		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}

		return workbook;
	}

	// Get cell value
	private static Object getCellValue(Cell cell) {
		CellType cellType = cell.getCellTypeEnum();
		Object cellValue = null;
		switch (cellType) {
		case BOOLEAN:
			cellValue = cell.getBooleanCellValue();
			break;
		case FORMULA:
			Workbook workbook = cell.getSheet().getWorkbook();
			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			cellValue = evaluator.evaluate(cell).getNumberValue();
			break;
		case NUMERIC:
			cellValue = cell.getNumericCellValue();
			break;
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case _NONE:
		case BLANK:
		case ERROR:
			break;
		default:
			break;
		}

		return cellValue;
	}
}
