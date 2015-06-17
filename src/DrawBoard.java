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
  		public MonsterAnimator animate;
  		
  		//=============constructor==================
		public DrawBoard (int x, int y,PlayGame g, int mapLevel)
		{
			//initialize variables
			game=g;
			me=game.player;
			mapNum=mapLevel;
			map= new Map ("Map"+mapNum,me);
			
			//set panel size
			setPreferredSize(new Dimension(x,y));
			//initialize key listener
			this.addKeyListener(this);
			 this.setFocusable(true);
	         this.requestFocusInWindow();
	         requestFocus();
	         animate= new MonsterAnimator (this);	
	         animate.start();
	    }
		
		//============keyTyped method===========
		public void keyTyped(KeyEvent e) {}

		//============keyPressed method===========
		public void keyPressed(KeyEvent e) 
		{
			int keyCode = e.getKeyCode();
			//if user goes left
			if (keyCode == KeyEvent.VK_LEFT)
			{
				me.setStatus(1); //status to walking
				me.setFaceRight(false);
				me.setFoot(!(me.getFoot()));
				me.moveLeft();
			}
			//if user goes right
			else if (keyCode == KeyEvent.VK_RIGHT)
			{
				me.setStatus(1); //status to walking
				me.setFaceRight(true);
				me.setFoot(!(me.getFoot()));
				me.moveRight();
			}
			//if user moves up
			else if (keyCode == KeyEvent.VK_UP)
			{
				me.setStatus(0);
				me.moveUp();
			}
			//if user moves down
			else if (keyCode == KeyEvent.VK_DOWN)
			{
				me.setStatus(0);
				me.moveDown();
			}
			//if user attacks
			else if (keyCode == 65)
			{
				me.setStatus(2); //status to attack
				map.hitMonster(); //attacks monsters
				//play sword sound effect
				new Sound("Sword.wav").start();
			}
			try{ //v. strong gravity that prevents user from flying
				int gravity = me.getY();
				gravity--;

				while(map.getMap(12-gravity, me.getX()) != 'W' && gravity > 0)
				{
					gravity--;
				}
				
				me.setY(gravity+2);
			}
			catch (ArrayIndexOutOfBoundsException error){}
			repaint();
			
			if (me.getHealth()<=0) //if player dies
			{
				//Get rid of everything on screen
	            game.pane.removeAll();
	            //add death message to main panel
	            game.pane.add(new LongMessage("PlayerDeath",1000,600,game),BorderLayout.CENTER);
	            game.pack();
			}
			
			if (map.monsterNum()==0) //if all monsters in stage is defeated
			{
				mapNum++;
				//change player position to stand
				me.setStatus(0);
				//Get rid of everything on screen
	            game.pane.removeAll();
	            //load next stage
	            game.pane.add(new StageTransition(mapNum,1000,600,game),BorderLayout.CENTER);
	            game.pack();
			}
		}

		//============keyReleased method===========
		public void keyReleased(KeyEvent e) {}

		//============paintComponent method===========
		public void paintComponent (Graphics g)
		{
         super.paintComponent(g);
         map.show(g); 
         map.showMonsters(g);
         game.player.show(g);
		}
		
	}