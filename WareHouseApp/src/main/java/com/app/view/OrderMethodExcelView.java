package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

@Component
public class OrderMethodExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//1. Set file name
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethods.xlsx");
		
		//2. Create workbook
		
		Sheet sheet=workbook.createSheet("OrderMethods");
		
		//3. Add Header
		addHeader(sheet);
		//Read data from model
		
		//4. Add Body
		addBody(sheet,(List<OrderMethod>)model.get("list"));
	}


	private void addHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("ORDER MODE");
		row.createCell(2).setCellValue("ORDER CODE");
		row.createCell(3).setCellValue("EXECUTION TYPE");
		row.createCell(4).setCellValue("ORDER ACCEPT");
		row.createCell(5).setCellValue("DESCRIPTION");
		
	}
	

	private void addBody(Sheet sheet, List<OrderMethod> list) {
		int rowNumber=1;
		for (OrderMethod orderMethod : list) {
			Row row =sheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(orderMethod.getId());
			row.createCell(1).setCellValue(orderMethod.getOrderMode());
			row.createCell(2).setCellValue(orderMethod.getOrderCode());
			row.createCell(3).setCellValue(orderMethod.getExecutionType());
			
			//list to be displayed in single column
			String msg="";//empty string to store all values
			for (String s : orderMethod.getOrderAccept()) {
				msg+=s+" ";
			}
			
			//display the List as a String message
			row.createCell(4).setCellValue(msg);
			row.createCell(5).setCellValue(orderMethod.getDescription());
		}
	}

}
