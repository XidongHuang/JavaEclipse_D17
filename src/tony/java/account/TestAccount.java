package tony.java.account;
/*
 * 银行有一个账户
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次，每次存完打印账户余额。
 * 
 * 1.是否涉及到多线程？！ 是，有两个储户(两种方式创建多线程)
 * 2.是否有共享数据？有，同一个账户
 * 3.得考虑线程的同步。（两种方法处理线程的安全）
 * 
 *   > 实现两个储户交替存钱 ———— 使用线程通信！
 * 
 */
public class TestAccount {
	public static void main(String[] args) {
		Clients c = new Clients();
		
		Thread t1 =new Thread(c);
		Thread t2 = new Thread(c);
		
		t1.start();
		t2.start();
	}
}


class Account {
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account(double balance) {
		super();
		this.balance = balance;
	}
	
	public void deposite(double amout){
		this.balance += amout;
	}
		
	public void withdraw (double amout){
		this.balance -= amout;
	}

}


class Clients implements Runnable{
	private Account a = new Account(0);
	
	
	public synchronized void run(){
		for(int i=0; i<3;i++){
			notify();
//			synchronized (Clients.class) {
				a.deposite(1000);
				
				try {
					Thread.currentThread().sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" deposites $1000."+ a.getBalance());
//			}
				
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}
	
	
}

