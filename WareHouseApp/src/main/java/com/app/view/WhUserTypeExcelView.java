package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;


public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//set file name and downloadable type
		response.addHeader("Content-Type", "attachment;filename=WhUserTypeExcel.xlsx");
		
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		
		//generate sheet
		Sheet sheet=workbook.createSheet("WhUserTypes");
		//head
		addHeader(sheet);
		// Body
		addBody(list,sheet);
		
	}

	private void addHeader(Sheet sheet) {

		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("UNIQUE ID");
		row.createCell(1).setCellValue("USER TYPE");
		row.createCell(2).setCellValue("USER CODE");
		row.createCell(3).setCellValue("USER FOR");
		row.createCell(4).setCellValue("USER EMAIL");
		row.createCell(5).setCellValue("USER CONTACT");
		row.createCell(6).setCellValue("USER ID TYPE");
		row.createCell(7).setCellValue("ID NUMBER");
		
	}

	private void addBody(List<WhUserType> list, Sheet sheet) {

		int rowNumber=1;
		for (WhUserType whUserType : list) {
			Row row=sheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(whUserType.getId());
			row.createCell(1).setCellValue(whUserType.getUserType());
			row.createCell(2).setCellValue(whUserType.getUserCode());
			row.createCell(3).setCellValue(whUserType.getUserFor());
			row.createCell(4).setCellValue(whUserType.getUserEmail());
			row.createCell(5).setCellValue(whUserType.getUserContact());
			row.createCell(6).setCellValue(whUserType.getUserIdType());
			row.createCell(7).setCellValue(whUserType.getIdNumber());
		}
	}

}
