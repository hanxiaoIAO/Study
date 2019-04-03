package hanxiao.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {
	
	@Test
	public void testMybatis() throws Throwable {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
//		List<Category> categorys = session.selectList("listCategory");
		CategoryDao categoryDao = session.getMapper(CategoryDao.class);
		List<Category> categorys = categoryDao.listCategory();
		for(Category category:categorys) {
			System.out.println(category.getName());
		}

		Category category = categoryDao.getCategory(1);
		System.out.println(category.getName());
		
		category = new Category();
		category.setId(5);
		category.setName("category6");
		categoryDao.addCategory(category);
		
		category.setName("category5");
		categoryDao.updateCategory(category);
		
        session.commit();
        session.close();
	}
}
