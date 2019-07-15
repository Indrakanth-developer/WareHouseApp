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
public class WhUserTypeCharts {

	//Pie Chart
	public void generateWhUserTypePieChart(String path,List<Object[]> list) {
		
		//Dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for (Object[] objects : list) {
			dataset.setValue(objects[0].toString(), Double.parseDouble(objects[1].toString()));
		}
		//JFreeChart
		JFreeChart jFreeChart=ChartFactory.createPieChart3D("WhUser Types", dataset, true, true, false);
		
		//save as image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path + "/resources/images/WhUserTypePieChart.jpg"), jFreeChart, 400, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateWhUserTypeBarChart(String path,List<Object[]> list) {
		//dataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for (Object[] objects : list) {
			dataset.setValue(new Double(objects[1].toString()), objects[0].toString(), "User Type Counts");
		}
			//JFreeChart
			JFreeChart jFreeChart =ChartFactory.createBarChart3D("WhUser UserTypes", "User Types", "Counts", dataset, PlotOrientation.VERTICAL, true, true, false);
		
		//save as jpg
			try {
				ChartUtilities.saveChartAsJPEG(new File(path+"/resources/images/WhUserTypeBarChart.jpg"), jFreeChart, 400, 400);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
