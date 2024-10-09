package com.automation.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelUtils {
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    public ExcelUtils(String fileName, String sheetName) {
        try {
            workbook = new XSSFWorkbook("src/test/resources/data/" + fileName);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTotalRowNum(){
        return sheet.getLastRowNum();
    }

    public int getTotalColumnNum(){
        return sheet.getRow(0).getLastCellNum();
    }
    public List<List<String>> getData(){
        List<List<String>> tableData=new ArrayList<>();

        for (int i=1;i<=getTotalRowNum();i++){
            XSSFRow row=sheet.getRow(i);
            List<String> rowData=new ArrayList<>();
            for (int j=0;j<row.getLastCellNum();j++){
                rowData.add(row.getCell(j).getStringCellValue());
            }
            tableData.add(rowData);
        }
        return tableData;
    }
    public static void main(String[] args) {
//        XSSFWorkbook workbook = new XSSFWorkbook("src/test/resources/data/Credentials.xlsx");
//        XSSFSheet sheet = workbook.getSheet("ValidData");
//
//        for (int i = 0; i < sheet.getLastRowNum(); i++) {
//            XSSFRow row = sheet.getRow(i);
//            for (int j = 0; j < row.getLastCellNum(); j++) {
//                System.out.print(row.getCell(j).getStringCellValue() + " ");
//            }
//            System.out.println();
//        }

        List<String> packet1= Arrays.asList("b1","b2","b3");
        List<String> packet2= Arrays.asList("b1","b2","b3");
        List<String> packet3= Arrays.asList("b1","b2","b3");

        List<List<String>> box=new ArrayList<>();
        box.add(packet1);
        box.add(packet2);
        box.add(packet3);

        for (List<String> packet:box){
            for (String b:packet){
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }
}