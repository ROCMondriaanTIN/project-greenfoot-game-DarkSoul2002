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
    public static int coinTeller = 0;
    public static int diamondTeller = 0;
    ArrayList<Actor> coins;
    ArrayList<Actor> lifes;
    ArrayList<Actor> diamonds;
    ArrayList<Actor> keys;
    
    public Overlay() {
        super();
        setImage("emptyHud.png");
        coins = new ArrayList<>();
        lifes = new ArrayList<>();
        diamonds = new ArrayList<>();
        keys = new ArrayList<>();
    }
    
    public void addCoin() {
        Actor coin = new Coin();
        coin.setImage("hud_coins.png");
        coins.add(coin);
        getWorld().addObject(coin, (coinTeller+ 50), 100);
        coinTeller = coinTeller + 10;
    }
    
    public void addKey() {
        Actor keys = new Key();
        keys.setImage("hud_keyBlue.png");
        getWorld().addObject(keys, 50, 150);
    }
    
    public void addDiamond() {
        Actor diamonds = new Diamond();
        diamonds.setImage("hud_gem_blue.png");
        getWorld().addObject(diamonds, (diamondTeller+ 50), 200);
        diamondTeller = diamondTeller + 10;
    }
}
