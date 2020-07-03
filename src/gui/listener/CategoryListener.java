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
				JOptionPane.showMessageDialog(cp, "分类名不能为空");
				return;
			}
			new CategoryService().add(name);
		}
		
		if(b == cp.bEdit) {
			Category c = cp.getSelectedCategory();
			int id = c.id;
			String name = JOptionPane.showInputDialog("修改分类名称",c.name);
			if(0 == name.length()) {
				JOptionPane.showMessageDialog(cp, "分类名称不能为空");
				return;
			}
			new CategoryService().update(id, name);
		}
		
		if(b == cp.bDelete) {
			Category c = cp.getSelectedCategory();
			if(0 != c.recordNumber) {
				JOptionPane.showMessageDialog(cp, "该分类下有记录，无法删除");
				return;
			}
			if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(cp, "确认删除？"))
				return;
			int id = c.id;
			new CategoryService().delete(id);
		}
		cp.updateData();
	}
}
