package asMultithreadMessages;

public class Message implements Runnable{
	private String msg;
	private int reps;
	
	public Message(String msg, int reps) {
		super();
		this.msg = msg;
		this.reps = reps;
	}

	public void run() 
    {
		for(int i = 0; i < reps; i++) {
			System.out.print(msg); 
			}
		}

}
