import greenfoot.*;

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
    private int player = 2;
    private String mapPlayer = "p2/";
    private Overlay overlay;

    public Hero(TileEngine te, Overlay overlay) {
        super();
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
            setImage(mapPlayer + player +"_jump.png");
        }

        if (Greenfoot.isKeyDown("s")) {
            setImage(mapPlayer + player +"_duck.png");
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
            setImage("p2/" + player +"_front.png");
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
            setImage("p2/" + player + "_walk01.png");
        } else if (frame == 2) {
            setImage("p2/" + player + "_walk02.png");
        } else if (frame == 3) {
            setImage("p2/" + player + "_walk03.png");
        } else if (frame == 4) {
            setImage("p2/" + player + "_walk04.png");
        } else if (frame == 5) {
            setImage("p2/" + player + "_walk05.png");
        } else if (frame == 6) {
            setImage("p2/" + player + "_walk06.png");
        } else if (frame == 7) {
            setImage("p2/" + player + "_walk07.png");
        } else if (frame == 8) {
            setImage("p2/" + player + "_walk08.png");
        } else if (frame == 9) {
            setImage("p2/" + player + "_walk09.png");
        } else if (frame == 10) {
            setImage("p2/" + player + "_walk10.png");
        } else if (frame == 11) {
            return;
        }


        frame++;

    }

    public void animateLeft() {
        if (frame == 1) {
            setImage(mapPlayer + player + "_walk01 L.png");
        } else if (frame == 2) {
            setImage(mapPlayer + player + "_walk02 L.png");
        } else if (frame == 3) {
            setImage(mapPlayer + player + "_walk03 L.png");
        } else if (frame == 4) {
            setImage(mapPlayer + player + "_walk04 L.png");
        } else if (frame == 5) {
            setImage(mapPlayer + player + "_walk05 L.png");
        } else if (frame == 6) {
            setImage(mapPlayer + player + "_walk06 L.png");
        } else if (frame == 7) {
            setImage(mapPlayer + player + "_walk07 L.png");
        } else if (frame == 8) {
            setImage(mapPlayer + player + "_walk08 L.png");
        } else if (frame == 9) {
            setImage(mapPlayer + player + "_walk09 L.png");
        } else if (frame == 10) {
            setImage(mapPlayer + player + "_walk10 L.png");
        } else if (frame == 11) {
            return;
        }


        frame++;

    }
}
