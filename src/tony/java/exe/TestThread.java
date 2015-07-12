package tony.java.exe;
//创建多线程的方式一：继承Thread类

class PrintNum extends Thread{
	public void run(){
		//需要子线程执行的代码
		for(int i = 1; i<= 100; i++){
			if(i%2 == 0){
				
				System.out.println(Thread.currentThread().getName()+": "+i);
			}
			
		}
		
	}
	public PrintNum(String name){
		super(name);
		
		
	}
	
}


public class TestThread {
	public static void main(String[] args) {
		PrintNum pn1 = new PrintNum("线程一");
		PrintNum pn2 = new PrintNum("线程二");
		pn1.setPriority(Thread.MAX_PRIORITY);
		pn2.setPriority(Thread.MIN_PRIORITY);
		pn1.start();
		pn2.start();
		
		
	}
}
