package gui.model;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entity.Category;
import service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel<Category>{
	//分类信息
	public List<Category> cs = new CategoryService().list();
	//被选中的信息
	public Category c;
	//构造方法中初始化模拟数据
	public CategoryComboBoxModel() {
		if(!cs.isEmpty())
		c = cs.get(0);
	}
	
	//获取下拉框大小
	public int getSize() {
		return cs.size();
	}
	
	//获取指定位置数据
	public Category getElementAt(int index) {
		return cs.get(index);
	}
	
	@Override
    public void addListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub
         
    }
	 
    @Override
    public void removeListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub
         
    }
	
	//选中某个下拉框
	public void setSelectedItem(Object anItem) {
		c = (Category)anItem;
	}
	
	//获取被选中的数据
	public Object getSelectedItem() {
		if(!cs.isEmpty())
			return c;
		else
			return null;
	}

}
