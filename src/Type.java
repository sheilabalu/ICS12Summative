
public enum Type
{
	SLIME('S', "Slime", 10, 0, 0.01, 4),
	SPIDER('s', "Spider", 15, 0.05, 0.01, 6),
	GRIFFIN('G', "Griffin", 123, 0.321, 0.075, 32),
	DRAGON('D', "Dragon", 255, 0.42, 0.1, 42),
	
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
		case 'S':	return SLIME;
		case 's':	return SPIDER;
		case 'D':	return DRAGON;
		case 'G':	return GRIFFIN;
				
		default:	return BLANK;
		}		
	}


	public int getInitHealth(){return health;}
	public double getInitArmor(){return armor;}
	public double getInitRegenRate() {return regenRate;}
	public double getAttack(){return attack;}
}
