package training.threadtest;

/**
 * 启动一个线程的3种方式
 */
public class StartThread {

	public static void main(String[] args) {
		// 1. 继承自Thread类（这里使用的是匿名类）
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("extends Thread, threadName: " + Thread.currentThread().getName());
				}
			};
		}.start();

		// 2. 实现Runnable接口（这里使用的是匿名类）
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("impliment Thread, threadName: " + Thread.currentThread().getName());
				}
			}
		}).start();

		// 3.即实现Runnable接口，也继承Thread类，并重写run方法
		new Thread(new Runnable() {
			public void run() { // 实现Runnable接口
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("implements Runnable thread: " + Thread.currentThread().getName());
				}
			}
		}) { // 继承Thread类
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out
							.println("extends Thread(Override run method) thread: " + Thread.currentThread().getName());
				}
			}
		}.start();
	}
}