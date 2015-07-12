package tony.java.exe1;

class A {
	public synchronized void foo(B b) {//锁：A的对象
	
		b.last();
	}

	public synchronized void last() {//锁：A的对象
	}
}

class B {
	public synchronized void bar(A a) {//锁：B的对象

		a.last();
	}

	public synchronized void last() {//锁：B的对象
		
	}
}

public class DeadLock implements Runnable {
	A a = new A();
	B b = new B();

	public void init() {
		
		a.foo(b);

	}

	public void run() {
		
		b.bar(a);
	
	}

	public static void main(String[] args) {
		DeadLock dl = new DeadLock();
		new Thread(dl).start();
		dl.init();
	}
}
