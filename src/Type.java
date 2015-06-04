import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public enum Type
{
	GHOST(			'g', "Ghost", 			10, 0.75, 0.2,  8,  25),
	MOUSE(			'm', "Mouse", 			35, 0,    0.01, 20, 35),
	MUSHROOM(		'M', "Mushroom",		25, 0.2,  0.07, 5,  35),
	PENGUIN(		'p', "Penguin", 		45, 0.3,  0.03, 12,  30),
	PIG(			'P', "Pig", 			64, 0.4,  0.04, 32, 25),
	SNAIL(			's', "Snail", 			25, 0.1,  0.3,  10,  30),
	SLIME(			'S', "Slime", 			10, 0, 	  0.01, 7,  20),
	ZOMBIEMUSHROOM(	'z', "ZombieMushroom", 	15, 0.1,  0.25, 4,  35),
	DRAGON(			'D', "Dragon", 			255,0.42, 0.1,  42, 40),
	
	
	
//	SLIME('S', "Slime", 10, 0, 0.01, 4),
//	SPIDER('s', "Spider", 15, 0.05, 0.01, 6),
//	GRIFFIN('G', "Griffin", 123, 0.321, 0.075, 32),
//	DRAGON('D', "Dragon", 255, 0.42, 0.1, 42),
	
	BLANK(			'_', "Blank", 			0,  0,    0,   0,	0 );
	
	private final char chIdentifier;
	private final int health, attack, size;
	private final double armor, regenRate;
	private final String name;
	private final BufferedImage[] bi = new BufferedImage[6];
	
	private Type(char c, String n, int hp, double arm, double reg, int atk, int s)
	{
		chIdentifier = c;
		name = n;
		health = hp;
		armor = arm;
		regenRate = reg;
		attack = atk;
		size = s;
		
		try {
			bi[0] = ImageIO.read (new File ("MonsterImage/"+name+"_MoveL.png"));
			bi[1] = ImageIO.read (new File ("MonsterImage/"+name+"_HitL.png"));
			bi[2] = ImageIO.read (new File ("MonsterImage/"+name+"_DieL.png"));
			bi[3] = ImageIO.read (new File ("MonsterImage/"+name+"_MoveR.png"));
			bi[4] = ImageIO.read (new File ("MonsterImage/"+name+"_HitR.png"));
			bi[5] = ImageIO.read (new File ("MonsterImage/"+name+"_DieR.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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


	public int getInitHealth(){return health;}
	public double getInitArmor(){return armor;}
	public double getInitRegenRate() {return regenRate;}
	public double getAttack(){return attack;}
	public BufferedImage getImg(int i){return bi[i];}
	public int getSize() {return size;}

}
