package gui.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.page.SpendPage;
import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class SpendPanel extends WorkingPanel{
	//设置水晶皮肤
	static {
		GUIUtil.useLNF();
	}
	
	public static SpendPanel instance = new SpendPanel();
	
	JLabel monthSpend = new JLabel("本月消费");
	JLabel todaySpend = new JLabel("今日消费");
	JLabel avgSpend = new JLabel("日均消费");
	JLabel monthLeft = new JLabel("本月剩余");
	JLabel dayAvailable= new JLabel("日均可用");
	JLabel dayLeft = new JLabel("距离月末");

	JLabel vmonthSpend = new JLabel("¥ 2300");
	JLabel vtodaySpend = new JLabel("¥ 25");
	JLabel vavgSpend = new JLabel("¥ 120");
	JLabel vmonthLeft = new JLabel("¥ 2000");
	JLabel vdayAvailable = new JLabel("¥ 300");
	JLabel vdayLeft = new JLabel("20天");
	
	CircleProgressBar bar;
	
	public SpendPanel() {
		//设置布局
		this.setLayout(new BorderLayout());
		//创建环形进度条及设置颜色
		bar = new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.blueColor);
		
		//设置标签颜色
		GUIUtil.setColor(ColorUtil.grayColor,monthSpend,todaySpend,avgSpend,monthLeft,
				dayAvailable,dayLeft,vavgSpend,vmonthLeft,vdayAvailable,vdayLeft);
		GUIUtil.setColor(ColorUtil.blueColor,vmonthSpend,vtodaySpend);
		
		//设置蓝字字体
		vmonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vtodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        
        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
        
		
	}

	private JPanel center() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(west(), BorderLayout.WEST);
		p.add(cencenter(), BorderLayout.CENTER);
		return p;
	}

	private Component cencenter() {
		return bar;
		
	}

	private Component west() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,1));
		p.add(monthSpend);
		p.add(vmonthSpend);
		p.add(todaySpend);
		p.add(vtodaySpend);
		return p;
	}

	private JPanel south() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2,4));
		p.add(avgSpend);
		p.add(monthLeft);
		p.add(dayAvailable);
		p.add(dayLeft);
		p.add(vavgSpend);
		p.add(vmonthLeft);
		p.add(vdayAvailable);
		p.add(vdayLeft);
		return p;
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(SpendPanel.instance,1.0);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData() {
		SpendPage spend = new SpendService().getSpendPage();
        vmonthSpend.setText(spend.monthSpend);
        vtodaySpend.setText(spend.todaySpend);
        vavgSpend.setText(spend.avgSpend);
        vdayAvailable.setText(spend.dayAvailable);
        vdayLeft.setText(spend.dayLeft);
        vmonthLeft.setText(spend.monthLeft);
 
        bar.setProgress(spend.usagePercentage);
        if (spend.isOver) {
        	vmonthLeft.setForeground(ColorUtil.warningColor);
            vmonthSpend.setForeground(ColorUtil.warningColor);
            vtodaySpend.setForeground(ColorUtil.warningColor);
 
        } else {
        	vmonthLeft.setForeground(ColorUtil.grayColor);
            vmonthSpend.setForeground(ColorUtil.blueColor);
            vtodaySpend.setForeground(ColorUtil.blueColor);
        }
        bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
        addListener();
	}
}
