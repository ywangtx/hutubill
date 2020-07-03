package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import entity.Category;
import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class RecordPanel extends JPanel{
	static {
		GUIUtil.useLNF();
	}
	
	public static RecordPanel instance = new RecordPanel();
	
	JLabel lSpend = new JLabel("花费（¥）");
	JLabel lCatefory = new JLabel("分类");
	JLabel lComment = new JLabel("备注");
	JLabel lDate = new JLabel("日期");
	
	//输入框
	public JTextField tfSpend = new JTextField("0");
	
	//选择框
	public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
	public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);	

	//输入框
	public JTextField tfComment = new JTextField();
	
	//时间选择
	public JXDatePicker datepiker = new JXDatePicker(new Date());
	
	//记一笔按钮
	JButton bSubmit = new JButton("记一笔");
	
	public RecordPanel(){
		GUIUtil.setColor(ColorUtil.grayColor, lSpend,lCatefory,lComment,lDate);
		GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
		JPanel pInput = new JPanel(); //上方输入面板
		JPanel pSubmit = new JPanel();//下方提交面板
		int gap = 60;
		pInput.setLayout(new GridLayout(4,2,gap,gap));
		
		pInput.add(lSpend);
		pInput.add(tfSpend);
		pInput.add(lCatefory);
		pInput.add(cbCategory);
		pInput.add(lComment);
		pInput.add(tfComment);
		pInput.add(lDate);
		pInput.add(datepiker);
		
		pSubmit.add(bSubmit);
		
		this.setLayout(new BorderLayout());
		this.add(pInput,BorderLayout.CENTER);
		this.add(pSubmit,BorderLayout.SOUTH);
		
		addListener();
		
		
	}
	
	public void addListener() {
		RecordListener listener = new RecordListener();
		bSubmit.addActionListener(listener);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(instance,2.0);
	}
	
	public Category getSelectedCategory() {
		return (Category) cbCategory.getSelectedItem();
	}
	
	public void updateDate() {
		cbModel.cs = new CategoryService().list();
		cbCategory.updateUI();
		resetInput();
		tfSpend.grabFocus();
	}

	public void resetInput() {
		tfSpend.setText("0");
		tfComment.setText("");
		if(0!=cbModel.cs.size())
			cbCategory.setSelectedIndex(0);
		datepiker.setDate(new Date(0));
	}
}
