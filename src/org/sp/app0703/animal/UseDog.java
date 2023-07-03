package org.sp.app0703.animal;

public class UseDog {
	public void setAge(Dog d) {
		d.age = 7;
	}
		
	public static void main(String[] args) {
		UseDog ud = new UseDog();
		int x = 8;
		Dog d = new Dog();
		System.out.println(d.age);
		//ud.setAge(x); -> call by value/ 매개변수에는 x가 보유한 값인 8이 넘어가는 것. x의 주소값이 넘어간 것이 아니다.
		ud.setAge(d); // call by reference/ Dog형의 d의 주소값이 넘어가는 것 -> 객체형의 주소값을 넘긴 후에는 원본 Dog형 객체의 데이터에 영향을 미칠 수 있는 것. 조심해야 한다.
	}
}
