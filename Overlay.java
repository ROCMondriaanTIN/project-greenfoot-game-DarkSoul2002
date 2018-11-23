import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;


/**
 * Write a description of class Overlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Overlay extends Actor
{
    ArrayList<Actor> coins;
    ArrayList<Actor> lifes;
    ArrayList<Actor> diamonds;
    ArrayList<Actor> keys;
    
    public Overlay() {
        super();
        coins = new ArrayList<>();
        lifes = new ArrayList<>();
        diamonds = new ArrayList<>();
        keys = new ArrayList<>();
    }
    
    public void addCoin() {
        Actor coin = new Coin();
        coin.setImage("hud_coins.png");
        coins.add(coin);
        getWorld().addObject(coin, 50, 100);
    }
}
