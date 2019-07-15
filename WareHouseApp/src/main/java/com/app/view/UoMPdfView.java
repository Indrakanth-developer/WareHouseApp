package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.UoM;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class UoMPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//set pdf name and downloadable type in response
		response.addHeader("Content-Disposition", "attachment;filename=UoMsPdf.pdf");
		
		//Type Cast Data
		@SuppressWarnings("unchecked")
		List<UoM> list=(List<UoM>) model.get("list");
	
		PdfPTable table=new PdfPTable(4);
		
		Paragraph title=new Paragraph("UoM Details");
		//Add Header
		addHeader(table);
	
		//Add Body
		addBody(table,list);
	
		//add data finally to pdf document
		document.add(title);
		document.add(table);
	}

	private void addBody(PdfPTable table, List<UoM> list) {

		for (UoM uoM : list) {
			table.addCell(uoM.getId().toString());
			table.addCell(uoM.getUomType());
			table.addCell(uoM.getUomModel());
			table.addCell(uoM.getUomDescription());
			
		}
	}

	private void addHeader(PdfPTable table) {
	
		table.addCell("ID");
		table.addCell("UOM TYPE");
		table.addCell("UOM MODEL");
		table.addCell("DESCRIPTION");
	
	}

}
