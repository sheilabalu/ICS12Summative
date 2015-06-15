import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public enum Type
{
	GHOST(			'g', "Ghost", 			10, 1, 0,  8,  25),
	MOUSE(			'm', "Mouse", 			35, 1,    0, 20, 35),
	MUSHROOM(		'M', "Mushroom",		25, 1,  0, 5,  35),
	PENGUIN(		'p', "Penguin", 		45, 1,  0, 12,  30),
	PIG(			'P', "Pig", 			64, 1,  0, 32, 25),
	SNAIL(			's', "Snail", 			25, 1,  0,  10,  30),
	SLIME(			'S', "Slime", 			10, 0, 	0, 7,  20),
	ZOMBIEMUSHROOM(	'z', "ZombieMushroom", 	15, 1,  0, 4,  35),
	DRAGON(			'D', "Dragon", 			255,10, 1,  42, 40),
	
	
	
//	SLIME('S', "Slime", 10, 0, 0.01, 4),
//	SPIDER('s', "Spider", 15, 0.05, 0.01, 6),
//	GRIFFIN('G', "Griffin", 123, 0.321, 0.075, 32),
//	DRAGON('D', "Dragon", 255, 0.42, 0.1, 42),
	
	BLANK(			'_', "Blank", 			0,  0,    0,   0,	0 );
	
	private final char chIdentifier;
	private int health;
	private final int attack, size;
	private final int armor, regenRate;
	private final String name;

	
	private Type(char c, String n, int hp, int arm, int reg, int atk, int s)
	{
		chIdentifier = c;
		name = n;
		health = hp;
		armor = arm;
		regenRate = reg;
		attack = atk;
		size = s;
		
	}
	
	
	public static Type parse(char c){
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
		
//		case 's':	return SPIDER;
//		case 'D':	return DRAGON;
//		case 'G':	return GRIFFIN;
				
		default:	return BLANK;
		}		
	}


	public int getHealth()
	{
		return health;
	}
	
	public int getArmor()
	{
		return armor;
	}
	
	public int getRegenRate() 
	{
		return regenRate;
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public int getSize() 
	{
		return size;
	}
	
	public int hurt (Player player)
	{
		if (player.getAttack()>armor)
		{
			health+=armor-player.getAttack();
			return armor-player.getAttack();
		}
		return 0;
	}

}
