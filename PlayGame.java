import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.ArrayList;
import javax.swing.*;

@SuppressWarnings("serial")
public class PlayGame extends JFrame
{
	public Container pane = getContentPane ();
	
   //==============constructor=================
	public PlayGame ()
	{
		pane.setPreferredSize(new Dimension(1000,600));
		pane.setLayout(new BorderLayout());
      //show title screen
      pane.add(new MainMenu(this, 1000,600),BorderLayout.CENTER);
	}
	
	//==============method to retrieve image=================
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

	//==============main method=================
	public static void main (String[] args)
	{
		PlayGame playGame = new PlayGame ();
		playGame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		playGame.pack ();
		playGame.setVisible (true);
		playGame.play();
	}
	private void play(){
		
		
	}
}