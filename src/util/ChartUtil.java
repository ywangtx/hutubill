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
		
		// 设置样本个数
		chart.setSampleCount(sampleValues.length);
		// 设置样本数据
		chart.setSampleValues(0, sampleValues);
		// 设置文字
		chart.setSampleLabels(sampleLables);
		// 设置样本颜色
		chart.setSampleColors(sampleColors);
		// 设置取值范围
		chart.setRange(0, max*1.2);
		// 显示背景横线
		chart.setValueLinesOn(true);
		// 显示文字
		chart.setSampleLabelsOn(true);
		// 把文字显示在下方
		chart.setSampleLabelStyle(Chart.BELOW);
		// 样本值的字体
		chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
		// 显示图例说明
		chart.setLegendOn(true);
		// 把图例说明放在左侧
		chart.setLegendPosition(Chart.LEFT);
		// 图例说明中的文字
		chart.setLegendLabels(new String[] {"月消费报表"});
		// 图例说明的字体
		chart.setFont("legendFont", new Font("Dialog",Font.BOLD, 13));
		// 下方文字的字体
		chart.setFont("sampleLableFont", new Font("Dialog",Font.BOLD, 13));
		// 图表中间背景颜色
		chart.setChartBackground(Color.WHITE);
		// 图表整体背景颜色
		chart.setBackground(ColorUtil.backgroundColor);
		// 把图表转换为Image类型
		Image im = chart.getImage(width, height);
		return im;

		
	}
	

	
	
	
}
