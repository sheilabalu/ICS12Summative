import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.*;

public class LongMessage extends JPanel 
{
   private Scanner s;
   private Timer t;
   private int lineNum;
   private JButton control;
   private MessageListener messageListener;
   private ArrayList<String> message;
   private PlayGame game;
   private String event;
   
   //===========constructor=========
    public LongMessage (String path,int x, int y, PlayGame p) 
   {
	   //inherit super's constructor
		super ();
	
		//set size of panel
		setPreferredSize(new Dimension(x,y));
	
      //initialize variables
      s=null;
      game=p;
      messageListener= new MessageListener();
      t= new Timer (500,messageListener);
      lineNum=0;
      message= new ArrayList<String>();
	  event=path; 
     
      //use border layout
	 setLayout(new BorderLayout());
	 //create control button
	 control= new JButton ("Start");
	 add(control,BorderLayout.SOUTH);
	 //add actionlistener to control button
     control.addActionListener(new BtnListener());
      
      //set Scanner to file path
	  try
      {
			s = new Scanner(new File("txt/"+path+".txt"));
	  }
      catch(Exception e)
      {
    	  System.out.println(path+".txt not found");
	  }


   }
   
 //==============paintComponent method that paints text=================
   public void paintComponent(Graphics g)
   {
	   //set initial y-axis value
	   int y=200;
	   Font text = new Font ("SansSerif", Font.BOLD, 20);
	   g.setFont(text);

	   //draw a black screen
       g.setColor(Color.BLACK);
       g.fillRect(0,0,1000,600);

       //change color to white for text
	   g.setColor(Color.white);
	   for (int k=0;k<lineNum;k++)
	   {
	         g.drawString(message.get(k),150,y);
	         //shift next line down
	         y+=30;
	   }
   }
   
 //==============MessageListener Class=================
   public class MessageListener implements ActionListener
   {
	   public void actionPerformed (ActionEvent e)
	   {
		   //Scanner s has more lines to read
		   if (s.hasNextLine())
		   {
			   lineNum++;
			   //read line and add it to ArrayList message
			   message.add(s.nextLine());
			   //animate
			   repaint();
		   }
		   //No more lines to read
		   else
		   {
			   //stop timer
			   t.stop();
			   //clear ArrayList
			   message.clear();
			   //change text of control button
			   control.setText("Okay");
		   }
	   }
   }
   
 //==============BtnListener Class=================
   public class BtnListener implements ActionListener
   {
	   public void actionPerformed (ActionEvent e)
	   {
		   if (e.getActionCommand().equals("Start"))
			   t.start(); //start timer
		   else if (e.getActionCommand().equals("Okay"))
		   {
			   //Get rid of everything on screen
	            game.pane.removeAll();
			   if (event.equals("Intro"))
			   {
	            //add village Scene to main panel
	            DrawBoard drawBoard= new DrawBoard(1000,600,game,1);
	            game.pane.add(drawBoard);
	            //requestFocus back to drawBoard so keylistener would work
	            drawBoard.requestFocus();
	            game.pack ();
			   }
			   else if (event.equals("PlayerDeath")||event.equals("PlayerWin"))
			   {
				   game.setVisible(false); //you can't see me!
				   game.dispose(); //goodbye!
			   }
		   }
			   
	   }
   }
      
}