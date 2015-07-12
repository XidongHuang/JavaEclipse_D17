package tony.java.product;

import javax.xml.transform.Templates;

/*
 * 1.是否涉及到多线程问题？ 是, 生产者，消费者
 * 2.是否涉及到共享数据？有，产品。 考类线程的安全
 * 3.是否涉及到线程的通信？ 是，生产者与消费者的通信
 * 
 * 
 */

public class TestProductConsume {
	public static void main(String[] args) {
		Clerk c1 = new Clerk();
		
		Productor p1 = new Productor(c1);
		Client cl1 = new Client(c1);
		
		Thread t1 = new Thread(cl1);
		Thread t2 = new Thread(p1);
		Thread t3 = new Thread(p1);
		t2.setName("成产者:");
		t1.setName("消费者:");
		t3.setName("成产者2:");
		t2.start();
		t1.start();
		t3.start();
		
		
		
	}
}


class Clerk {
	private int productions=0;
	
	
	
	public int getProductions() {
		return productions;
	}



	public void setProductions(int productions) {
		this.productions = productions;
	}


	

	public Clerk() {
		super();
	}



	public synchronized void sale(){
		
		if(productions > 0){
			
			System.out.println("Sold the "+ productions +"th production to coustmer.");
			productions--;
			notify();
			
			
		} else {
			System.out.println("Clerk has not more productions for sale.");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	

	public synchronized void add(){
		
		if(productions < 20){
			
			productions++;
			System.out.println("Clerk added the "+productions+"th production");
			notify();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}


class Client implements Runnable{
	Clerk c;
	
	
	public Client(Clerk c){
		this.c = c;
	}
	
	
	public void run(){
		while(true){
			
			c.sale();
			System.out.println(Thread.currentThread().getName()+" bought a product==" + c.getProductions());
		}
		
		
		
	}
}


class Productor implements Runnable{
	Clerk c;
	
	public Productor(Clerk c){
		this.c = c;
	}
	
	
	public void run(){
		while(true){
			
			c.add();
			System.out.println(Thread.currentThread().getName()+" producted a production === "+ c.getProductions());
		
		
		}
	}
	
	
}




