package utils;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExcelFileReader {
    public static String readData(String sheet,int row,int cell,ExtentTest test){ 
        String excelvalue="";
        try{ 
            FileInputStream file1 = new FileInputStream(Base.prop.getProperty("excel"));
            
            XSSFWorkbook work = new XSSFWorkbook(file1);
            XSSFSheet sheet1 = work.getSheet(sheet);
            XSSFRow row1 = sheet1.getRow(row);
            XSSFCell cell1 = row1.getCell(cell);
            
            excelvalue = cell1.toString();
            LoggerHandler.info("Value fetched from Excel");
            test.log(Status.INFO, "Value fetched from Excel");
            work.close();
            
        }
        catch(Exception e){
            LoggerHandler.error("Value fetched from Excel "+e.getMessage());
            test.log(Status.FAIL, "Value fetched from Excel "+e.getMessage());
        }
        return excelvalue;
        
    }
}


