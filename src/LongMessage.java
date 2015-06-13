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
   private Graphics g;
   private JButton control;
   private MessageListener messageListener;
   private ArrayList<String> message;
   
   //===========constructor=========
   public LongMessage (String path,int x, int y) 
   {
	   //inherit super's constructor
		super ();
		//set size of panel
		setPreferredSize(new Dimension(x,y));
		
      //initialize scanner to null
      s=null;
      messageListener= new MessageListener();
      t= new Timer (200,messageListener);
      lineNum=0;
      message= new ArrayList<String>();
	   
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
   
   public void paintComponent(Graphics g)
   {
	   //set initial y-axis value
	   int y=40;

	   //draw a black screen
       g.setColor(Color.BLACK);
       g.fillRect(0,0,1000,600);

       //change color to white for text
	   g.setColor(Color.white);
	   System.out.println("hahaha");
	   for (int k=0;k<lineNum;k++)
	   {
	         g.drawString(message.get(k),40,y);
	         System.out.println(message.get(k));
	         //shift next line down
	         y+=20;
	   }
   }
   
   public class MessageListener implements ActionListener
   {
	   public void actionPerformed (ActionEvent e)
	   {
		   if (s.hasNextLine())
		   {
			   lineNum++;
			   message.add(s.nextLine());
			   repaint();
		   }
		   else
		   {
			   t.stop();
			   message.clear();
			   control.setText("Continue");
		   }
	   }
   }
   
   public class BtnListener implements ActionListener
   {
	   public void actionPerformed (ActionEvent e)
	   {
		   if (e.getActionCommand().equals("Start"))
			   t.start();
		   else if (e.getActionCommand().equals("Continue"))
			   t.stop();
			   
	   }
   }

   
   
}