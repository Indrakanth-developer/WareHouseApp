package com.app.charts;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentTypeModeCharts {

	//PIE CHART GENERATOR METHOD
	public void generateShipmentTypePieCharts(String path,List<Object[]>list) {
		
		//1. Convert into Data Set format
		DefaultPieDataset dataset=new DefaultPieDataset();
		for (Object[] objects : list) {
			//key,value format=> key=ShipmentMode, value=count of ShipmentModes
			dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
		
			//2. Create JFreeChart Obj
			JFreeChart jFreeChart= ChartFactory.createPieChart3D("Shipment Type Modes", dataset, true, true, false);
			
			//3. Save jfreechart obj as jpeg image
			try {
				ChartUtilities.saveChartAsJPEG(new File(path+"/resources/images/ShipmentTypeModesPieCharts.jpg"), jFreeChart, 400, 400);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	//BAR CHART GENERATOR METHOD
			public void generateShipmentTypeBarChart(String path,List<Object[]> list) {
				
				//1. Convert List data to Dataset
				DefaultCategoryDataset dataset=new DefaultCategoryDataset();
				for (Object[] objects : list) {
					dataset.setValue(new Double(objects[1].toString()), objects[0].toString(), "Shipment Mode Details");
				}
				//2. Generate JFree Chart object

				PlotOrientation orientation =PlotOrientation.VERTICAL;
			JFreeChart jFreeChart=ChartFactory.createBarChart3D("Shipment Mode", "Shipment Modes", "Count", dataset, orientation, true, true, false);
				//3. Save as jpg
				try {
					ChartUtilities.saveChartAsJPEG(new File(path+"/resources/images/ShipmentTypeModesBarCharts.jpg"), jFreeChart, 400, 400);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			}
}
