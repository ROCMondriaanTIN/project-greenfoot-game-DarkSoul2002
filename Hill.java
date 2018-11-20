import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hill here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hill extends Tile
{
    
    public Hill(String image, int width, int height){
        super(image, width, height);
        GreenfootImage newImage = new GreenfootImage(image);
        this.getImage().clear();
        this.getImage().scale(width, newImage.getHeight() + (int)(newImage.getHeight() * 0.4));
        this.getImage().drawImage(newImage, 0,0);
        
    }
   
}
