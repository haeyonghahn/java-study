package p02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		GoodsApp[] goods = new GoodsApp[3];
		
		System.out.println("실행결과:");
		for(int i=0; i<goods.length; i++) {
			goods[i] = new GoodsApp(input.next(), input.nextInt(), input.nextInt());
		}
		
		for(int i=0; i<goods.length; i++) {
			System.out.println(goods[i].getGoods() + "(가격:" + goods[i].getBalance() + "원)이 " + goods[i].getCount() + "개 입고 되었습니다.");
		}
	}
}
