package p05;

public class Account {

	private String accountNo;
	private int balance = 0;
	
	public Account(String accuntNo) {
		super();
		this.accountNo = accuntNo;
		
		System.out.println(accountNo + " 계좌가 개설되었습니다." + "\n" + accountNo + " 계좌의 잔고는 " + balance + "만원입니다.");
	}
	
	public void save(int number) {
		balance = balance + number;
		System.out.println(accountNo + " 계좌에 " + number + "만원이 입금되었습니다.");
		System.out.println(accountNo + " 계좌의 잔고는 " + balance + "만원이 입금되었습니다.");
	}
	
	public void deposit(int number) {
		balance = balance - number;
		System.out.println(accountNo + " 계좌에 " + number + "만원이 출금되었습니다.");
		System.out.println(accountNo + " 계좌의 잔고는 " + balance + "만원이 출금되었습니다.");
	}
	
	public String getAccuntNo() {
		return accountNo;
	}
	public void setAccuntNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
