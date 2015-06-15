import java.awt.*;


public class Village extends Map
{
	private PlayGame game;
	
   //==============constructor=================
   public Village (String path,PlayGame playGame)
   {
      //use Map's constructor
      super (path,playGame.player);
      game=playGame;

   }
   
   //==============show method that paints village=================
   public void show (Graphics g)
   {
      //paint village
      g.drawImage(PlayGame.getImage("MapImage//Village.png"),0,0,null);
      game.player.showStats(g);
   }
}
