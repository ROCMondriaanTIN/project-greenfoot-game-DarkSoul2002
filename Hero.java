import greenfoot.*;
import javax.swing.JOptionPane;
/**
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
    private int gems = 0;
    private int levens = 2;
    private TileEngine te;
    private Overlay overlay;
    public String personage = "1";

    public Hero(TileEngine te, Overlay overlay) {
        super();
        personage();
        this.te = te;
        this.overlay = overlay;
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        backgroundMusic();
    }

    @Override
    public void act() {
        if (frame > 10) {
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
                Levens.levens --;
                respawn();
                return;
            }
        }

        for (Actor actor : getIntersectingObjects(Tile.class)) {
            Tile tile = (Tile) actor;
            if(tile != null) {
                switch (tile.type) {
                    case WATER:
                        Levens.levens --;
                        respawn();
                        return;
                    case BLUE_GEM:
                        te.removeTile(tile);
                        this.overlay.addDiamond();
                        break;
                    case BLUE_KEY:
                        te.removeTile(tile);
                        this.overlay.addKey();
                        break;
                    case GOLD_COIN:
                        te.removeTile(tile);                       
                        this.overlay.addCoin();
                        this.overlay.addCoin();
                        return;
                    case SILVER_COIN:
                        te.removeTile(tile);
                        this.overlay.addCoin();
                        return;
                }
            }
        }
    }
    
    public void personage() {
        personage = JOptionPane.showInputDialog("kies een personage");
        if (personage.equals("1"))
        {
            personage = "1";
        }
        else if (personage.equals("2"))
        {
            personage = "2";
        }
        else if (personage.equals("3"))
        {
            personage = "3";
        }
    }

    boolean onGround() {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight() / 2, Tile.class);
        Actor underLeft = getOneObjectAtOffset(-(getWidth() / 2), getImage().getHeight() / 2, Tile.class);
        Actor underRight = getOneObjectAtOffset((getWidth() / 2), getImage().getHeight() / 2, Tile.class);
        
        Tile underTile = (Tile)under;
        if(underTile != null) {
            if(underTile.isSolid) {
                return true;
            }
        }
        
        Tile underTileLeft = (Tile)underLeft;
        if(underTileLeft != null) {
            if(underTileLeft.isSolid) {
                return true;
            }
        }
        
        Tile underTileRight = (Tile)underRight;
        if(underTileRight != null) {
            if(underTileRight.isSolid) {
                return true;
            }
        }
        
        return false;
    }
    
    public void handleInput() {
        if (Greenfoot.isKeyDown("w") && onGround() == true) {
            velocityY = -18;
            sound();
        }
        
        if(onGround() == false) {
            setImage("p" + personage +"_jump.png");
        }

        if (Greenfoot.isKeyDown("s")) {
            setImage("p" + personage +"_duck.png");
        } 
        else if (Greenfoot.isKeyDown("d")) {
            velocityX = 7;
            if(onGround()) {
               animateRight(); 
            }
        } 
        else if (Greenfoot.isKeyDown("a")) {
            velocityX = -7;
            if(onGround()) {
                animateLeft();
            }
        } 
        else {
            setImage("p" + personage +"_front.png");
        }
    }
    
    public void respawn() {
        switch (levens) {
                    case 2:
                        levens --;
                        setLocation(100, 1100);
                        return;
                    case 1:
                        levens --;
                        break;
                        default:
                        getWorld().removeObject(this);
                        break;
                    }
                }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
    
    private void  sound(){
        GreenfootSound  sound = new GreenfootSound("Jump.mp3"); // create a sound object
        sound.setVolume(25); // adjust the volume of the sound
        sound.play(); // play the sound
        ;
    }
    
    private void  backgroundMusic(){
        GreenfootSound  sound = new GreenfootSound("Triumph.mp3"); // create a sound object
        sound.setVolume(20); // adjust the volume of the sound
        sound.play(); // play the sound
        ;
    }

    public void animateRight() {
        if (frame == 1) {
            setImage("p" + personage + "_walk01.png");
        } else if (frame == 2) {
            setImage("p" + personage + "_walk02.png");
        } else if (frame == 3) {
            setImage("p" + personage + "_walk03.png");
        } else if (frame == 4) {
            setImage("p" + personage + "_walk04.png");
        } else if (frame == 5) {
            setImage("p" + personage + "_walk05.png");
        } else if (frame == 6) {
            setImage("p" + personage + "_walk06.png");
        } else if (frame == 7) {
            setImage("p" + personage + "_walk07.png");
        } else if (frame == 8) {
            setImage("p" + personage + "_walk08.png");
        } else if (frame == 9) {
            setImage("p" + personage + "_walk09.png");
        } else if (frame == 10) {
            setImage("p" + personage + "_walk10.png");
        } else if (frame == 11) {
            return;
        }


        frame++;

    }

    public void animateLeft() {
        if (frame == 1) {
            setImage("p" + personage + "_walk01 L.png");
        } else if (frame == 2) {
            setImage("p" + personage + "_walk02 L.png");
        } else if (frame == 3) {
            setImage("p" + personage + "_walk03 L.png");
        } else if (frame == 4) {
            setImage("p" + personage + "_walk04 L.png");
        } else if (frame == 5) {
            setImage("p" + personage + "_walk05 L.png");
        } else if (frame == 6) {
            setImage("p" + personage + "_walk06 L.png");
        } else if (frame == 7) {
            setImage("p" + personage + "_walk07 L.png");
        } else if (frame == 8) {
            setImage("p" + personage + "_walk08 L.png");
        } else if (frame == 9) {
            setImage("p" + personage + "_walk09 L.png");
        } else if (frame == 10) {
            setImage("p" + personage + "_walk10 L.png");
        } else if (frame == 11) {
            return;
        }


        frame++;

    }
}
