package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//set filename and downloadable
		response.addHeader("Content-Disposition", "attachment;filename=WhUserTypesPdf.pdf");
		
		//fetch data
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		
		//lowagie paragraph
		Paragraph title=new Paragraph("WhUserTypes\r\n\r\n");
		
		//lowagie table
		
		PdfPTable table=new PdfPTable(8);
		//adding head
		table.addCell("UNIQUE ID");
		table.addCell("USER TYPE");
		table.addCell("USER CODE");
		table.addCell("USER FOR");
		table.addCell("USER EMAIL");
		table.addCell("USER CONTACT");
		table.addCell("USER ID TYPE");
		table.addCell("USER ID NUMBER");
		
		//adding body
		for (WhUserType whUserType : list) {
			table.addCell(whUserType.getId().toString());
			table.addCell(whUserType.getUserType());
			table.addCell(whUserType.getUserCode());
			table.addCell(whUserType.getUserFor());
			table.addCell(whUserType.getUserEmail());
			table.addCell(whUserType.getUserContact());
			table.addCell(whUserType.getUserIdType());
			table.addCell(whUserType.getIdNumber());
		}
		
		//finally add contents to pdf
		document.add(title);
		document.add(table);
		
	}

}
