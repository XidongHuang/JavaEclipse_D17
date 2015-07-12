package tony.java.exe1;
/*
 * 线程通信.如下的三个关键字使用的话，都得在同步代码块或同步方法中
 * wait():一旦一个线程执行到wait(),就释放前的锁。
 * notify()/notifyAll():唤醒wait的一个或所有的线程
 * 使用两个线程打印1-100，线程1.2交替打印
 * 
 * 
 * 
 */
public final class TestExe1 {

	
	public final static void main(String[] args) {
		final PrintNum p = new PrintNum();
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		
		t1.setName("Thread 1: ==");
		t2.setName("Thread 2: ===");
		
		t1.start();
		t2.start();
		
	}
}



class PrintNum implements Runnable{
	int num = 1;
//	Object obj = new Object();
	@Override
	public void run() {

		while(num <= 100){
			synchronized (this) {
				notify();
				
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + num);
				num++;

				
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
			
		}
		
	}
	

	
}