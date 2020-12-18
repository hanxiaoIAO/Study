package study.demo.demo1;

public class Example3 implements Vehicle,FourWheeler{

	@Override
	public void print() {
		Vehicle.super.print();
	}

}



interface Vehicle {
   default void print(){
      System.out.println("我是一辆车!");
   }
}
 
interface FourWheeler {
   default void print(){
      System.out.println("我是一辆四轮车!");
   }
}
