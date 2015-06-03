
public class Life
{
	private int health, attack, x, y, w, h;
	private Type me;
	private double armor, regenRate;
	
	public Life(char c, int posx, int posy)
	{
		me = Type.parse(c);
		health = (int)(me.getInitHealth()*(Math.random()/5+0.9));
		armor = (me.getInitArmor()*(Math.random()/5+0.9));
		regenRate = (me.getInitRegenRate()*(Math.random()/5+0.9));
		attack = (int)(me.getAttack()*(Math.random()/5+0.9));
		
		x = posx;
		y = posy;
		w = me.getWidth();
		h = me.getHeight();
	}
	
	
	
	
	public void hurt(int attack){health-=((int)(attack*(1-armor)));}
	public void regen(){health+=((int)(Math.random()*me.getInitHealth()*regenRate));}
	public int attack(){return (int)(attack*(Math.random()/2+0.75));}
}
/*
if(health <= 0)
	.remove(i);

 */