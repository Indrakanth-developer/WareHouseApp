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
public class UoMCharts {

	//pie chart generator
	public void generateUoMPieChart(String path,List<Object[]>list) {

		//dataset creation
		DefaultPieDataset dataset=new DefaultPieDataset();
		for (Object[] objects : list) {
			dataset.setValue(objects[0].toString(), Double.parseDouble(objects[1].toString()));
		}
		//JFreeChart
		JFreeChart jFreeChart=ChartFactory.createPieChart3D("UoM Types", dataset, true, true, false);
		//Save as jpg
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/resources/images/UoMTypePieChart.jpg"), jFreeChart, 400, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//generate Bar Chart
	public void generateUoMBarChart(String path,List<Object[]> list) {
		
		//Dataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for (Object[] objects : list) {
			dataset.setValue(Double.parseDouble(objects[1].toString()), objects[0].toString(), "UoM Types Count");
		}
		//JFreeChart
		JFreeChart jFreeChart=ChartFactory.createBarChart3D("UoM Types Bar Representation", "UoM Types", "Counts", dataset, PlotOrientation.VERTICAL, true, true, false);
		//save as jpg
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/resources/images/UoMTypeBarChart.jpg"), jFreeChart, 400, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
