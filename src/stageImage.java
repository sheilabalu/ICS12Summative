import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public enum stageImage {
	SPACE("Space"),
	GRASSFLOOR("GrassFloor"),
	FLOAT("Float"),
	NOGRASSFLOOR("NoGrassFloor");
	
	private BufferedImage img;
	
	private stageImage (String name)
	{
		try {
			img = ImageIO.read (new File ("MapImage//"+name+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static BufferedImage parseImg(char c)
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
