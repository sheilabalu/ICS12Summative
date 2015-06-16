import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//assists in drawing map
public enum stageImage {
	SPACE("Space"),
	GRASSFLOOR("GrassFloor"),
	FLOAT("Float"),
	NOGRASSFLOOR("NoGrassFloor");
	
	private BufferedImage img;
	
	//===========constructor===============
	private stageImage (String name)
	{
		try {
			img = ImageIO.read (new File ("MapImage//"+name+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//==============parseImg method==================
	public static BufferedImage parseImg(char c)  //draws based on char given in Map class
	{
		switch(c){
		case ' ':	return SPACE.getImg();
		case 'g':	return GRASSFLOOR.getImg();
		case 'f':	return FLOAT.getImg();
		case 'n':	return NOGRASSFLOOR.getImg();
		default:	return SPACE.getImg();
		}
	}
	public BufferedImage getImg(){return img;}
}
