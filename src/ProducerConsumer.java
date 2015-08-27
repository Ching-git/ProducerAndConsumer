
public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SyncStack ss = new SyncStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		new Thread(p).start();
		new Thread(c).start();
	}

}

class WoTou {
	int id;
	public WoTou(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	
	public String toString() {
		return "WoTou : " + id;
	}
}

class SyncStack {
	int index = 0;
	WoTou[] arrWT = new WoTou[6];
	
	public synchronized void push(WoTou wt) {
		if (index == arrWT.length){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		arrWT[index] = wt;
		index++;
	}
	
	public synchronized WoTou pop() {
		if (index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
		return arrWT[index];
	}
}

class Producer implements Runnable {

	SyncStack ss = null;
	
	public Producer(SyncStack ss) {
		// TODO Auto-generated constructor stub
		this.ss = ss;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 20 ; i++){
			WoTou wt = new WoTou(i);
			ss.push(wt);
			System.out.println("生产了: " + wt);
			try {
				Thread.sleep((long) (1000*Math.random()));
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
}

class Consumer implements Runnable {

	SyncStack ss = null;
	
	public Consumer(SyncStack ss) {
		// TODO Auto-generated constructor stub
		this.ss = ss;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 20 ; i++){
			WoTou wt = ss.pop();
			System.out.println("消费了: " + wt);
			try {
				Thread.sleep((long) (1000*Math.random()));
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
}
