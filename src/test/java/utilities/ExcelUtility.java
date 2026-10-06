package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    Workbook workbook;

    public ExcelUtility(String filePath) throws IOException {

        FileInputStream file = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(file);
    }

    public int getRowCount(String sheetName) {

        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getPhysicalNumberOfRows();
    }

    public String getCellData(String sheetName,int rowNumber,int columnNumber) {

        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(columnNumber);
        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(cell);
    }
}