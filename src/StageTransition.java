import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.*;
import java.awt.event.*;

public class StageTransition extends JPanel implements ActionListener
{
	public int maxX,maxY,currentY,stageNum;
	public Timer t;
	private PlayGame game;
	
	//============constructor===========
	public StageTransition (int stage, int x, int y, PlayGame playGame)
	{
		super();
		//set screen size
		setPreferredSize(new Dimension(1000,600));
		//screen size act as bounds
		maxX=x;
		maxY=y;
		game=playGame;
		stageNum=stage;
		currentY=0;
		//timer to animate
		t=new Timer(100,this);
		t.start(); //start timer
	}
	
	//============actionPerformed method===========
	public void actionPerformed (ActionEvent e)
	{
		if (currentY<=maxY) //while paint has not covered entire screen
		{
			repaint();
			currentY+=20; //increase Y
		}
		else
		{
			t.stop();
         if (stageNum<9)
         {
			//add new fight stage to panel
            DrawBoard drawBoard= new DrawBoard(1000,600,game,stageNum);
            game.pane.add(drawBoard);
            //requestFocus back to drawBoard so keylistener would work
            drawBoard.requestFocus();
            game.pack ();
         }
         else 
         {
				//Get rid of everything on screen
	            game.pane.removeAll();
	            //add win message to main panel
	            game.pane.add(new LongMessage("PlayerWin",1000,600,game),BorderLayout.CENTER);
	            game.pack();
         }
		}
	}
	
	//============paintMethod method===========
	public void paintComponent (Graphics g)
	{
		Font text = new Font ("SansSerif", Font.BOLD, 40);
		g.setFont(text);
		   
		//fills black rectangle
		g.fillRect(0,0,1000,currentY);
		g.setColor(Color.WHITE);
		if (stageNum<8) //draws stage text
		{
			g.drawString("STAGE "+stageNum, 400, currentY-300);
		}
		else if (stageNum==8) //special text for last stage
		{
			g.drawString("DRAGON'S DEN ", 320, currentY-300);
		}
	}
}
