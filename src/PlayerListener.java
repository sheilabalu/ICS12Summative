import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class PlayerListener implements KeyListener {
	
	private Player me;
	private Map map;
	
	//==========constructor==========
	public PlayerListener (Player p, Map m)
	{
		super();
		me=p;
		map=m;
	}
	
	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) 
	{
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
	}

	public void keyReleased(KeyEvent e) {}

	public boolean isFocusTraversable()
	{
		return true;
	}

}
