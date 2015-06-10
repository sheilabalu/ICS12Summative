import java.awt.*;


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
