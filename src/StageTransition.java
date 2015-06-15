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
	
	public StageTransition (int stage, int x, int y, PlayGame playGame)
	{
		super();
		setPreferredSize(new Dimension(1000,600));
		maxX=x;
		maxY=y;
		game=playGame;
		stageNum=stage;
		currentY=0;
		t=new Timer(100,this);
		t.start();
	}
	
	public void actionPerformed (ActionEvent e)
	{
		if (currentY<=maxY)
		{
			repaint();
			currentY+=20;
		}
		else
		{
			t.stop();
         if (stageNum<4)
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
	            //add death message to main panel
	            game.pane.add(new LongMessage("PlayerWin",1000,600,game),BorderLayout.CENTER);
	            game.pack();
         }
		}
	}
	
	
	public void paintComponent (Graphics g)
	{
		Font text = new Font ("SansSerif", Font.BOLD, 40);
		g.setFont(text);
		   
		g.fillRect(0,0,1000,currentY);
		g.setColor(Color.WHITE);
		g.drawString("STAGE "+stageNum, 400, currentY-300);
	}
}
