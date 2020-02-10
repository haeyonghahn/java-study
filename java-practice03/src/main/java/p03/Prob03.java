package p03;

public class Prob03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CurrencyConverter.setRate(1200.0);
		System.out.println(CurrencyConverter.getRate());
		System.out.println(CurrencyConverter.toDollar(1000000));
		System.out.println(CurrencyConverter.toKRW(100));
	}

}
