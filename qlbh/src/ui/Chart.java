/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.LoiNhuan;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Kira
 */
public class Chart { // the class extends the JFrame class

    public static JFreeChart createChart(ArrayList<LoiNhuan> list) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ LỢI NHUẬN",
                "THỜI GIAN", "LỢI NHUẬN",
                createDataset(list), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDataset(ArrayList<LoiNhuan> list) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < list.size(); i++) {
            dataset.addValue(list.get(i).getLoiNhuan(), "Lợi nhuận", list.get(i).getThoigian());
            System.out.println(list.get(i).getLoiNhuan() + "");
        }
        return dataset;
    }

//    public static void main(String[] args) {
//        ArrayList<LoiNhuan> list = LoiNhuan.get("Năm");
//        ChartPanel chartPanel = new ChartPanel(createChart(list));
//        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
//        JFrame frame = new JFrame();
//        frame.add(chartPanel);
//        frame.setTitle("Biểu đồ lợi nhuận");
//        frame.setSize(1280, 720);
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
//        frame.setVisible(true);
//    }
}
