package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
@Component
public class ItemPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//filename and downloadable
		response.addHeader("Content-Disposition", "attachment;filename=ItemPdf.pdf");
		
		//fetch data
		
		@SuppressWarnings("unchecked")
		List<Item> list=(List<Item>) model.get("list");
		

		//lowagie paragraph
		Paragraph title=new Paragraph("Item Summary");
		
		//table
		PdfPTable table=new PdfPTable(7);
		table.addCell("ID");
		table.addCell("ITEM CODE");
		table.addCell("ITEM WIDTH");
		table.addCell("ITEM LENGTH");
		table.addCell("ITEM HEIGHT");
		table.addCell("BASE COST");
		table.addCell("BASE CURRENCY");
		
		for (Item item : list) {
			table.addCell(item.getId().toString());
			table.addCell(item.getItemCode());
			table.addCell(item.getItemWidth());
			table.addCell(item.getItemLength());
			table.addCell(item.getItemHeight());
			table.addCell(item.getBaseCost().toString());
			table.addCell(item.getBaseCurrency());
		}
		
		//finally add data to document
		document.add(title);
		document.add(table);
		

	}

}
