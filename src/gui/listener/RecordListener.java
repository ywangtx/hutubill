package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.RecordService;
import util.GUIUtil;

public class RecordListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		RecordPanel rp = RecordPanel.instance;
		if(0 == rp.cbModel.cs.size()) {
			JOptionPane.showMessageDialog(rp,"暂无消费记录");
			MainPanel.instance.workingPanel.show(CategoryPanel.instance);
			return;
		}
		
		if(!GUIUtil.checkZero(rp.tfSpend, "花费金额"))
			return;
		int spend = Integer.parseInt(rp.tfSpend.getText());
		Category c = rp.getSelectedCategory();
		String comment = rp.tfComment.getText();
		Date date = rp.datepiker.getDate();
		new RecordService().add(spend, c, comment, date);
		JOptionPane.showMessageDialog(rp, "添加成功");
		
		MainPanel.instance.workingPanel.show(SpendPanel.instance);
	}
}
