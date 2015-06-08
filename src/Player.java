import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.*;
import javax.imageio.ImageIO;


public class Player
{	
	private int health, attack, x, y, status; //0=standing, 1=walking, 2=attacking, 3=jumping
	private double armor, regenRate;
	private String name;
	private boolean faceRight , foot; 
	public BufferedImage myImage;
	String path = null;
	
	public Player (String n, int hp, double arm, double reg, int atk)
	{
		name = n;
		health = hp;
		armor = arm;
		regenRate = reg;
		attack = atk;
		faceRight = true;
		status = 0;
		x=0;
		y=0;
		foot = true;
	}
	
	public void setFaceRight(boolean direction)
	{
		faceRight = direction;
	}
	
	public void setFoot(boolean inputFoot)
	{
		foot = inputFoot;
	}
	public void setStatus(int inputStatus)
	{
		status = inputStatus;
	}

	public void show(Graphics g)
	{
		if(status == 0)
		{
			if(faceRight = true)
			{
				path = "Player_Stand"; //fix		
			}
			
			else
			{
				path = "Player_Stand";
			}
			path = "No Weapon//" + path;
		}
		else if (status == 1)
		{
			if(faceRight = true)
			{
				if(foot == true)
				{
					path = "Player_Walk1";
				}
				else
				{
					path = "Player_Walk3";
				}
			}
			
			else //fix
			{
				if(foot == true)
				{
					path = "Player_Walk1";
				}
				else
				{
					path = "Player_Walk3";
				}
			}			
			path = "No Weapon//" + path;
		}
		else if (status == 2)
		{
			path = "Player_Stab1";
			path = "Weapon//" + path;
		}
		g.drawImage(getImage(path),x*10, y*10, null);
	}
	
	public static BufferedImage getImage (String path)
    {
		BufferedImage image = null;
		try
		{
	 	   image = ImageIO.read (new File ("Player//"+path+".png"));
		}

		catch (Exception e)
		{
			System.out.println("Cannot Open File");
		} 
		return image;
	}    
}

