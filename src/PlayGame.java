import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class PlayGame extends JFrame
{
	public Container pane = getContentPane ();
	public Map map1;
	public PlayGame ()
	{
		pane.setPreferredSize(new Dimension(1000,600));
		DrawBoard drawboard= new DrawBoard (1000,600);
		pane.setLayout(new BorderLayout());
		map1=new Map ("Map2");
		//drawboard.repaint();
		pane.add(drawboard);
	}

	public class DrawBoard extends JPanel
	{
		public DrawBoard (int x, int y)
		{
			super ();
			setPreferredSize(new Dimension(x,y));
		}

		public void paintComponent (Graphics g)
		{
			map1.show(g);
		}
	}
	public static void main (String[] args)
	{
		PlayGame playGame = new PlayGame ();
		playGame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		playGame.pack ();
		playGame.setVisible (true);
	}
}