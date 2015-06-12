
public class RunnableMonster implements Runnable 
{
	public RunnableMonster(Life monster) {
		// TODO Auto-generated constructor stub
		run();
	}

//	public static void main(String args[]) {
//        (new Thread(new RunnableMonster(null))).start();
//    }
	
	public void run()
	{
        System.out.println("Hello from a thread!");
    }
}
