package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {
    public static XSSFWorkbook xssfWorkbook;
    public static XSSFSheet xssfSheet;
    public static Object[][] getTestData(String filePath, String sheetName, int startCol, int totalCols) {
        String [][] table = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
            xssfSheet = xssfWorkbook.getSheet(sheetName);
            int startRows = 1;
            int ci = 0, cj = 0;
            int totalRows = xssfSheet.getLastRowNum();

            if (totalRows <= 1) {
                System.out.println("No data for test");
            } else if (totalRows == 2) {
                table = new String[1][totalCols];
                for (int j = startCol; j < totalCols; j++, cj++) {
                    XSSFCell xssfCell = xssfSheet.getRow(1).getCell(j);
                    try {
                        table[0][cj] = xssfCell.getStringCellValue();
                    } catch (Exception e) {
                        table[0][cj] = String.valueOf(xssfCell.getNumericCellValue());
                    }
                }
            } else {
                table = new String[totalRows][totalCols];

                for (int i = startRows; i <= totalRows; i++, ci++) {
                    cj = 0;
                    for (int j = startCol; j < totalCols; j++, cj++) {
                        XSSFCell xssfCell = xssfSheet.getRow(i).getCell(j);

                        table[ci][cj] = xssfCell.getStringCellValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }
}
