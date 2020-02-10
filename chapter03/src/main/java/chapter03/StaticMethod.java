package chapter03;

public class StaticMethod {

	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
	}
	
	void f2() {
		// 같은 클래스의 클래스 변수 접근에서는 클래스 이름 생략이 가능하다.
		System.out.println(m);
	}

	void f3() {
		f2();
	}
	
	static void s1() {
		// static method에서 인스턴스 접근은 안된다.
		//System.out.println(n);
	}
	
	static void s2() {
		// 같은 클래스의 클래스 변수 접근에서는 클래스 이름 생략이 가능하다.
		System.out.println(m);
	}
	
	static void s3() {
		// 오류 : static method에서 인스턴스 접근은 불가능하다.
		//f1();
	}
}
