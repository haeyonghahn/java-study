package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {

		String s1 = new String("ABC");
		String s2 = new String("ABC");
		
		// 동일성 비교 ( 두 객체를 비교)
		System.out.println(s1 == s2);
		// equals가 overload가 되어있지 않으므로 내용기반으로 되어있는 hashCode가 같으므로 두 객체는 같다.
		System.out.println(s1.equals(s2));
		// 현재 hashCode는 내용 기반으로 되어 있음
		System.out.println(s1.hashCode() + ":" + s2.hashCode());
		// 두 객체의 주소값 출력
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2));
	
		System.out.println("========================");
		
		String s3 = "ABC";
		String s4 = "ABC";
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		System.out.println(s3.hashCode() + ":" + s4.hashCode());
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4));
		
	}

}
