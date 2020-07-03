package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

public class CategoryListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		CategoryPanel cp = CategoryPanel.instance;
		JButton b = (JButton)e.getSource();
		
		if(b == cp.bAdd) {
			String name = JOptionPane.showInputDialog(null);
			if(0 == name.length()) {
				JOptionPane.showMessageDialog(cp, "����������Ϊ��");
				return;
			}
			new CategoryService().add(name);
		}
		
		if(b == cp.bEdit) {
			Category c = cp.getSelectedCategory();
			int id = c.id;
			String name = JOptionPane.showInputDialog("�޸ķ�������",c.name);
			if(0 == name.length()) {
				JOptionPane.showMessageDialog(cp, "�������Ʋ���Ϊ��");
				return;
			}
			new CategoryService().update(id, name);
		}
		
		if(b == cp.bDelete) {
			Category c = cp.getSelectedCategory();
			if(0 != c.recordNumber) {
				JOptionPane.showMessageDialog(cp, "�÷������м�¼���޷�ɾ��");
				return;
			}
			if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(cp, "ȷ��ɾ����"))
				return;
			int id = c.id;
			new CategoryService().delete(id);
		}
		cp.updateData();
	}
}
