package Exceloperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RedingExcel {

	public static void main(String[] args) throws IOException
	{
		String excelFilePath=".\\datafile\\POPULATION.xlsx";
		
		FileInputStream input = new FileInputStream(excelFilePath);
		
		XSSFWorkbook workbook= new XSSFWorkbook(input);
		
		// XSSFSheet sheet = workbook.getSheet("sheet1");
		  XSSFSheet sheet = workbook.getSheetAt(0);
		  
		  //using forloop
		  
		/* int rows = sheet.getLastRowNum();
		  int  col = sheet.getRow(1).getLastCellNum();
		  
		 for(int r=0;r<=rows;r++)
		  {
			 XSSFRow row = sheet.getRow(r);
			 
			 for(int c=0;c<col;c++)
		{
			XSSFCell cell = row.getCell(c);
			switch(cell.getCellType())
			{
			case STRING:System.out.print(cell.getStringCellValue());break;
			case NUMERIC:System.out.print(cell.getNumericCellValue());break;
			case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
			}
			System.out.print(" | ");
			}
			 System.out.println();
		}
		*/
		  ////////////////Iterator///////////////
		  
		   Iterator<Row> iterator = sheet.iterator();
		  
		  while(iterator.hasNext())
		  {
			  XSSFRow row = (XSSFRow) iterator.next();
			  
			  Iterator<Cell> celliterator = row.cellIterator();
			  
			  while(celliterator.hasNext())
			  {
				 XSSFCell cell = (XSSFCell) celliterator.next();
				 switch(cell.getCellType())
					{
					case STRING:System.out.print(cell.getStringCellValue());break;
					case NUMERIC:System.out.print(cell.getNumericCellValue());break;
					case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
					}
					System.out.print(" | ");
					}
					 System.out.println();
			  }
		  }
		  
	}


 