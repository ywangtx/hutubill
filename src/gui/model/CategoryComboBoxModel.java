package gui.model;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entity.Category;
import service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel<Category>{
	//������Ϣ
	public List<Category> cs = new CategoryService().list();
	//��ѡ�е���Ϣ
	public Category c;
	//���췽���г�ʼ��ģ������
	public CategoryComboBoxModel() {
		if(!cs.isEmpty())
		c = cs.get(0);
	}
	
	//��ȡ�������С
	public int getSize() {
		return cs.size();
	}
	
	//��ȡָ��λ������
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
	
	//ѡ��ĳ��������
	public void setSelectedItem(Object anItem) {
		c = (Category)anItem;
	}
	
	//��ȡ��ѡ�е�����
	public Object getSelectedItem() {
		if(!cs.isEmpty())
			return c;
		else
			return null;
	}

}
