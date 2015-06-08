import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;

public class Village extends Map
{
   //==============constructor=================
   public Village (String path)
   {
      //use Map's constructor
      super (path);
   }
   
   //==============show method that paints village=================
   public void show (Graphics g)
   {
      //paint village
      g.drawImage(PlayGame.getImage("MapImage//Village.png"),0,0,null);
   }
}
