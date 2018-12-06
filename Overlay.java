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
    public static int coinOffset = 0;
    public static int diamondTeller = 0;
    public int lifeOffset = 0;
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
      
    public void addRemoveCoin() {
        Actor coin = new Coin();
        coin.setImage("hud_coins.png");
        coins.add(coin);
        getWorld().addObject(coin, (coinOffset+ 50), 100);
        coinOffset += 7;
        
        if (coinTeller >= 40)
        {
            Levens.levensHud ++;
            addLife();
            for (int i = 0; i < coins.size(); i++)
            {
                getWorld().removeObject(coins.get(i));
            }
            coinTeller = 0;  
            coinOffset = 0;
        }
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
        diamondTeller += 10;
    }  
    
    public void addLife() {
        Actor life = new Levens();
        life.setImage("hud_heartFull.png");
        lifes.add(life);
        getWorld().addObject(life, (lifeOffset+ 50), 300);
        lifeOffset += 10;

        
        
    }
    
    public void removeLife() {
        //getWorld().removeObject(life);
    }
}
