package service;

import java.util.Collections;
import java.util.List;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

public class CategoryService {
	CategoryDAO cd = new CategoryDAO();
	RecordDAO rd = new RecordDAO();
	
	public List<Category> list(){
		List<Category> cs = cd.list();
		for(Category c:cs) {
			List<Record> rs = rd.list(c.id);
			c.recordNumber = rs.size();
		}
		Collections.sort(cs, (c1,c2)->c2.recordNumber-c1.recordNumber);
		return cs;
	}
	
	public void add(String name) {
		Category c= new Category();
		c.setName(name);
		cd.add(c);
	}
	
	public void delete(int id) {
		cd.delete(id);
	}
	
	public void update(int id, String name) {
		Category c = new Category();
		c.setId(id);
		c.setName(name);
		cd.update(c);
		
	}
}
