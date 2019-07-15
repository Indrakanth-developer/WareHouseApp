package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class OrderMethodPdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//Adding title to Document
		Paragraph title=new Paragraph("ORDER METHOD AGGREGATE DETAILS");
				
		//1. Add file name and make it downloadable
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethods.pdf");
		//2. Add data to Table
		float a[]=new float[] {10.0f,30.0f,10.0f,10.0f,30.0f,10.0f};
		PdfPTable p=new PdfPTable(6);
		p.setWidths(a);
		//3. Add header
		p.addCell("ID");
		p.addCell("ORDER MODE");
		p.addCell("ORDER CODE");
		p.addCell("EXECUTION TYPE");
		p.addCell("ORDER ACCEPT");
		p.addCell("DESCRIPTION");
		
		//4. Add Body
		for (OrderMethod orderMethod : (List<OrderMethod>)model.get("list")) {
			p.addCell(orderMethod.getId().toString());
			p.addCell(orderMethod.getOrderMode());
			p.addCell(orderMethod.getOrderCode());
			p.addCell(orderMethod.getExecutionType());
			String msg="";//empty string to store list
			for (String s : orderMethod.getOrderAccept()) {
				msg+=s+" \r\n";
			}
			p.addCell(msg);
			p.addCell(orderMethod.getDescription());
		}
		
		//5. Add to Document
		
		
		document.add(title);
		document.add(p);
	}

	
}
