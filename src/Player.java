import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.*;
import javax.imageio.ImageIO;


public class Player
{
    private int health, attack, x, y, status; //0=standing, 1=walking, 2=attacking, 3=jumping
    private double armor, regenRate;
    private String name;
    private boolean faceRight, foot, hasWeapon;
    public BufferedImage myImage;
    String path = null;

    public Player (String n, int hp, double arm, double reg, int atk)
    {
        name = n;
        health = hp;
        armor = arm;
        regenRate = reg;
        attack = atk;
        faceRight = true;
        status = 0;
        x = 0;
        y = 5;
        foot = true;
    }


    public boolean getFoot ()
    {
        return foot;
    }


    public void setFaceRight (boolean direction)
    {
        faceRight = direction;
    }


    public void setFoot (boolean inputFoot)
    {
        foot = inputFoot;
    }


    public void setStatus (int inputStatus)
    {
        status = inputStatus;
    }


    public void setX (int myX)
    {
        x = myX;
    }
    
    public int getX ()
    {
        return x;
    }
    
    public int getY ()
    {
        return y;
    }


    public void moveRight ()
    {
        x++;
    }


    public void setY (int myY)
    {
        y = myY;
    }


    public void moveLeft ()
    {
        x--;
    }


    public void moveUp ()
    {
        y++;
    }


    public void moveDown ()
    {
        y--;
    }


    public void show (Graphics g)
    {
        if (status == 0)
        {
            if (faceRight == true)
            {
                path = "Player_Stand_Right"; //fix
            }

            else if (faceRight == false)
            {
                path = "Player_Stand_Left";
            }
            path = "No Weapon//" + path;
        }
        else if (status == 1)
        {
            if (faceRight == true)
            {
                if (foot == true)
                {
                    path = "Player_Walk1_Right";
                }
                else
                {
                    path = "Player_Walk3_Right";
                }
            }

            else if (faceRight == false)
            {
                if (foot == true)
                {
                    path = "Player_Walk1_Left";
                }
                else
                {
                    path = "Player_Walk3_Left";
                }
            }
            path = "No Weapon//" + path;
        }
        else if (status == 2)
        {
            path = "Player_Stab1";
            path = "Weapon//" + path;
        }
        g.drawImage (getImage (path), x * 50, 600 - (y*50), null);
    }


    public static BufferedImage getImage (String path)
    {
        BufferedImage image = null;
        try
        {
            image = ImageIO.read (new File ("Player//" + path + ".png"));
        }

        catch (Exception e)
        {
            System.out.println ("Cannot Open File");
        }
        return image;
    }
}

