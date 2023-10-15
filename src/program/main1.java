package program;

public class main1 {

	public static void main(String[] args) {
		Thread thread1=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					Counter.increment();
				}
			}
		});
		Thread thread2=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					Counter.increment();
				}
			}
		});
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
		System.out.println(Counter.getValue());
	}
}
class Counter{
	private static int count;
	public static void increment() {
		count++;
	}
	public static int getValue() {
		return count;
	}
}
//The first result - 1771
//The second result - 1626
//The third result - 1016
//The fourth result - 1008
//The fifth result - 1045