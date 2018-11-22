import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends Actor

{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public void act()
    {    
        setImage("Titel.jpg");
        if(Greenfoot.isKeyDown("enter")){
            getWorld().removeObject(this);}
        }
}
 

