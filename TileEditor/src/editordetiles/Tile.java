package editordetiles;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Peixoto
 */
public class Tile implements Serializable {
    private ImageIcon tileImage;
    
    private int widht,
                height;
    
    private Property []tileProperty;
    
    public Tile(ImageIcon tileImage, int widht, int height, Property tileProperty[]) {
        this.tileImage = tileImage;
        this.widht = widht;
        this.height = height;
        this.tileProperty = tileProperty;
    }                

    public ImageIcon getTileImage() {
        return tileImage;
    }

    public void setTileImage(ImageIcon tileImage) {
        this.tileImage = tileImage;
    }

    public int getWidht() {
        return widht;
    }

    public void setWidht(int widht) {
        this.widht = widht;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Property[] getTileProperty() {
        return tileProperty;
    }

    public void setTileProperty(Property tileProperty[]) {
        this.tileProperty = tileProperty;
    }

}
