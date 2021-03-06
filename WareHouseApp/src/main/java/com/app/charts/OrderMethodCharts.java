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
public class OrderMethodCharts {

	///generate pie chart
	public void generatePieChart(String path,List<Object[]>list) {
		
		//Dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for (Object[] objects : list) {
			dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
		}
		
		//Construct JFreeChart obj
		JFreeChart jFreeChart =ChartFactory.createPieChart3D("Order Methods", dataset, true, true, false);
		
		//Save as jpg
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/resources/images/OrderMethodsPieChart.jpg"), jFreeChart, 400, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//generate Bar chart
	public void generateBarChart(String path,List<Object[]>list) {
		
		//create Dataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for (Object[] objects : list) {
			dataset.setValue(new Double(objects[1].toString()), objects[0].toString(), "Order Method Modes");
		}
		//JFreeChart object generation
		JFreeChart  jFreeChart=ChartFactory.createBarChart3D("Order Method Modes", "Modes", "Counts", dataset, PlotOrientation.VERTICAL, true, true, false);
		
		//Save as jpg
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/resources/images/OrderMethodModesBarChart.jpg"), jFreeChart, 400, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
