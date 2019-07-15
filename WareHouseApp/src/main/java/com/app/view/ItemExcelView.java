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

import com.app.model.Item;
@Component
public class ItemExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//add filename and make it downloadable
		response.addHeader("Content-Disposition", "attachment;filename=ItemExcel.xlsx");
		
		//fetch data
		@SuppressWarnings("unchecked")
		List<Item> list=(List<Item>) model.get("list");
		
		//create sheet
		Sheet sheet=workbook.createSheet("Items All");
		
		//Head
		addHead(sheet);
		//Body
		addBody(sheet,list);
		
	}

	private void addHead(Sheet sheet) {

		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("ITEM CODE");
		row.createCell(2).setCellValue("ITEM WIDTH");
		row.createCell(3).setCellValue("ITEM LENGTH");
		row.createCell(4).setCellValue("ITEM HEIGHT");
		row.createCell(5).setCellValue("ITEM BASE COST");
		row.createCell(6).setCellValue("BASE CURRENCY");
		}

	private void addBody(Sheet sheet, List<Item> list) {

		int rowNumber=1;
		for (Item item : list) {
			Row row=sheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(item.getId());
			row.createCell(1).setCellValue(item.getItemCode());
			row.createCell(2).setCellValue(item.getItemWidth());
			row.createCell(3).setCellValue(item.getItemLength());
			row.createCell(4).setCellValue(item.getItemHeight());
			row.createCell(5).setCellValue(item.getBaseCost());
			row.createCell(6).setCellValue(item.getBaseCurrency());
		}
	}

}
