import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levens extends Actor
{
    public static int levensHud = 2;

    public void act() 
    {
        levens();
    }

    public void levens()
    {
        switch (levensHud) {
            case 0:
                    setImage("hud_heartEmpty.png");
                    break;
                case 1:
                    setImage("hud_heartHalf.png");
                    break;
                case 2:
                    setImage("hud_heartFull.png");
                    break;
                default:
                    setImage("hud_heartEmpty.png");
                    return;

        }
    }
    
    public void coins()
    {

    }
}
