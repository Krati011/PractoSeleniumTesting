package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


////---------------------------Excel reader for scenario Outline on test case 3rd---------------------------------------------


public class ExcelReader {

    public String getRowData(String fileName, int sheetIndex, int rowIndex) throws IOException {
        FileInputStream fis = new FileInputStream("src\\test\\resource\\excelData\\"+fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        XSSFRow row = sheet.getRow(rowIndex);

        XSSFCell column =row.getCell(0); 
        
        String data = new String(); 
        
        double number=column.getNumericCellValue();
        
        data = String.valueOf((int)number) ;

        return data;
    }

//        workbook.close();
//        fis.close();
     
//-------------------------Excel reader for scenario Datatable on test case 5----------------------------------------------

        
        public String[] AppointmentDetailsReader(String filename) throws IOException
    	{
    		String filepath="src\\test\\resource\\ExcelData\\"+filename;
    		String[] details=new String[2];
    		FileInputStream fis=new FileInputStream(filepath);
    		XSSFWorkbook work=new XSSFWorkbook(fis);
    		Sheet sheet=work.getSheetAt(1);
    		details[0]=sheet.getRow(1).getCell(0).getStringCellValue();
    		double Num = sheet.getRow(1).getCell(1).getNumericCellValue();  
    		details[1] = String.valueOf((int) Num);
    
     
    		return details;
    	}
    
}
