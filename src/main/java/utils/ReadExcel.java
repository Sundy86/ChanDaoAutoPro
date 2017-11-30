package utils;

import java.io.FileInputStream;
import java.io.InputStream;

import common.GlobalSettings;
import common.MConstant;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {

    public static Object[][] rangeData(String sheetName)   {
        String array[][] = null;
        String filePath = GlobalSettings.dataFilePath ;
        InputStream  is = null;
        Workbook workbook = null;

        try {
            is = new FileInputStream(filePath);
            workbook = Workbook. getWorkbook(is);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int col=0;
        int row=0;
        Sheet sheet=workbook.getSheet(sheetName);
        //有表头时，行数要减1
        array = new String[sheet.getRows()-1][sheet.getColumns()];
        Cell cell = null;
        //读取行，有表头时，行数要从第2行开始
        for( int j=1;j<sheet.getRows();j++){
            col = 0;
            //读取列
            for( int k=0;k<sheet.getColumns();k++){
                //getCell是先读列，再读行
                cell = sheet.getCell(k,j);
                //数组是先读行，再读列
                array[row][col] = cell.getContents();
                col++;
            }
            row++;
        }

        return array;
    }

}
