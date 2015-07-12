package tony.java.exe;
//模拟火车站售票窗口，开启三个窗口售票，总票数为100张


public class TestWindow4 {

	static int numOfT = 1;
	public static void main(String[] args) {
//		
//		Thread st1 = new Thread(){
//			
//			public void run(){
//				if(numOfT <= 100){
//				while(numOfT <= 100){
//					System.out.println(Thread.currentThread().getName()+": " + numOfT+"th ticket.");
//					numOfT++;
//				}
//				}
//				
//			}
//			
//		};
//		
//		
//		Thread st2 = new Thread(){
//		
//		public void run(){
//			if(numOfT <= 100){
//			while(numOfT <= 100){
//				System.out.println(Thread.currentThread().getName()+":= " + numOfT+"th ticket.");
//				numOfT++;
//			}
//			}
//			
//		}
//		
//	};
//	
//		
//		Thread st3 = new Thread(){
//	
//	public void run(){
//		if(numOfT <= 100){
//		while(numOfT <=100){
//			System.out.println(Thread.currentThread().getName()+":== " + numOfT+"th ticket.");
//			numOfT++;
//		}
//		}
//		
//	}
//	
//};
//
//
//		st1.start();
//		st2.start();
//		st3.start();
		
		Windows4 w = new Windows4();
		Thread st1 = new Thread(w);
		Thread st2 = new Thread(w);
		Thread st3 = new Thread(w);
		
		
		st1.start();
		st2.start();
		st3.start();

	}
	
	
}



class Windows4 implements Runnable{
	static int numOfT = 100;
	
	public void run(){
		show();
	}
	
	public synchronized void show(){
		
		while(true){
		
			if(numOfT >0){
				System.out.println(Thread.currentThread().getName()+": " + numOfT +"th ticket.");
			numOfT--;
			} else{
				break;
			}
		}
	}
	
}







