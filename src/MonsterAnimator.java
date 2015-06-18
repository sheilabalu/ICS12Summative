import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;

public class MonsterAnimator extends Thread {
	
	private Map map;
	private DrawBoard drawBoard;
	private Timer t;
	private ArrayList<Type> monsters;
	private final boolean [] move={false,true,true,false};
	private int [] moveIndex;
	
	public MonsterAnimator(DrawBoard board)
	{
		super();
		map=board.map;
		drawBoard=board;
		monsters=map.getMonster();
		t= new Timer (800,new MonsterListener());
		moveIndex=new int[4];
		for (int k=0;k<4;k++)
			moveIndex[k]=0;
	}
	
	public void run ()
	{
		t.start();
	}
	
	public class MonsterListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			if (monsters.size()!=0)
			{
				for (int k=0;k<monsters.size();k++)
				{
					Type monster= monsters.get(k);
					//error trap moveIndex
					if (moveIndex[k]>=4)
						moveIndex[k]=0;
					
					//set monster's orientation as indicated in the move array
					monster.setfaceRight(move[moveIndex[k]]);
					if (move[moveIndex[k]])
					{
						monster.setX(monster.getX()+1); //monster moves right
					}
					else
					{
						monster.setX(monster.getX()-1); //monster moves left
					}
					
					//shift index of move array 
					moveIndex[k]++;
					monster.setDamage(0); //reset damage
					map.hitPlayer(); //monsters hit player
					drawBoard.repaint(); //repaint graphics
					
					if (drawBoard.me.getHealth()<=0) //if player dies
					{
						//Get rid of everything on screen
						drawBoard.game.pane.removeAll();
			            //add death message to main panel
						drawBoard.game.pane.add(new LongMessage("PlayerDeath",1000,600,drawBoard.game),BorderLayout.CENTER);
						drawBoard.game.pack();
						t.stop(); //stop timer
					}
				}
			}
			else
				t.stop();
		}
	}
	
	

}
