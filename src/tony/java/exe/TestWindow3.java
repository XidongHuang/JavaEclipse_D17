package tony.java.exe;
//模拟火车站售票窗口，开启三个窗口售票，总票数为100张


public class TestWindow3 {

	static int numOfT = 1;
	public static void main(String[] args) {

		
		Windows3 st1 = new Windows3("Window 1");
		Windows3 st2 = new Windows3("Window 2");
		Windows3 st3 = new Windows3("Window 3");
		st1.start();
		st2.start();
		st3.start();

	}
	
	
}



class Windows3 extends Thread{
	static int numOfT = 100;
	static Object obj = new Object();
	public Windows3(String name){
		super(name);
	}
	
	public void run(){
		while(true){
			synchronized (obj) {
			//show();//错的
			
			if (numOfT > 0) {
					try {
						Thread.currentThread().sleep(300);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName() + ": "
							+ numOfT + "th ticket.");
					numOfT--;
				}
			} 
		}
	
//	public synchronized void show(){
//			
//		
//	}
	}
	
}







