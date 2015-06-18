import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Type
{	
	private final char chIdentifier;
	private int health,x,y,damage;
	private final int attack, size,exp;
	private final int armor, regenRate;
	private final String name;
	private boolean faceRight,isAlive,deadGraphics;

	//==================constructor======================
	public Type(char c, String n, int hp, int arm, int reg, int atk, int s,int x_Value,int y_Value,int experience)
	{
		chIdentifier = c;
		name = n;
		health = hp;
		armor = arm;
		regenRate = reg;
		attack = atk;
		size = s;
		x=x_Value;
		y=y_Value;
		faceRight=false;
		exp=experience;
		isAlive=true;
		deadGraphics=false;
		damage=0;
	}

	
	//============getX method===========
    public int getX ()
	{
		return x;
	}
		
	//============getY method===========
	public int getY ()
	{
		return y;
	}
	
	//==========setX method===============
	public void setX (int newX)
	{
		x=newX;
	}
	
	//==========setY method===============
	public void setY(int newY)
	{
		y=newY;
	}
	
	//==============getDeadGraphics method==============
	public boolean getDeadGrahpics ()
	{
		return deadGraphics;
	}
	
	//==============getExp method=================
	public int getExp ()
	{
		return exp;
	}
	
	//============getFaceRight method===========
	public boolean getfaceRight ()
	{
		return faceRight;
	}
	
	//===========setfaceRight method===========
	public void setfaceRight (boolean right)
	{
		faceRight=right;
	}
	
	//============getHealth method==============
	public int getHealth()
	{
		return health;
	}
	
	//==========getArmor method===============
	public int getArmor()
	{
		return armor;
	}
	
	//==============getRegenRate method==============
	public int getRegenRate() 
	{
		return regenRate;
	}
	
	//==============getName method================
	public String getName ()
	{
		return name;
	}
	
    //===============setDamage method============
    public void setDamage (int d)
    {
    	damage=d;
    }
	
	//=================getAttack method==============
	public int getAttack()
	{
		return attack;
	}
	
	//===============getSize method=============
	public int getSize() 
	{
		return size;
	}
	
	//================loseHealth method=========
	public int loseHealth (int loss) //called when type is hurt by player
	{
		if (loss>armor)
		{
			health+=armor-loss;
			damage=armor-loss;
		}
		else
		{
			damage=0;
		}
		if(health<=0)
			{
				isAlive=false;
				return exp;
			}
		return 0;
	}
	
	//==============show method which paints Type==========
	public void show (Graphics g)
	{
		if (isAlive) //is Type alive
		{
			if (faceRight) //draws image depending on orientation of Type
				g.drawImage(PlayGame.getImage("Monsters//"+name+"_Move_Right.png"), x*50,600-y*50,null);
			else
				g.drawImage(PlayGame.getImage("Monsters//"+name+"_Move_Left.png"), x*50,600-y*50,null);	
		}
		else 
		{	//draws dead graphics
			g.drawImage(PlayGame.getImage("Monsters//"+name+"_Die.png"), x*50,600-y*50,null);
			deadGraphics=true;
		}
		if (damage!=0)
		{
			g.setColor(Color.GREEN);
			Font text = new Font ("SansSerif", Font.BOLD, 20);
			g.setFont(text);
	        g.drawString (""+damage,x*50+30,600-(y*50+20));
		}
		
	}

}
/*GHOST(			'g', "Ghost", 			10, 1, 0,  8,  25),
MOUSE(			'm', "Mouse", 			35, 1,    0, 20, 35),
MUSHROOM(		'M', "Mushroom",		25, 1,  0, 5,  35),
PENGUIN(		'p', "Penguin", 		45, 1,  0, 12,  30),
PIG(			'P', "Pig", 			64, 1,  0, 32, 25),
SNAIL(			's', "Snail", 			25, 1,  0,  10,  30),
SLIME(			'S', "Slime", 			10, 0, 	0, 7,  20),
ZOMBIEMUSHROOM(	'z', "ZombieMushroom", 	15, 1,  0, 4,  35),
DRAGON(			'D', "Dragon", 			255,10, 1,  42, 40),*/



//SLIME('S', "Slime", 10, 0, 0.01, 4),
//SPIDER('s', "Spider", 15, 0.05, 0.01, 6),
//GRIFFIN('G', "Griffin", 123, 0.321, 0.075, 32),
//DRAGON('D', "Dragon", 255, 0.42, 0.1, 42),

//BLANK(			'_', "Blank", 			0,  0,    0,   0,	0 );

/*public static Type parse(char c){
switch(c)
{
case 'g':	return GHOST;
case 'm':	return MOUSE;
case 'M':	return MUSHROOM;
case 'p':	return PENGUIN;
case 'P':	return PIG;
case 'S':	return SLIME;
case 's':	return SNAIL;
case 'z':	return ZOMBIEMUSHROOM;

//case 's':	return SPIDER;
//case 'D':	return DRAGON;
//case 'G':	return GRIFFIN;
		
default:	return BLANK;
}		
}*/