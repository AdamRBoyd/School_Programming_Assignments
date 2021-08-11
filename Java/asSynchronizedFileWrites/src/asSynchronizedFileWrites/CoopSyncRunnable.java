package asSynchronizedFileWrites;

import java.io.*;

public class CoopSyncRunnable implements Runnable{
	private String msg;
	private int count;
	private String fileName;
	private Object obj;
	
	public CoopSyncRunnable(String msg, int count, String fileName, Object obj) {
		super();
		this.msg = msg;
		this.count = count;
		this.fileName = fileName;
		this.obj = obj;
	}

	@Override
	public void run() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fileName, true), true);
			Thread.sleep(10);
			for (int i = 0; i < count; i++) {
				synchronized (obj) {
					pw.println(msg);
					System.out.println(msg);
					Thread.sleep(10);
					obj.notify();
					obj.wait();
				}
				Thread.sleep(10);
			}
			synchronized (obj) {
				obj.notify();
			}
			pw.close();
			System.out.println("Thread Done");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
