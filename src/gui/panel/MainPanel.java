package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

public class MainPanel extends JPanel{
	//设置水晶皮肤
	static{
		   GUIUtil.useLNF();
		}
	//单例模式创建对象
	public static MainPanel instance = new MainPanel();
	//各种按钮public
	public JToolBar tb = new JToolBar();
	public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();
	//工作面板
    public CenterPanel workingPanel;
	//设置图标与文字
    private MainPanel() {
    	GUIUtil.setImageIcon(bSpend, "home.png", "消费一览");
        GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
        GUIUtil.setImageIcon(bCategory, "category2.png", "消费分类");
        GUIUtil.setImageIcon(bReport, "report.png", "月消费报表");
        GUIUtil.setImageIcon(bConfig, "config.png", "设置");
        GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
        GUIUtil.setImageIcon(bRecover, "restore.png", "恢复");
        
        tb.add(bSpend);
        tb.addSeparator();//按钮间添加间隙
        tb.add(bRecord);
        tb.addSeparator();
        tb.add(bCategory);
        tb.addSeparator();
        tb.add(bReport);
        tb.addSeparator();
        tb.add(bConfig);
        tb.addSeparator();
        tb.add(bBackup);
        tb.addSeparator();
        tb.add(bRecover);
        tb.setFloatable(false);//是否可移出来
        
        workingPanel = new CenterPanel(0.85,true);
        
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);
        
        //添加监听器
        addListener();
    }
    public void addListener() {
    	ToolBarListener lis = new ToolBarListener();
    	
    	bSpend.addActionListener(lis);
    	bRecord.addActionListener(lis);
    	bCategory.addActionListener(lis);
    	bReport.addActionListener(lis);
    	bConfig.addActionListener(lis);
    	bBackup.addActionListener(lis);
    	bRecover.addActionListener(lis);
	}

	//显示面板
    public static void main(String[] args) {
		GUIUtil.showPanel(MainPanel.instance, 1.0);
	}
}
