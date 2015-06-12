import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;



import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.*;
import javax.imageio.ImageIO;


import javax.swing.*;

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

		pane.add(drawboard);
	}

	public class DrawBoard extends JPanel implements KeyListener
	{
		public DrawBoard (int x, int y)
		{
			super ();
			addKeyListener(this);
			setPreferredSize(new Dimension(x,y));
		}

		public void keyTyped(KeyEvent e) {}

		public void keyPressed(KeyEvent e) 
		{
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_LEFT)
			{
				me.setStatus(1);
				me.setFaceRight(false);
				me.setFoot(!(me.getFoot()));
				me.moveLeft();
			}
			else if (keyCode == KeyEvent.VK_RIGHT)
			{
				me.setStatus(1);
				me.setFaceRight(true);
				me.setFoot(!(me.getFoot()));
				me.moveRight();
			}
			else if (keyCode == KeyEvent.VK_UP)
			{
				me.setStatus(0);
				me.moveUp();
			}
			else if (keyCode == KeyEvent.VK_DOWN)
			{
				me.setStatus(0);
				me.moveDown();
			}
			else if (keyCode == 65)
				me.setStatus(2);	    	

			try{
				int gravity = me.getY();
				gravity--;

				while(map.getMap(12-gravity, me.getX()) != 'W' && gravity > 0)
				{
					gravity--;
				}

				System.out.println(me.getX()+" , "+ me.getY() + " , " + gravity);
				me.setY(gravity+2);
			}
			catch (ArrayIndexOutOfBoundsException error){}
			repaint();
		}

		public void keyReleased(KeyEvent e) {}

		public boolean isFocusTraversable()
		{
			return true;
		}

		public void paintComponent (Graphics g)
		{
			map.show(g);
			me.show(g);
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


//@SuppressWarnings("serial")
//public class PlayGame extends JFrame
//{
//	public Container pane = getContentPane ();
//	public Map map;
//	public PlayGame ()
//	{
//		pane.setPreferredSize(new Dimension(1000,600));
//		DrawBoard drawboard= new DrawBoard (1000,600);
//		pane.setLayout(new BorderLayout());
//		map=new Map ("Map2");
//		//drawboard.repaint();
//		pane.add(drawboard);
//	}
//
//	public class DrawBoard extends JPanel
//	{
//		public DrawBoard (int x, int y)
//		{
//			super ();
//			setPreferredSize(new Dimension(x,y));
//		}
//
//		public void paintComponent (Graphics g)
//		{
//			map.show(g);
//		}
//	}
//	public static void main (String[] args)
//	{
//		PlayGame playGame = new PlayGame ();
//		playGame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//		playGame.pack ();
//		playGame.setVisible (true);
//		playGame.play();
//	}
//	private void play()
//	{
//		// check if player won or lost and display appropriate message
//		waves();
//	}
//	public void waves()
//	{
//		while(map.nextWave()) // return if player health <= 0
//		{
//
//
//		}
//	}
//}
