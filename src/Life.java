import java.awt.Graphics;


public class Life
{
	/*private int health, attack, x, y, s, pic = 0;
	private Type me;
	private double armor, regenRate;
	
	public Life(char c, int posx, int posy)
	{
		me = Type.parse(c);
		health = (int)(me.getInitHealth()*(Math.random()/5+0.9));
		armor = (me.getInitArmor()*(Math.random()/5+0.9));
		regenRate = (me.getInitRegenRate()*(Math.random()/5+0.9));
		attack = (int)(me.getAttack()*(Math.random()/5+0.9));
		
		s = me.getSize();
		x = posx - s/2;
		y = posy - s/2;
	}
	public Life(char c)
	{
		me = Type.parse(c);
		health = (int)(me.getInitHealth()*(Math.random()/5+0.9));
		armor = (me.getInitArmor()*(Math.random()/5+0.9));
		regenRate = (me.getInitRegenRate()*(Math.random()/5+0.9));
		attack = (int)(me.getAttack()*(Math.random()/5+0.9));
		
		x = 75;
		y = 75;
		s = me.getSize();
	}
	
	public void move(){};
	public void drawImg(Graphics g){g.drawImage(me.getImg(pic), x, y, s-1, s-1, null);}
	public void hurt(int attack){health-=((int)(attack*(1-armor)));}
	public void regen(){health+=((int)(Math.random()*me.getInitHealth()*regenRate));}
	public int attack(){return (int)(attack*(Math.random()/2+0.75));}
	public int getHealth(){return health;}
}
/*
if(health <= 0)
	.remove(i);*/
}