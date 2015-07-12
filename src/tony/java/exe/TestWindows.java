package tony.java.exe;

import org.omg.CORBA.PUBLIC_MEMBER;
//使用实现Runnable接口的方式售票
/*
 * 此程序存在线程的安全问题：打印车票时，会出现重票，错票
 * 1. 线程安全问题存在的原油？
 * 		由于一个线程在操作共享数据过程中，未执行完的情况下，另外的线程参与进来，导致共享数据存在安全问题。
 * 
 * 2. 如何来解决线程的安全问题？
 * 		必须让一个线程操作共享数据完毕以后，其他线程才有机会参与共享数据的操作。
 * 
 * 3. java如何实现线程的安全: 线程同步机制
 * 
 * 		方式一：同步代码块
 * 		synchronized(同步监视器){
 * 		//需要被同步的代码块 (即为操作共享数据的代码)
 * 		}
 * 		1.共享数据: 多个线程共同操作的同一个数据(变量)
 * 		2.同步监视器： 由一个类的对象来充当。哪个线程获取此监视器，谁就执行大括号里被同步的代码。俗称：琐
 * 			> 要求：所有的线程必须共用同一把锁
 * 			> 注意：在现实的方式中，考类同步的话，可以使用this来充当锁。但在继承方式中，慎用this！
 * 
 * 
 * 		方式二：同步方法
 * 		将操作恭喜哪个数据的方法声明为synchronized. 即此方法为同步方法，能够保证其中一个线程执行此
 * 		方法时，其他线程在外等待直至此线程执行完此方法。
 * 		> 同步方法的锁: this
 * 
 * 4. 线程同步的弊端L由于同一个时间只能有一个线程访问共享数据，效率变低了
 * 
 * 
 */

class Windows1 implements Runnable{
	int ticket = 100;//共享数据
	
//	Object obj = new Object();

	public void run(){
		
			while(true){
				synchronized (this) {
				if(ticket >0){
				try {
					Thread.currentThread().sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			System.out.println(Thread.currentThread().getName()+": "+ticket--);
			
		}
			}
		}
		
		
		
		
	}
}




public class TestWindows {
	public static void main(String[] args) {
		Windows1 w = new Windows1();
		
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		t1.setName("Window 1");
		t2.setName("Window 2");
		t3.setName("Window 3");
		
		t3.start();
		t1.start();
		t2.start();
		
	}
}
