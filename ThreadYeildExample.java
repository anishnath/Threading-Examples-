/**
 * Author Anish Nath
 * Visit the channel http://youtube.com/zarigatongy
 * Thread.join Waits for this thread to die.
 */
public class ThreadYeildExample implements Runnable {

	@Override
	public void run() {
		
		
			for (int i = 0; i < 10; i++) {

				try {
					
					Thread.sleep(100);
					System.out.println("i =  " + i + " " + Thread.currentThread().getName());
					if(i==5)
					{
						System.out.println("Yeilding " + Thread.currentThread().getName());
						Thread.yield();
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		

	}

	public static void main(String[] args) throws InterruptedException {

		ThreadYeildExample threadJoinExample = new ThreadYeildExample();
		Thread t = new Thread(threadJoinExample);
		Thread t1 = new Thread(threadJoinExample);
		Thread t2 = new Thread(threadJoinExample);

		t.start();

		t1.start();

		t2.start();

	}
}
