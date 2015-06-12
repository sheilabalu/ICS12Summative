import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class MainMenu extends JPanel 
{
   private PlayGame game;
  // private Map map1=new Map ("Map1");
   private Village village= new Village ("Village");
   
   //==============constructor=================
   public MainMenu (PlayGame g, int x, int y)
   {
      game=g;
      setPreferredSize(new Dimension(x, y));
      
      //"start" Button

      JButton start= new JButton ("Start");
      setLayout(null);
      start.setBounds(450,530,100,50);
      //I want to make the button invisible but clickable but somehow set opacity won't work. 
      start.setOpaque(false);
      start.setContentAreaFilled(false);
      start.setBorderPainted(false);
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
     // g.drawString ("Dragon Valley",280,70);
      
      //print "start" option
      g.setColor(Color.RED);
      Font options = new Font ("SansSerif", Font.BOLD, 40);
	   g.setFont (options);
      //g.drawString("Start",450,570);
      
   }
   
   //==============action listener for buttons=================
   public class BtnListener implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
        // if (e.getActionCommand ().equals ("Start"))
        // {
            game.pane.removeAll();
            game.pane.add(new DrawBoard(1000,600),BorderLayout.CENTER);
            game.pack();
        // }
      }
   }
   
   //==============DrawBoard Class=================
   	public class DrawBoard extends JPanel
	{
		public DrawBoard (int x, int y)
		{
			super ();
			setPreferredSize(new Dimension(x,y));
		}
		
		public void paintComponent (Graphics g)
		{
         super.paintComponent(g);
         village.show(g);
			//map1.show(g);
		}
	}
   
}