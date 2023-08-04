package com.qa.util;

import com.qa.base.ApplicationBase;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Util extends ApplicationBase {
    Workbook book;
    Sheet sheet;
    public Util() throws IOException {
    }

    public static void moveTOElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();


    }

    public Object[][] getTestData(String sheetName){

        FileInputStream file = null;
        try{
           String filePath =  System.getProperty("user.dir")+"/src/main/java/com/qa/testdata/testData.xlsx";
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
             book =  WorkbookFactory.create(file);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
           e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
       int rowCount = sheet.getLastRowNum();
       int columnCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                data [i][j]=  sheet.getRow(i+1).getCell(j).toString();
            }
            
        }
    return data;
    }
}
