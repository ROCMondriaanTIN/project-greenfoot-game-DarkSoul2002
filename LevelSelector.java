import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelector extends Actor
{
    public static boolean level1;
    public static boolean level2;
    /**
     * Act - do whatever the LevelSelector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage("levelselect.png");
        if(Greenfoot.isKeyDown("1")){
            level1 = true;
            Greenfoot.setWorld(new MyWorld());
        }
        else if(Greenfoot.isKeyDown("2")){
            level2 = true;
            Greenfoot.setWorld(new DemoWorld()); 
        }
    }    
}
