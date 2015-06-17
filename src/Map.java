import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Map
{
	private char[][] map;
	private BufferedImage mapImage;
	private Scanner s;
	private ArrayList<Type> monsters = new ArrayList<Type>();
	private Player player;
	private ArrayList<MonsterThread> MstrTh = new ArrayList<MonsterThread>(0);

	public Map (String path,Player p)
	{
		player=p;
		map= new char[12][20];
		try
		{
			File file= new File ("txt//"+path+".txt");
			FileReader reader= new FileReader(file);
			//read file into 1D array
			char[] chars = new char[(int) file.length()];
			reader.read(chars);

			//int to keep track of chars [] index
			int charsIndex=0;

			//read into 2-D array
			for (int row=0;row<map.length;row++)
			{
				for (int col=0;col<map[0].length;col++)
				{
					map[row][col]=chars[charsIndex];
					charsIndex++;
				}

			}
			reader.close();
		}
		catch (Exception e){}

		//try to read monsters, not fully developed yet
		try{
			s = new Scanner(new File("Mtxt/"+path+".txt"));
		}catch(FileNotFoundException e){
			System.out.println("monster list named \""+path+".txt\" not found.");
		}

		
		//assigns monster distribution 
		if (path.equals("Map1"))
		{
			player.setY(5);
			player.setX(0);
			monsters.add(new Type('S', "Slime", 			20, 0, 	0, 7,  20,12,2,100));
			monsters.add(new Type('S', "Slime", 			20, 0, 	0, 7,  20,8,2,100));
			monsters.add(new Type('S', "Slime", 			20, 0, 	0, 7,  20,9,2,100));
		}
		
		else if (path.equals("Map2"))
		{
			player.setY(4);
			player.setX(1);
			monsters.add(new Type(		'M', "Mushroom",			20, 3, 	0, 15,  20,5,4,100));
			monsters.add(new Type(		'M', "Mushroom",			20, 3, 	0, 15,  20,8,4,100));
			monsters.add(new Type(		'M', "Mushroom",			20, 3, 	0, 15,  20,9,4,100));
		}
		
		else if (path.equals("Map3"))
		{
			player.setY(9);
			player.setX(1);
			monsters.add(new Type(			's', "Snail",			30, 0, 	0, 23,  20,5,9,100));
			monsters.add(new Type(			's', "Snail",			30, 0, 	0, 23,  20,8,8,100));
			monsters.add(new Type(			's', "Snail",			30, 0, 	0, 23,  20,12,7,100));
		}
		
		else if (path.equals("Map4"))
		{
			player.setY(4);
			player.setX(1);
			monsters.add(new Type(			'g', "Ghost", 				45, 0, 	0, 25,  20,5,5,100));
			monsters.add(new Type(			'g', "Ghost", 				45, 0, 	0, 25,  20,8,7,100));
			monsters.add(new Type(			'g', "Ghost", 				45, 0, 	0, 25,  20,10,6,100));
			monsters.add(new Type(			'g', "Ghost", 				45, 0, 	0, 25,  20,12,5,100));
		}
		
		else if (path.equals("Map5"))
		{
			player.setY(6);
			player.setX(2);
			monsters.add(new Type(		'p', "Penguin", 				60, 0, 	0, 35,  20,4,5,150));
			monsters.add(new Type(		'p', "Penguin",  				60, 0, 	0, 35,  20,8,6,150));
			monsters.add(new Type(			'P', "Pig",				65, 0, 	0, 35,  20,9,6,150));
			monsters.add(new Type(			'P', "Pig",				65, 0, 	0, 35,  20,17,8,150));
		}
		
		else if (path.equals("Map6"))
		{
			player.setY(6);
			player.setX(1);
			monsters.add(new Type(	'z', "ZombieMushroom",				75, 0, 	0, 42,  20,4,5,150));
			monsters.add(new Type(	'z', "ZombieMushroom",	 				75, 0, 	0, 42,  20,8,5,150));
			monsters.add(new Type(	'z', "ZombieMushroom",				75, 0, 	0, 42,  20,9,5,150));
			monsters.add(new Type(	'z', "ZombieMushroom",				75, 0, 	0, 42,  20,16,6,150));
		}
		
		else if (path.equals("Map7"))
		{
			player.setY(7);
			player.setX(0);
			monsters.add(new Type(			'm', "Mouse", 				90, 0, 	0, 48,  20,5,7,150));
			monsters.add(new Type(			'm', "Mouse", 	 				90, 0, 	0, 48,  20,8,6,150));
			monsters.add(new Type(			'm', "Mouse", 				90, 0, 	0, 48,  20,11,5,150));
			monsters.add(new Type(			'm', "Mouse", 				90, 0, 	0, 48,  20,14,5,150));
		}
		
		else if (path.equals("Map8"))
		{
			player.setY(6);
			player.setX(0);
			monsters.add(new Type(			'D', "Dragon", 				250, 0, 	0, 50,  20,5,8,150));
		}
	}
	
	//================monsterNum method============
	public int monsterNum ()
	{
		return monsters.size();
	}
	
	//================getMonster method=============
	public ArrayList<Type> getMonster ()
	{
		return monsters;
	}
    

	/*public boolean nextWave()
	{
		if(s.hasNextLine() == false)
			return false;
		String mStr = s.nextLine();

		for(int i = 0 ; i < mStr.length() ; i++){
			monsters.add(new Life(mStr.charAt(i), 975 + 50*i, 545));
			//			Rm.add(new RunnableMonster(monsters.get(i)));
			//			Th.add(new Thread(Rm.get(i)));
			//			Th.get(i).start();
			MstrTh.add(new MonsterThread(monsters.get(i)));
			MstrTh.get(i).start();
		}
		return true;	
	}*/

	//============show method that draws map===========
	public void show (Graphics g)
	{
		String path=null;
		//goes through array
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 600);
		char id = ' ';		
		//goes through array
		for (int row=0;row<map.length;row++){
			for (int col=0;col<map[0].length;col++){
				//if space
				if (map[row][col]==' ')
					id = ' ';
				//if it is not row 0 and the grid above it is also wall
				else if (map[row][col]=='W')
				{
					if (row==0)
						id = 'g';
					//if the grid above it is not wall
					else if (map[row-1][col]!='W')
						id = 'g';
					//if it is not the last row 
					else if (row!=map.length-1)
					{
						//if the grid below it is not wall
						if (map[row+1][col]!='W')
							id = 'f';
						else 
							id = 'n';
					}
					else 
						id = 'n';
				}
				g.drawImage(stageImage.parseImg(id),col*50, row*50, null);

			}
			g.setColor(Color.BLACK);
			player.showStats(g);
		}

	}
	
	//============showMonsters method that displays monsters===========
	public void showMonsters (Graphics g)
	{
		for (int k=monsters.size()-1;k>=0;k--)
		{
			monsters.get(k).show(g);
			//if monster is dead and has shown deadGrahphics
			if (monsters.get(k).getDeadGrahpics())
				monsters.remove(k); //remove said monster
		}
	}
	
	//============hitPlayer method where monsters attack player===========
	public void hitPlayer ()
	{
		for (int k=0;k<monsters.size();k++)
		{
			Type type=monsters.get(k);
			int distance;
			if (type.getName().equals("Dragon"))
				distance=3;
			else 
				distance =1;
			//determines if monster is in close proximity to player
			if ((player.getX()==type.getX()+1||player.getX()==type.getX()-1||player.getX()==type.getX())&&(Math.abs(player.getY()-type.getY())<=distance))
				{
					player.loseHealth(monsters.get(k).getAttack()); //player gets hurt
					if (player.getX()==type.getX()+1)
							type.setfaceRight(true); //set orientation based on player
					else
							type.setfaceRight(false); //set orientation based on player
							
				}
		}
	}
	
	//============hitMonster method where player hits monster===========
	public void hitMonster ()
	{
		//goes through monster array
		for (int k=0;k<monsters.size();k++)
		{
			Type type= monsters.get(k);
			int distance;
			if (type.getName().equals("Dragon"))
				distance=3;
			else 
				distance =1;
			if (player.getFaceRight())
			{
				//determines if monster gets hit
				if ((type.getX()==player.getX()||type.getX()==player.getX()+1)&&(Math.abs(player.getY()-type.getY())<=distance))
				{
					player.gainExp(type.loseHealth(player.getAttack()));
					
				}
			}
			//determines if monster gets hit
			else if ((type.getX()==player.getX()||type.getX()==player.getX()-1)&&(Math.abs(player.getY()-type.getY())<=distance))
				{
					player.gainExp(type.loseHealth(player.getAttack()));
				}
		}
			
	}
	//method to retrieve image
	public static BufferedImage getImage (String path)
	{
		BufferedImage image = null;
		try
		{
			image = ImageIO.read (new File ("MapImage//"+path));
		}


		catch (Exception e)
		{
		}
		return image;
	}

	public char getMap(int y, int x) 
	{
		return map[y][x];
	}
}


