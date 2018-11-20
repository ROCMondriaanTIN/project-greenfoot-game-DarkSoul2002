
import greenfoot.*;

/**
 * @author R. Springer
 */

public class Tile extends BasicTile {

    /**
     * Constructor of the tile. Creates a tile based on image, width and height
     *
     * @param image  Path to the image file
     * @param width  Width of the tile
     * @param heigth Height of the tile
     */
    public Tile(String image, int width, int heigth) {
        super(image, width, heigth);
    }

    @Override
    public String toString() {
        return "id: " + _id + "\n"
                + "X: " + getX() + "\n"
                + "Y: " + getY() + "\n"
                + "Type: " + type;
            }
        /**
         * Constructor of the tile. Creates a tile based on image, width, height and
         * a tile type
         *
         * @param image Path to the image file
         * @param width Width of the tile
         * @param heigth Height of the tile
         * @param type
         */
    public Tile(String image, int width, int heigth, TileType type){
            super(image, width, heigth, type);
        
    }
}
