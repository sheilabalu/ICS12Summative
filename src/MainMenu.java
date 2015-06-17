import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JPanel 
{
   private PlayGame game;
   public Sound s;

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
      //load background music
	  s= new Sound("titleMusic.wav");
	  game.s=s;
	  s.start();
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

