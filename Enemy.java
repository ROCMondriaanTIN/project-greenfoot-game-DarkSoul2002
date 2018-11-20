
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Enemy extends Mover {

    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;
    private int frame = 1;

    public Enemy() {
        super();
        animateRight();
        getImage().mirrorHorizontally();
        walkRange = 140;
        firstAct = true;
        speed = 1;
    }

    @Override
    public void act() {
        int x = getX();
        int y = getY();

        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }

        velocityX = speed;
        applyVelocity();
        if (getX() >= xMax) {
            speed *= -1;
            frame ++;
            x = xMax;
            getImage().mirrorHorizontally();
        } else if (getX() <= xMin) {
            speed *= -1;
            frame ++;
            x = xMin;
            getImage().mirrorHorizontally();
        }
    }
    
     private void animateRight() {
        if (frame == 1) {
            setImage("snailWalk1.png");
            frame ++;
        } 
        else if (frame == 2) {
            setImage("snailWalk2.png");
            frame ++;
            return;
        }
        
        
    }
}
