import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Map
{
	private char[][] map;
	private BufferedImage mapImage;
	private Scanner s;
	//	private ArrayList<Thread> Th = new ArrayList<Thread>(0);
	//	private ArrayList<RunnableMonster> Rm = new ArrayList<RunnableMonster>(0);
	private ArrayList<Life> monsters = new ArrayList<Life>(0);

	private ArrayList<MonsterThread> MstrTh = new ArrayList<MonsterThread>(0);

	public Map (String path)
	{
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

		try{
			s = new Scanner(new File("Mtxt/"+path+".txt"));
		}catch(FileNotFoundException e){
			System.out.println("monster list named \""+path+".txt\" not found.");
		}
		nextWave();
	}

	public boolean nextWave()
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
	}

	//method to draw map
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

				for(int i = 0 ; i < monsters.size() ; i++){
					monsters.get(i).drawImg(g);
				}
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

	public char getMap(int y, int x) {return map[y][x];}
}


//public Map (String path)
//{
//	String line;
//	s = null;
//
//	try{
//		s = new Scanner(new File("txt/"+path+".txt"));
//	}catch(FileNotFoundException e){
//		System.out.println("Map named \""+path+".txt\" not found.");
//	}
//
//	map = new char[12][20];
//
//	for(int i = 0; i < map.length; i++){
//		line = s.nextLine();
//		for(int j = 0; j < map[0].length; j++){
//			map[i][j] = line.charAt(j);
//		}
//	}
//
//	try{
//		s = new Scanner(new File("Mtxt/"+path+".txt"));
//	}catch(FileNotFoundException e){
//		System.out.println("monster list named \""+path+".txt\" not found.");
//	}
//}
//
//public boolean nextWave()
//{
//	if(s.hasNextLine() == false)
//		return false;
//	String mStr = s.nextLine();
//	for(int i = 0 ; i < mStr.length() ; i++){
//		monsters.add(new Life(mStr.charAt(i), 975 + 50*i, 545));
//		//			Rm.add(new RunnableMonster(monsters.get(i)));
//		//			Th.add(new Thread(Rm.get(i)));
//		//			Th.get(i).start();
//		MstrTh.add(new MonsterThread(monsters.get(i)));
//		MstrTh.get(i).start();
//	}
//	return true;
//}
//
////	public void tick()
////	{
////		for(int i = 0 ; i < monsters.size() ; i++)
////			monsters.get(i).tick();
////	}
//
//public void show (Graphics g)
//{
//	char id = ' ';
//
//	//goes through array
//	for (int row=0;row<map.length;row++){
//		for (int col=0;col<map[0].length;col++){
//			//if space
//			if (map[row][col]==' ')
//				id = ' ';
//			//if it is not row 0 and the grid above it is also wall
//			else if (map[row][col]=='W')
//			{
//				if (row==0)
//					id = 'g';
//				//if the grid above it is not wall
//				else if (map[row-1][col]!='W')
//					id = 'g';
//				//if it is not the last row 
//				else if (row!=map.length-1)
//				{
//					//if the grid below it is not wall
//					if (map[row+1][col]!='W')
//						id = 'f';
//					else 
//						id = 'n';
//				}
//				else 
//					id = 'n';
//			}
//			g.drawImage(stageImage.parseImg(id),col*50, row*50, null);
//
//			for(int i = 0 ; i < monsters.size() ; i++){
//				monsters.get(i).drawImg(g);
//			}
//		}
//	}
//}
//}
=======
}

//	public Map (String path)
//	{
//		map= new char[12][20];
//		try
//		{
//			File file= new File ("txt//"+path+".txt");
//			FileReader reader= new FileReader(file);
//			//read file into 1D array
//			char[] chars = new char[(int) file.length()];
//			reader.read(chars);
//
//			//int to keep track of chars [] index
//			int charsIndex=0;
//
//			//read into 2-D array
//			for (int row=0;row<map.length;row++)
//			{
//				for (int col=0;col<map[0].length;col++)
//				{
//					map[row][col]=chars[charsIndex];
//					charsIndex++;
//				}
//
//			}
//			reader.close();
//		} catch (Exception e){}
//	}

//method to draw map
//	public void show (Graphics g)
//	{
//		String path=null;
//		//goes through array
//		for (int row=0;row<map.length;row++)
//		{
//			for (int col=0;col<map[0].length;col++)
//			{
//				//if space
//				if (map[row][col]==' ')
//					path="Space.png";
//				//if it is not row 0 and the grid above it is also wall
//				else if (map[row][col]=='W')
//				{
//					if (row==0)
//						path="GrassFloor.png";
//					//if the grid above it is not wall
//					else if (map[row-1][col]!='W')
//						path="GrassFloor.png";
//					//if it is not the last row 
//					else if (row!=map.length-1)
//					{
//						//if the grid below it is not wall
//						if (map[row+1][col]!='W')
//							path="Float.png";
//						else 
//							path="NoGrassFloor.png";
//					}
//					else 
//						path= "NoGrassFloor.png";
//				}
//				g.drawImage(getImage(path),col*50, row*50, null);
//			}
//
//		}	
//	}

//	//method to retrieve image
//	public static BufferedImage getImage (String path)
//	{
//		BufferedImage image = null;
//		try
//		{
//			image = ImageIO.read (new File ("MapImage//"+path));
//		}catch (Exception e){}
//		return image;
//	}
}
>>>>>>> origin/master
