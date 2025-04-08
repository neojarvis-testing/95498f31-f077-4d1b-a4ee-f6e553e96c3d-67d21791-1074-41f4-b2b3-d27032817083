package utils;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExcelFileReader {
    public static String readData(String filepath,String sheetname,int row,int cell,ExtentTest test){ 
        String excelvalue="";
        try{ 
            FileInputStream file1 = new FileInputStream(filepath);
            XSSFWorkbook work = new XSSFWorkbook(file1);
            XSSFSheet sheet = work.getSheet(sheetname);
            XSSFRow row1 = sheet.getRow(row);
            XSSFCell cell1 = row1.getCell(cell);
            
            excelvalue = cell1.toString();
            work.close();
            
        }
        catch(Exception e){
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
        }
        return excelvalue;
        
    }
}

