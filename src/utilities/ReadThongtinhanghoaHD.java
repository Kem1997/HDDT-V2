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

import Model.HangHoa;

public class ReadThongtinhanghoaHD {
	public static final String COLUMN_INDEX_Stt = "Stt";
	public static final String COLUMN_INDEX_Hinhthuc = "Hinhthuc";
	public static final String COLUMN_INDEX_Tenhanghoa = "Tenhanghoa";
	public static final String COLUMN_INDEX_Donvitinh = "Donvitinh";
	public static final String COLUMN_INDEX_Soluong = "Soluong";
	public static final String COLUMN_INDEX_Dongia = "Dongia";
	public static final String COLUMN_INDEX_Xoa = "Xoa";

	public static List<HangHoa> readExcel(String excelFilePath, int sheetIndex) throws IOException {
		List<HangHoa> dshanghoa = new ArrayList<>();

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
			HangHoa hanghoa = new HangHoa();
			while (cellIterator.hasNext()) {
				// Read cell
				Cell cell = cellIterator.next();
				Object cellValue = getCellValue(cell);
				if (cellValue == null || cellValue.toString().isEmpty()) {
					continue;
				}
				// Set value for thongtinchung object
				int columnIndex = cell.getColumnIndex();
				// lấy ra tên cột bằng cách lấy dòng đầu tiên-> lấy ô theo số cột-> xong lấy giá
				// trị của ô đó
				String columnName = sheet.getRow(0).getCell(columnIndex).getStringCellValue().trim();
				// so sánh các trường hợp theo tên cột
				switch (columnName) {
				case COLUMN_INDEX_Stt:
					hanghoa.setStt(getCellValue(cell).toString());
					break;
				case COLUMN_INDEX_Hinhthuc:
					hanghoa.setHinhthuc((String) getCellValue(cell));
					break;
				case COLUMN_INDEX_Tenhanghoa:
					hanghoa.setTenhanghoa((String) getCellValue(cell));
					break;
				case COLUMN_INDEX_Donvitinh:
					hanghoa.setDonvitinh((String) getCellValue(cell));
					break;
				case COLUMN_INDEX_Soluong:
					hanghoa.setSoluong(getCellValue(cell).toString());
					break;
				case COLUMN_INDEX_Dongia:
					hanghoa.setDongia(getCellValue(cell).toString());
					break;

				case COLUMN_INDEX_Xoa:
					hanghoa.setXoa((String) getCellValue(cell));
					break;
					
				default:
					break;
				}

			}
			dshanghoa.add(hanghoa);
		}

		workbook.close();
		inputStream.close();

		return dshanghoa;
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
