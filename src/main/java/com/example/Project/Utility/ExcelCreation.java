
package com.example.Project.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;

import ch.qos.logback.core.util.FileUtil;

public class ExcelCreation {

	@Value("${filename}")
	private String fileName;


	@Value("${filepath}")
	private String filePath;


	@Value("${Outfilename")
	private String OutFileName;

	public static Cell returnCell(Workbook workbook,int sheetNo,int rowNum,int cellNo) {
		if(workbook.getSheetAt(sheetNo).getRow(rowNum)==null) {
			workbook.getSheetAt(sheetNo).createRow(rowNum).createCell(cellNo);
			
		}
		return workbook.getSheetAt(sheetNo).getRow(rowNum).getCell(cellNo);

	}


	public  void createDataSheet() {
		File templatefile=new File(filePath+fileName);
		File newFile=new File(filePath+OutFileName);
		try {
			FileCopyUtils.copy(templatefile, newFile);
			FileInputStream FIS=new FileInputStream(newFile);
			Workbook workbook=new XSSFWorkbook(FIS);
			int SheetNO=0;
			int rowNUm=0;
			int cellNo=0;
			ExcelCreation.returnCell(workbook, SheetNO, rowNUm, cellNo).setCellValue("Manoj is villain");
			
			FileOutputStream out=new FileOutputStream(newFile);
			workbook.write(out);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
