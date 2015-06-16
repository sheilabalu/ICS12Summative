import java.applet.AudioClip;

public class Sound extends Thread //plays sound
{
	public AudioClip clip;
	public boolean stop;
	
	//==========constructor===========
	public Sound (String path)
	{
		//loads sound
		clip= PlayGame.getAudioClip(path);
	}
	
	//=======run method==========
	public void run ()
	{
	    try 
	    {
	    	//plays sound
	        clip.play();
	    } catch (Throwable e) 
	    {
	        System.out.println("Something happened");
	    }
	}
	
	//==============stopMusic method==========
	public void stopMusic ()
	{
		clip.stop();//stops music from playing
	}
}
