package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.listener.ConfigListener;
import service.ConfigService;
import util.ColorUtil;
import util.GUIUtil;

public class ConfigPanel extends WorkingPanel{
	static {
        GUIUtil.useLNF();
    }
 
    public static ConfigPanel instance = new ConfigPanel();
    
    //Ԥ��
    JLabel lBudget = new JLabel("����Ԥ��(��)");
    public JTextField tfBudget = new JTextField("0");
 //MySQL
    JLabel lMysql = new JLabel("Mysql��װĿ¼");
    public JTextField tfMysqlPath = new JTextField("");
 
    JButton bSubmit = new JButton("����");
    
    public ConfigPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lBudget, lMysql);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
 
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;
        pInput.setLayout(new GridLayout(4, 1, gap, gap));
 
        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(lMysql);
        pInput.add(tfMysqlPath);
 
        pSubmit.add(bSubmit);
 
        this.setLayout(new BorderLayout());
        this.add(pInput, BorderLayout.NORTH);
        this.add(pSubmit, BorderLayout.CENTER);
 
        addListener();
    }
 
    public void addListener() {
    	ConfigListener cl = new ConfigListener();
    	bSubmit.addActionListener(cl);
	}
    
    public void updateData() {
    	String budget = new ConfigService().get(ConfigService.budget);
    	String mySqlPath = new ConfigService().get(ConfigService.mySqlPath);
    	tfBudget.setText(budget);
    	tfMysqlPath.setText(mySqlPath);
    	tfBudget.grabFocus();
    }

	public static void main(String[] args) {
        GUIUtil.showPanel(ConfigPanel.instance);
    }




}
