package com.bat.BscicAutomation.Utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator; 
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bat.BscicAutomation.DTO.LoginDTO;

public class ExcellUtils {

	private static FileInputStream inputstream = null;

	private static Workbook workbook = null;

	private static Sheet getSheet(int sheetno) throws IOException 
	{
		File f = new File("D:\\BAL_OCPL\\testing_file\\BscicAutomationTesting.xlsx");
		inputstream = new FileInputStream(f);
		workbook = new XSSFWorkbook(inputstream);
		Sheet sheet = workbook.getSheetAt(sheetno);
		return sheet;

	}
	
	
	public static List<LoginDTO> getLoginData () throws IOException 
	{
		
		List<LoginDTO> loginData= new ArrayList<LoginDTO>();
		DataFormatter formater=new DataFormatter();
		
		Iterator<Row> rowiterator=ExcellUtils.getSheet(0).iterator();
		while(rowiterator.hasNext())
		{
			Row nextrow=rowiterator.next();
			Iterator<Cell> celliterator = nextrow.cellIterator();
			LoginDTO login=new LoginDTO();
			byte cellCounter=0;
			while(celliterator.hasNext()) 
			{
				Cell cell = celliterator.next(); 
				switch(cellCounter) 
				{
				case 0:
					login.setUsername(formater.formatCellValue(cell));
					cellCounter++;
					break;
				case 1:
					login.setPassword(formater.formatCellValue(cell));
					cellCounter++;
					break;
				case 2:
					login.setUsername(formater.formatCellValue(cell));
					cellCounter++;
					break;
				case 3:
					login.setPassword(formater.formatCellValue(cell));
					break;
				}
			}
			loginData.add(login);
		}
		close();
		return loginData;
	}

	private static void close() throws IOException 
	{
		workbook.close();
		inputstream.close();
	}


}
	
	
