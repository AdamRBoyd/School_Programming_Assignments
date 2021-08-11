package asSynchronizedFileWrites;

import java.io.*;

public class CompSyncRunnable implements Runnable {
	private String msg;
	private int count;
	private String fileName;
	private Object obj;

	public CompSyncRunnable(String msg, int count, String fileName, Object obj) {
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
			synchronized (obj) {
				for (int i = 0; i < count; i++) {
					pw.println(msg);
					System.out.println(msg);
					Thread.sleep(10);
				}
			}
			pw.close();
			System.out.println("Thread Done");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
