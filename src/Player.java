import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Player
{
    private int health, attack, x, y, status,level,exp,maxHealth, damage; //0=standing, 1=walking, 2=attacking, 3=jumping
    private int armor, regenRate;
    private String name;
    private boolean faceRight, foot, hasWeapon;
    public BufferedImage myImage;
    String path = null;
    private final int[] expNeeded= new int [10];

    //=============Constructor============
    public Player (String n)
    {
    	//initialize variables 
        name = n;
        level=1;
        health = 50;
        maxHealth=50;
        armor = 5;
        regenRate = 5;
        attack = 10;
        faceRight = true;
        status = 0;
        x = 1;
        y = 5;
        exp=0;
        foot = true;
        damage=0;
        
        //set experience needed to level up
        expNeeded[0]=200;
        for (int k=1;k<expNeeded.length;k++)
        	expNeeded[k]=expNeeded[k-1]+50;
     }
    
    //=========levelUp method=========
    public void levelUp ()
    {
    		level++;
    		exp=0;
    		maxHealth+=20;
    		health=maxHealth;
    		attack+=10;
    		armor+=5;
    		Sound effect= new Sound("LevelUp.wav");
    		effect.start();
    }
	
	//================getHealth method===============
	public int getHealth ()
	{
		return health;
	}
	

    //==========gainExp method=========
    public void gainExp (int gain)
    {
    	exp+=gain;
    	//determines if user levels up or not
    	if (level<10&&exp>=expNeeded[level-1])
    	{
    		levelUp();
    	}
    }

  //=============getFoot method============
    public boolean getFoot ()
    {
        return foot;
    }
    
    //===============setDamage method============
    public void setDamage (int d)
    {
    	damage=d;
    }
    
    //=============getFaceRight method============
    public boolean getFaceRight ()
    {
    	return faceRight;
    }

  //=============setFaceRight method============
    public void setFaceRight (boolean direction)
    {
        faceRight = direction;
    }

  //=============setFoot method============
    public void setFoot (boolean inputFoot)
    {
        foot = inputFoot;
    }

  //=============setStatus method============
    public void setStatus (int inputStatus)
    {
        status = inputStatus;
    }

  //=============setX method============
    public void setX (int myX)
    {
        x = myX;
    }
    
  //=============getX method============
    public int getX ()
    {
        return x;
    }
    
  //=============getY method============
    public int getY ()
    {
        return y;
    }

  //=============moveRight method============
    public void moveRight ()
    {
        x++;
    }

  //=============setY method============
    public void setY (int myY)
    {
        y = myY;
    }

  //=============moveLeft method============
    public void moveLeft ()
    {
        x--;
    }

  //=============moveUp method============
    public void moveUp ()
    {
        y++;
    }

  //=============moveDown method============
    public void moveDown ()
    {
        y--;
    }
    
  //=============getAttack method=========
    public int getAttack ()
    {
    	return attack;
    }
    
    //============loseHealth method===========
    public void loseHealth (int loss)
    {
    	if (loss>armor) //if monster's attack is greater than player's armor
    	{
    		health+=armor-loss;
    		damage=armor-loss;
    	}
    	else
    		damage=0;
    }

  //=============show method that draws player============
    public void show (Graphics g)
    {
    	if (status == 0) //if standing
        {
            if (faceRight == true) 
            {
                path = "Player_Stand_Right"; 
            }

            else if (faceRight == false)
            {
                path = "Player_Stand_Left";
            }
            path = "No Weapon//" + path;
        }
        else if (status == 1) //if walking
        {
            if (faceRight == true)
            {
                if (foot == true) //is foot out
                {
                    path = "Player_Walk1_Right";
                }
                else
                {
                    path = "Player_Walk3_Right";
                }
            }

            else if (faceRight == false) 
            {
                if (foot == true)
                {
                    path = "Player_Walk1_Left";
                }
                else
                {
                    path = "Player_Walk3_Left";
                }
            }
            path = "No Weapon//" + path;
        }
        else if (status == 2) //if attacking
        {
        	if (faceRight==true)
        	{
        		path = "Player_Stab1_Right";
        	}
        	else
        		path="Player_Stab1_Left";
            path = "Weapon//" + path;
        }
        g.drawImage (PlayGame.getImage ("Player//"+path+".png"), x * 50, 600 - (y*50), null);
        if (damage!=0)
        {
        	g.setColor(Color.RED);
        	Font text = new Font ("SansSerif", Font.BOLD, 20);
     	   g.setFont(text);
        	g.drawString (""+damage,x*50+30,600-(y*50+20));
        }
    }
    
    //==============showStats method================
    public void showStats (Graphics g)
    {
    	int healthBar, expBar;
    	//determines length of health and exp bar
    	healthBar=(int)(1.0*health/maxHealth*150);
    	expBar= (int)(1.0*exp/expNeeded[level-1]*150);
    	
    	Font text = new Font ("SansSerif", Font.BOLD, 16);
 	    g.setFont(text);
 	    //draw player info
    	g.drawString("Level "+level+" Warrior:"+name, 10, 16);
		g.drawString("Health: "+health+"/"+maxHealth, 120, 35);
		g.drawString("Exp: "+exp+"/"+expNeeded[level-1], 120, 85);
		//outline for exp and hp bar
		g.fillRect(118,48,154,14);
		g.fillRect(118, 98, 154, 14);
		//fill hp bar and exp bar
		g.fillRect(120+healthBar,50, 150-healthBar, 10);
		g.fillRect(120+expBar, 100, 150-expBar, 10);
		g.setColor(Color.RED);
		g.fillRect(120, 50,healthBar, 10);
		g.setColor(Color.YELLOW);
		g.fillRect(120, 100, expBar, 10);
		
		//draws profile pic of player
		g.drawImage(PlayGame.getImage("Player//profile.png"), 10, 25, null);
    }

}

