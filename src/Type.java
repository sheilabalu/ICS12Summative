
public enum Type
{
	GHOST('g', "Ghost", 10, 0.75, .2, 5),
	MOUSE('m', "Mouse", 35, 0, 0.01, 10),
	MUSHROOM('M', "Mushroom", 25, 0.2, 0.07, 3),
	PENGUIN('p', "Penguin", 45, 0.3, 0.03, 7),
	PIG('P', "Pig", 64, 0.4, 0.04, 16),
	SLIME('S', "Slime", 10, 0, 0.01, 4),
	SNAIL('s', "Snail", 25, 0.1, 0.3, 6),
	ZOMBIEMUSHROOM('z', "ZombieMushroom", 15, 0.1, 0.25, 2),
	
	
	
//	SLIME('S', "Slime", 10, 0, 0.01, 4),
//	SPIDER('s', "Spider", 15, 0.05, 0.01, 6),
//	GRIFFIN('G', "Griffin", 123, 0.321, 0.075, 32),
//	DRAGON('D', "Dragon", 255, 0.42, 0.1, 42),
	
	BLANK('_', "Blank", 0, 0, 0, 0);
	
	private final char chIdentifier;
	private final int health, attack;
	private final double armor, regenRate;
	private final String name;
	
	private Type(char c, String n, int hp, double arm, double reg, int atk)
	{
		chIdentifier = c;
		name = n;
		health = hp;
		armor = arm;
		regenRate = reg;
		attack = atk;
		
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
}
