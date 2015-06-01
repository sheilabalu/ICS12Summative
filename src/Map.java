import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.ArrayList;
import javax.swing.*;

public class Map
{
	private char[][] map;
	public BufferedImage mapImage;
	
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
		 catch (Exception e)
		 {
		 }
	}
	
	//method to draw map
	public void show (Graphics g)
	{
			String path=null;
			//goes through array
			for (int row=0;row<map.length;row++)
			{
				for (int col=0;col<map[0].length;col++)
				{
				 //if space
				  if (map[row][col]==' ')
				  path="Space.png";
				  //if it is not row 0 and the grid above it is also wall
				  else if (map[row][col]=='W')
				  {
				  	if (row==0)
						path="GrassFloor.png";
				  	//if the grid above it is not wall
				  	else if (map[row-1][col]!='W')
				  	path="GrassFloor.png";
				  	//if it is not the last row 
				  	else if (row!=map.length-1)
				  	{
							//if the grid below it is not wall
							if (map[row+1][col]!='W')
							path="Float.png";
							else 
							path="NoGrassFloor.png";
				  	}
					else 
					path= "NoGrassFloor.png";
				  }
				  g.drawImage(getImage(path),col*50, row*50, null);
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
}