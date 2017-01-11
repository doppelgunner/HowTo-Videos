public class Deadlock {
	
	public static void main(String[] args) {
		
		//create java threads using java 8 lambda style - these calls the print method
		Thread thread1 = new Thread(() -> {print1("thread1");});
		Thread thread2 = new Thread(() -> {print2("thread2");});
		Thread thread3 = new Thread(() -> {print3("thread3");});
		
		//start threads
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	//synchronized so one thread needs to finish before another can use the method
	synchronized public static void print1(String threadName) {
		System.out.println(threadName + ": print1");
		//call the other in cycles to produce a deadlock
		print2(threadName);
	}
	
	synchronized public static void print2(String threadName) {
		System.out.println(threadName + ": print2");
		print3(threadName);
	}
	
	synchronized public static void print3(String threadName) {
		System.out.println(threadName + ": print3");
		print1(threadName);
	}
}