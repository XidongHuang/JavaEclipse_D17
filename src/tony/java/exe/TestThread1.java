package tony.java.exe;

/*创建多线程的方法二： 通过实现的方式
 *
 * 
 * 对比一下继承的方式 vs 实现的方式
 * 1. 联系：public class Thread implements Runnable —— 都与Runnable发生关系
 * 2. 哪个方式好？ 实现的方式优于继承的方式
 * 			Why?  a) 避免类java单继承的局限性
 * 				  b) 如果多个线程要操作同一份资源(数据)，更适合使用实现的方式
 * 
 */


 //1. 创建一个实现了Runnable接口的类
class PrintNum1 implements Runnable{
	//2.实现接口的抽象方法
	public void run(){
		//子线程执行的代码
		for(int i = 1;i<=100;i++){
			if(i%2 ==0){
				System.out.println(Thread.currentThread().getName()+": " +i);
			}
			
		}
		
		
	}
	
}



public class TestThread1 {
	public static void main(String[] args) {
		//创建一个Runnable接口实现类的对象
		PrintNum1 p = new PrintNum1();
		//4. 讲此对象作为形参专递给Thread类的构造器中，创建Thread类的对象，此对象即为一个线程
		Thread p1 = new Thread(p); 
		
		//要想启动一个多线程，必须调用start()方法
		//5.调用start()方法：启动线程并执行run()
		p1.start();//启动线程：执行Thread对象生成时构造器形参的对象的run()方法
		
		Thread p2 = new Thread(p);
		p2.start();
		
		
	}
}
