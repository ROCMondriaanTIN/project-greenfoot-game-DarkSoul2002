import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private GreenfootImage run1 = new GreenfootImage("p1_walk01 L.png");
    private GreenfootImage run2 = new GreenfootImage("p1_walk02 L.png");
    private GreenfootImage run3 = new GreenfootImage("p1_walk03 L.png");
    private GreenfootImage run4 = new GreenfootImage("p1_walk04 L.png");
    private GreenfootImage run5 = new GreenfootImage("p1_walk05 L.png");
    private GreenfootImage run6 = new GreenfootImage("p1_walk06 L.png");
    private GreenfootImage run7 = new GreenfootImage("p1_walk07 L.png");
    private GreenfootImage run8 = new GreenfootImage("p1_walk08 L.png");
    private GreenfootImage run9 = new GreenfootImage("p1_walk09 L.png");
    private GreenfootImage run10 = new GreenfootImage("p1_walk10 L.png");
    private GreenfootImage run11 = new GreenfootImage("p1_walk11 L.png");
    private GreenfootImage run12 = new GreenfootImage("p1_walk01.png");
    private GreenfootImage run13 = new GreenfootImage("p1_walk02.png");
    private GreenfootImage run14 = new GreenfootImage("p1_walk03.png");
    private GreenfootImage run15 = new GreenfootImage("p1_walk04.png");
    private GreenfootImage run16 = new GreenfootImage("p1_walk05.png");
    private GreenfootImage run17 = new GreenfootImage("p1_walk06.png");
    private GreenfootImage run18 = new GreenfootImage("p1_walk07.png");
    private GreenfootImage run19 = new GreenfootImage("p1_walk08.png");
    private GreenfootImage run20 = new GreenfootImage("p1_walk09.png");
    private GreenfootImage run21 = new GreenfootImage("p1_walk10.png");
    private GreenfootImage run22 = new GreenfootImage("p1_walk11.png");
    private int frame = 1;
    private int goldCoins = 0;
    private int silverCoins = 0;
    private int bronzeCoins = 0;
    private int gems = 0;
    private int blueKey = 0;
    
    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
    }

    @Override
    public void act() {
        if(frame > 10)
        {
        frame = 1;
        }
        handleInput();
        
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                return;
            }
        }
        
        for (Actor actor : getIntersectingObjects(Tile.class))
        {
            Tile tile = (Tile) actor;
            if (tile != null && tile.type.equals("water"))
            {     
                getWorld().removeObject(this);
                return;
            }
        }
        
        for (Actor actor : getIntersectingObjects(Tile.class))
        {
            Tile tile = (Tile) actor;
            if (tile != null && tile.type.equals("blueGem"))
            {     
                getWorld().removeObject(tile);
                gems ++;
                return;
            }
        }
        
        for (Actor actor : getIntersectingObjects(Tile.class))
        {
            Tile tile = (Tile) actor;
            if (tile != null && tile.type.equals("blueKey"))
            {     
                getWorld().removeObject(tile);
                blueKey ++;
                return;
            }
        }
        
        for (Actor actor : getIntersectingObjects(Tile.class))
        {
            Tile tile = (Tile) actor;
            if (tile != null && tile.type.equals("goldCoin"))
            {     
                getWorld().removeObject(tile);
                goldCoins ++;
                return;
            }
        }
        
        for (Actor actor : getIntersectingObjects(Tile.class))
        {
            Tile tile = (Tile) actor;
            if (tile != null && tile.type.equals("silverCoin"))
            {     
                getWorld().removeObject(tile);
                silverCoins ++;
                return;
            }
        }
        
        for (Actor actor : getIntersectingObjects(Tile.class))
        {
            Tile tile = (Tile) actor;
            if (tile != null && tile.type.equals("blueKey"))
            {     
                getWorld().removeObject(tile);
                blueKey ++;
                return;
            }
        }
    }

    public void handleInput() {
        if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("d")){
            velocityY = -12;
            velocityX = 3;
            setImage("p1_jump.png");
        }
        else if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("a")){
            velocityY = -12;
            velocityX = -3;
            setImage("p1_jump L.png");
        }
        else if(Greenfoot.isKeyDown("w")) {
            velocityY = -15;
            setImage("p1_jump.png");
           Greenfoot.playSound("Jump.mp3");
           
        }
        else if(Greenfoot.isKeyDown("s")){
            setImage("p1_duck.png");
        }
        else if (Greenfoot.isKeyDown("d")) {
            velocityX = 4;
            animateRight();
        }
        else if (Greenfoot.isKeyDown("a")) {
            velocityX = -4;
            animateLeft();
        } 
        else {
            setImage("p1_front.png");
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
    
    public void animateRight(){
        if(frame == 1)
        {
            setImage(run12);
        }
        else if(frame == 2)
        {
            setImage(run13);
        }
        else if(frame == 3)
        {
            setImage(run14);
        }
        else if(frame == 4)
        {
            setImage(run15);
        }
        else if(frame == 5)
        {
            setImage(run16);
        }
        else if(frame == 6)
        {
            setImage(run17);
        }
        else if(frame == 7)
        {
            setImage(run18);
        }
        else if(frame == 8)
        {
            setImage(run19);
        }
        else if(frame == 9)
        {
            setImage(run20);
        }
        else if(frame == 10)
        {
            setImage(run21);
        }
        else if(frame == 11)
        {
            setImage(run22);
            return;
        }



        frame ++;

    }
    
    public void animateLeft(){
        if(frame == 1)
        {
            setImage(run1);
        }
        else if(frame == 2)
        {
            setImage(run2);
        }
        else if(frame == 3)
        {
            setImage(run3);
        }
        else if(frame == 4)
        {
            setImage(run4);
        }
        else if(frame == 5)
        {
            setImage(run5);
        }
        else if(frame == 6)
        {
            setImage(run6);
        }
        else if(frame == 7)
        {
            setImage(run7);
        }
        else if(frame == 8)
        {
            setImage(run8);
        }
        else if(frame == 9)
        {
            setImage(run9);
        }
        else if(frame == 10)
        {
            setImage(run10);
        }
        else if(frame == 11)
        {
            setImage(run11);
            return;
        }



        frame ++;

    }
}
