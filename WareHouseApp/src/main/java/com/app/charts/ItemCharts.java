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
public class ItemCharts {

	//Pie chart Generator
	public void generateItemPieChart(String path,List<Object[]>list) {
		
		//Dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for (Object[] objects : list) {
			dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
		}
		//JFreeChart
		JFreeChart jFreeChart=ChartFactory.createPieChart3D("Item Currencies", dataset, true, true, false);
		//Save as jpg
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/resources/images/ItemPieChart.jpg"), jFreeChart, 500, 500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//Bar Chart Generator
	public void generateItemBarChart(String path,List<Object[]>list) {
		
		//dataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for (Object[] objects : list) {
			dataset.addValue(new Double(objects[1].toString()), objects[0].toString(), "Base Currencies");
		}
		
		//jfreechart
		JFreeChart jFreeChart=ChartFactory.createBarChart3D("Items Base Currency", "Currencies", "Counts", dataset, PlotOrientation.VERTICAL, true, true, false);
		
		//save as jpg
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/resources/images/ItemBarChart.jpg"), jFreeChart, 500, 500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
