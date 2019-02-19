package hanxiao.spring.b_iocdi_annotion;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * web开发，提供3个@Component注解衍生注解（功能一样）取代<bean class="">
 *	@Repository ：dao层
 *	@Service：service层
 *	@Controller：web层
 */
@Component("material")
@Scope("prototype")
public class Material {

	private int id;
	private String code;
	private String name;

	Category category;

	public int getId() {
		return id;
	}
	
/*	依赖注入	，给私有字段设置，也可以给setter方法设置
	普通值：@Value("")*/
	@Value("1")
	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

/*	引用值：
		方式1：按照【类型】注入
			@Autowired
		方式1：按照【名称】注入2
			@Resource(name="名称")*/
	@Resource(name="category")
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", code=" + code + ", name=" + name + ", category=" + category.getCode() + " "
				+ category.getName() + "]";
	}

}
