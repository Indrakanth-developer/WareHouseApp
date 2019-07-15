package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//set pdfname
		response.addHeader("Content-Disposition", "attachment;filename=Shipments.pdf");
		@SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>)model.get("list");

		//lowagie paragraph
		Paragraph title=new Paragraph("ShipmentType Details");
		//Table t=new Table(6);
		PdfPTable t=new PdfPTable(6);
		t.addCell("ID");
		t.addCell("SHIPMENT MODE");
		t.addCell("SHIPMENT CODE");
		t.addCell("ENABLE SHIPMENT");
		t.addCell("SHIPMENT GRADE");
		t.addCell("DESCRIPTION");
		
		for (ShipmentType s: list) {
			t.addCell(s.getId().toString());
			t.addCell(s.getShipmentMode());
			t.addCell(s.getShipmentCode());
			t.addCell(s.getEnableShipment());
			t.addCell(s.getShipmentGrade());
			t.addCell(s.getDescription());
		}
		document.add(title);
		document.add( t);
		
	}

}
