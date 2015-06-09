
public class RunnableMonster implements Runnable 
{
	public static void main(String args[]) {
        (new Thread(new RunnableMonster())).start();
    }
	
	public void run() {
        System.out.println("Hello from a thread!");
    }
}
