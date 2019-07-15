package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

@Component
public class ShipmentTypeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		
		//set name of excel
		response.addHeader("Content-Disposition", "attachment;filename=Shipments.xlsx");
	
		//styling
		
		 // create font
       Font font=workbook.createFont();
       font.setFontHeightInPoints((short)10);
       font.setFontName("Arial");
       font.setColor(IndexedColors.GREY_50_PERCENT.getIndex());
       font.setBold(true);
       font.setItalic(true);
                                   
        // Create cell style 
       CellStyle style=workbook.createCellStyle();;
       style.setAlignment(HorizontalAlignment.CENTER);
       // Setting font to style
       style.setFont(font);

		//create a sheet
		 Sheet sheet=workbook.createSheet("ShipmentType");
		 sheet.setDisplayGridlines(true);
		 sheet.setHorizontallyCenter(true);
		 sheet.setVerticallyCenter(true);
		 sheet.setHorizontallyCenter(true);
		 
		
	        

		 
		 //fetch details
		 @SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");

		 
		 //Set header
		 setHead(sheet);
		 //Set Body
		 setBody(sheet, list);
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ENABLE SHIPMENT");
		row.createCell(4).setCellValue("SHIPMENT GRADE");
		row.createCell(5).setCellValue("DESCRIPTION");
		return ;
	}
	private void setBody(Sheet sheet,List<ShipmentType> list) {
		//set row number from second line after header
		int rowNumber=1;
		for (ShipmentType shipmentType : list) {
			Row row=sheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(shipmentType.getId());		
			row.createCell(1).setCellValue(shipmentType.getShipmentMode());		
			row.createCell(2).setCellValue(shipmentType.getShipmentCode());		
			row.createCell(3).setCellValue(shipmentType.getEnableShipment());		
			row.createCell(4).setCellValue(shipmentType.getShipmentGrade());		
			row.createCell(5).setCellValue(shipmentType.getDescription());		
		
		}
	}
}
