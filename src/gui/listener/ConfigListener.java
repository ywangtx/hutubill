package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

public class ConfigListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		ConfigPanel cp = ConfigPanel.instance;
		if(!GUIUtil.checkNumber(cp.tfBudget, "����Ԥ��"))
			return;
		String mySqlPath = cp.tfMysqlPath.getText();
		if(0!= mySqlPath.length()) {
			File commandFile = new File(mySqlPath, "bin\\mysql.exe");
			if(!commandFile.exists()) {
				JOptionPane.showMessageDialog(cp, "MySql·������ȷ��");
				cp.tfMysqlPath.grabFocus();
				return;
			}
		}
		
		ConfigService cs = new ConfigService();
		cs.update(ConfigService.budget, cp.tfBudget.getText());
		cs.update(ConfigService.mySqlPath, mySqlPath);
		
		JOptionPane.showMessageDialog(cp, "�����޸ĳɹ���");
		
		
	}
}
