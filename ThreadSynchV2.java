package threads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Author Anish Nath
* visit the channel http://youtube.com/zarigatongy
 */
public class ThreadSynchV2 implements Runnable {
	private String name;
	private List<String> list;

	public ThreadSynch(List<String> name) {
		this.list = name;

		new Thread(this).start();
	}

	public void run() {
		while (true) {
			synchronized (this) {
				for(String s : list)
				{
					try {
						wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					System.out.println(s);
				}
				
			}
		}
	}

	public static void main(String[] args) {

		ThreadSynch threads[] = new ThreadSynch[3];

		List<String> l1 = new ArrayList<String>();
		l1.add("A");
		l1.add("B");
		l1.add("C");
		List<String> l2 = new ArrayList<String>(l1);
		List<String> l3 = new ArrayList<String>(l1);

		for (int i = 0; i < 3; ++i) {
			if (i == 0) {
				threads[i] = new ThreadSynch(l1);
			}
			if (i == 1) {
				threads[i] = new ThreadSynch(l2);
			}
			if (i == 2) {
				threads[i] = new ThreadSynch(l3);
			}

			// threads[i] = new ThreadSynch("t"+i);
		}
		int index = 0;
		while (true) {
			synchronized (threads[index]) {
				threads[index].notify();
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			index = (++index) % 3;
		}

	}
}
