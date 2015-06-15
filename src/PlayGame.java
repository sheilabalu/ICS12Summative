import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class PlayGame extends JFrame
{
	public Container pane = getContentPane ();
	public Player player = new Player("Peter");
	
	  //==============constructor=================
	public PlayGame ()
	{
		//set screen size
		pane.setPreferredSize(new Dimension(1000,600));
		//set layout
		pane.setLayout(new BorderLayout());
		//load main menu
		pane.add(new MainMenu(this, 1000,600));
	}
	
	//==============main method=================
	public static void main (String[] args)
	{
		PlayGame playGame = new PlayGame ();
		playGame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		playGame.pack ();
		playGame.setVisible (true);
	}

	//==============getImage which reads BufferedImages=================
	public static BufferedImage getImage (String path)
    {
		BufferedImage image = null;
		try
		{
	 	   image = ImageIO.read (new File (path));
		}


		catch (Exception e)
		{
			System.out.println("Can't find image "+path);
		}
		return image;
	}
}

/*private void play()
{
	// check if player won or lost and display appropriate message
	waves();
}
public void waves()
{
	while(map.nextWave()) // return if player health <= 0
	{


	}
}*/




