package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

public class MainPanel extends JPanel{
	//����ˮ��Ƥ��
	static{
		   GUIUtil.useLNF();
		}
	//����ģʽ��������
	public static MainPanel instance = new MainPanel();
	//���ְ�ťpublic
	public JToolBar tb = new JToolBar();
	public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();
	//�������
    public CenterPanel workingPanel;
	//����ͼ��������
    private MainPanel() {
    	GUIUtil.setImageIcon(bSpend, "home.png", "����һ��");
        GUIUtil.setImageIcon(bRecord, "record.png", "��һ��");
        GUIUtil.setImageIcon(bCategory, "category2.png", "���ѷ���");
        GUIUtil.setImageIcon(bReport, "report.png", "�����ѱ���");
        GUIUtil.setImageIcon(bConfig, "config.png", "����");
        GUIUtil.setImageIcon(bBackup, "backup.png", "����");
        GUIUtil.setImageIcon(bRecover, "restore.png", "�ָ�");
        
        tb.add(bSpend);
        tb.addSeparator();//��ť����Ӽ�϶
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
        tb.setFloatable(false);//�Ƿ���Ƴ���
        
        workingPanel = new CenterPanel(0.85,true);
        
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);
        
        //��Ӽ�����
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

	//��ʾ���
    public static void main(String[] args) {
		GUIUtil.showPanel(MainPanel.instance, 1.0);
	}
}
