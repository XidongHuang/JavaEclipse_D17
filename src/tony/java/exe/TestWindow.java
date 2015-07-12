package tony.java.exe;
//模拟火车站售票窗口，开启三个窗口售票，总票数为100张


public class TestWindow {

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
		
		Windows st1 = new Windows("Window 1");
		Windows st2 = new Windows("Window 2");
		Windows st3 = new Windows("Window 3");
		st1.start();
		st2.start();
		st3.start();

	}
	
	
}



class Windows extends Thread{
	static int numOfT = 100;
	public Windows(String name){
		super(name);
	}
	
	public void run(){
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







