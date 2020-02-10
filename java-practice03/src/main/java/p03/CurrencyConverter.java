package p03;

public class CurrencyConverter {

	private static double rate;

	public CurrencyConverter() {

	}

	public CurrencyConverter(double rate) {
		CurrencyConverter.rate = rate;
	}

	public static double getRate() {
		return rate;
	}

	public static void setRate(double rate) {
		CurrencyConverter.rate = rate;
	}

	public static double toDollar(double won) {
		return won * getRate();
	}

	public static double toKRW(double dollar) {
		return dollar / getRate();
	}
}
