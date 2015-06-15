import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

//==============DrawBoard Class=================
  	public class DrawBoard extends JPanel implements KeyListener
	{
  		public Map map;
  		public Player me;
  		public PlayGame game;
  		public int mapNum;
  		
		public DrawBoard (int x, int y,PlayGame g, int mapLevel)
		{
			//super ();
			game=g;
			me=game.player;
			mapNum=mapLevel;
			map= new Map ("Map"+mapNum,me);
			setPreferredSize(new Dimension(x,y));
			//System.out.println("KeyListener is added");
			this.addKeyListener(this);
			 this.setFocusable(true);
	         this.requestFocusInWindow();
	         requestFocus();
		}
		
		public void keyTyped(KeyEvent e) {}

		public void keyPressed(KeyEvent e) 
		{
			System.out.println("key is pressed");
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_LEFT)
			{
				System.out.print("left");
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
			{
				me.setStatus(2);
				map.hitMonster();
			}
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
			map.hitPlayer();
			if (me.getHealth()<=0)
			{
				//Get rid of everything on screen
	            game.pane.removeAll();
	            //add death message to main panel
	            game.pane.add(new LongMessage("PlayerDeath",1000,600,game),BorderLayout.CENTER);
	            game.pack();
			}
			
			if (map.monsterNum()==0)
			{
				mapNum++;
				//Get rid of everything on screen
	            game.pane.removeAll();
	            //add death message to main panel
	            game.pane.add(new StageTransition(mapNum,1000,600,game),BorderLayout.CENTER);
	            game.pack();
			}
		}

		public void keyReleased(KeyEvent e) {}

		public boolean isFocusTraversable()
		{
			return true;
		}

		
		public void paintComponent (Graphics g)
		{
         super.paintComponent(g);
         map.show(g);
         map.showMonsters(g);
         game.player.show(g);
		}
		
	}