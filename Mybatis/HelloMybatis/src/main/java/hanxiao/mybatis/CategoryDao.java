package hanxiao.mybatis;

import java.util.List;

public interface CategoryDao {
	
	public List<Category> listCategory();
	
	public Category getCategory(int id);
	
	public void addCategory(String name);
	
	public void addCategory(Category category);
	
	public void deleteCategory(int id);
	
	public void deleteCategory(Category category);
	
	public void updateCategory(Category category);

}
