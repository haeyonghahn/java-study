package p02;

public class GoodsApp {

	private String goods;
	private int balance;
	private int count;
	
	public GoodsApp() {
		
	}
	
	public GoodsApp(String goods, int balance, int count) {
		this.goods = goods;
		this.balance = balance;
		this.count = count;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
