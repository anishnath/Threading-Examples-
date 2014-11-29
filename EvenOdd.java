/**
Author Anish Nath
Visit the Channel
http://youtube.com/zarigatongy
**/
public class EvenOdd {

	 int x = 0;

	public synchronized void printEven() throws InterruptedException {

			if (x % 2 == 0) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " " + x);

				wait();

			}
		++x;
		notify();
	}

	public synchronized void printOdd() throws InterruptedException {

			if (!(x % 2 == 0)) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " " + x);

				wait();

			}
		++x;
		notify();

	}

	public static void main(String[] args) {

		final EvenOdd evenOdd = new EvenOdd();
		final EvenOdd evenOdd1 = new EvenOdd();

		Thread t = new Thread(new Runnable() {

			public void run() {
				while (true) {
					try {
						evenOdd.printEven();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		},"Even");

		t.start();

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				while (true) {
					try {
						evenOdd.printOdd();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		},"Odd");

		t1.start();

	}

}
