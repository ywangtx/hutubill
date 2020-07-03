package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import entity.Record;

public class ChartUtil {
	public static int max(double[] sampleValues) {
		int max = 0;
		for(double value:sampleValues) {
			if(value > max)
				max = (int)value; 
		}
		return max;
	}
	
	public static String[] sampleLables(List<Record> rs) {
		String[] sampleLables = new String[rs.size()];
		for(int i = 0; i < sampleLables.length; i++) {
			if(0 == i%5) {
				sampleLables[i] = String.valueOf(i + 1);
			}
		}
		return sampleLables;
	}
	
	public static double[] sampleValues(List<Record> rs) {
		double[] sampleValues = new double[rs.size()];
		for(int i = 0; i < sampleValues.length; i++) {
			sampleValues[i] = rs.get(i).spend;
			
		}
		return sampleValues;
	}
	
	public static Image getImage(List<Record> rs, int width, int height) {
		double[] sampleValues = sampleValues(rs);
		String[] sampleLables = sampleLables(rs);
		int max = max(sampleValues);
		Color[] sampleColors = new Color[] {ColorUtil.blueColor};
		BarChart chart = new BarChart();
		
		// ������������
		chart.setSampleCount(sampleValues.length);
		// ������������
		chart.setSampleValues(0, sampleValues);
		// ��������
		chart.setSampleLabels(sampleLables);
		// ����������ɫ
		chart.setSampleColors(sampleColors);
		// ����ȡֵ��Χ
		chart.setRange(0, max*1.2);
		// ��ʾ��������
		chart.setValueLinesOn(true);
		// ��ʾ����
		chart.setSampleLabelsOn(true);
		// ��������ʾ���·�
		chart.setSampleLabelStyle(Chart.BELOW);
		// ����ֵ������
		chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
		// ��ʾͼ��˵��
		chart.setLegendOn(true);
		// ��ͼ��˵���������
		chart.setLegendPosition(Chart.LEFT);
		// ͼ��˵���е�����
		chart.setLegendLabels(new String[] {"�����ѱ���"});
		// ͼ��˵��������
		chart.setFont("legendFont", new Font("Dialog",Font.BOLD, 13));
		// �·����ֵ�����
		chart.setFont("sampleLableFont", new Font("Dialog",Font.BOLD, 13));
		// ͼ���м䱳����ɫ
		chart.setChartBackground(Color.WHITE);
		// ͼ�����屳����ɫ
		chart.setBackground(ColorUtil.backgroundColor);
		// ��ͼ��ת��ΪImage����
		Image im = chart.getImage(width, height);
		return im;

		
	}
	

	
	
	
}