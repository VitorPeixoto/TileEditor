package editordetiles;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author Peixoto
 */
public enum Property { 
    WALKABLE_TILE(),
    WALLED_TILE(),
    UPPER_TILE();

    private Property() {

    }        
    
    private Image propertyImage;
    
    public Image getPropertyImage() throws IOException {
        switch(this) {
            case WALLED_TILE:
                return (new ImageIcon(getClass().getResource("/Images/WalledTile.png")).getImage());
            case UPPER_TILE:
                return (new ImageIcon(getClass().getResource("/Images/UpperTile.png")).getImage());
            default: return null;    
        }
    }
}
