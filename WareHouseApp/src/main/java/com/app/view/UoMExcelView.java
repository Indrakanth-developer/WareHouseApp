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

import com.app.model.UoM;

@Component
public class UoMExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<UoM> list=(List<UoM>) model.get("list");
		//Setting name and Download option
		response.addHeader("Content-Disposition", "attachment;filename=UoMExcel.xlsx");
		
		//Create workbook
		Sheet sheet=workbook.createSheet("UoMs");
		
		//add header
		addHeader(sheet);
		addBody(sheet,list);
		
	}


	private void addHeader(Sheet sheet) {

		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("UOM TYPE");
		row.createCell(2).setCellValue("UOM MODEL");
		row.createCell(3).setCellValue("DESCRIPTION");
		
	}

	private void addBody(Sheet sheet, List<UoM> list) {

		int rowNumber=1;
		for (UoM uoM : list) {
			Row row=sheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(uoM.getId());
			row.createCell(1).setCellValue(uoM.getUomType());
			row.createCell(2).setCellValue(uoM.getUomModel());
			row.createCell(3).setCellValue(uoM.getUomDescription());
		}
	}
}
