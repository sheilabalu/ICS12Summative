import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.*;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class PlayGame extends JFrame
{
	public Container pane = getContentPane ();
	public Map map;
	private Player me = new Player("ME", 100, 10, 10, 10);
	
	  //==============constructor=================
	public PlayGame ()
	{
		pane.setPreferredSize(new Dimension(1000,600));
		pane.setLayout(new BorderLayout());
		map=new Map ("Map2");
		//drawboard.repaint();
		pane.add(new MainMenu(this, 1000,600),BorderLayout.CENTER);

		//pane.add(drawboard);
	}
	
	//==============main method=================
	public static void main (String[] args)
	{
		PlayGame playGame = new PlayGame ();
		playGame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		playGame.pack ();
		playGame.setVisible (true);

		//playGame.play();
	}
	private void play()
	{
		// check if player won or lost and display appropriate message
		waves();
	}
	public void waves()
	{
		while(map.nextWave()) // return if player health <= 0
		{


		}
	}
	
	public static BufferedImage getImage (String path)
    {
		BufferedImage image = null;
		try
		{
	 	   image = ImageIO.read (new File (path));
		}


		catch (Exception e)
		{
		}
		return image;
	}
}




