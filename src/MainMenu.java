import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JPanel 
{
   private PlayGame game;
   
   //==============constructor=================
   public MainMenu (PlayGame g, int x, int y)
   {
      game=g;
      setPreferredSize(new Dimension(x, y));
      
      //"start" Button
      JButton start= new JButton ();
      setLayout(null);
      //locate button
      start.setBounds(450,530,100,50);
      //Make start button clickable but invisible
      start.setOpaque(false);
      start.setContentAreaFilled(false);
      start.setBorderPainted(false);
      //add start button to panel
      add(start);
      start.addActionListener(new BtnListener());
   }
   
   //==============paint graphics here=================
   public void paintComponent (Graphics g)
   {
      //draw image
      g.drawImage(PlayGame.getImage("Title.jpg"),0,0,null);
      
      //print title
      g.setColor (Color.BLACK);
	  Font title = new Font ("SansSerif", Font.BOLD, 70);
	  g.setFont (title);
      g.drawString ("Dragon Valley",280,70);
      
      //print "start" option
      g.setColor(Color.RED);
      Font options = new Font ("SansSerif", Font.BOLD, 40);
	  g.setFont (options);
      g.drawString("Start",450,570);
      
   }
   
   //==============action listener for buttons=================
   public class BtnListener implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
    	  	//Get rid of everything on screen
            game.pane.removeAll();
            //add Beginning message to main panel
            game.pane.add(new LongMessage("Intro",1000,600,game),BorderLayout.CENTER);
            game.pack();
      }
   }
   
}


/*	public class DrawBoard extends JPanel implements KeyListener
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
//return image;
}*/