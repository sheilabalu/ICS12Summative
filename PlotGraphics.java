import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class PlotGraphics 
{
   private Scanner s;
   
   //===========constructor=========
   public PlotGraphics ()
   {
      //initialize scanner to null
      s=null;
   }
   
   //method to display long messages on black screen
   public void long_Message (String path, Graphics g)
   {
      String line;
		s = null;
      int y=20;
      
      //set Scanner to file path
		try
      {
			s = new Scanner(new File("txt/"+path+".txt"));
		}
      catch(Exception e)
      {
		}

      //draw a black screen
      g.setColor(Color.BLACK);
      g.drawRect(0,0,1000,600);

      //set color to be white
      g.setColor(Color.WHITE);
      //draw message 
		while (s.hasNextLine())
      {
			line = s.nextLine();
         g.drawString(line,20,y);
         //shift next line down
         y+=20;
		}
   }
}