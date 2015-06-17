
public class Test {

	public Test ()
	{
		TestThread t= new TestThread();
		t.start();
		for (int k=0;k<100;k++)
		{
			try
			{
				Thread.sleep(100);
				System.out.println("Hello world");
			}
			catch (Exception e)
			{
				
			}
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test test= new Test();
		
	}
	
	public class TestThread extends Thread
	{
		public void run ()
		{
			try
			{
				for (int k=0;k<20;k++)
				{
					Thread.sleep(500);
					System.out.println(k);
				}
				
			}
			catch (Exception e)
			{
				
			}
		}
	}

}
