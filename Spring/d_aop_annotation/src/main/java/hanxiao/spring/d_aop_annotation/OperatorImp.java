package hanxiao.spring.d_aop_annotation;

import org.springframework.stereotype.Component;

@Component("operator")
public class OperatorImp implements Operator {

	@Override
	public void addOperator() {
		System.out.println("add operator");
		
	}

	@Override
	public void modifyOperator() {
		System.out.println("modify operator");
	}

	@Override
	public void deleteOperator() {
		System.out.println("delete operator");
	}

}
