package editordetiles;

import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Peixoto
 */
public class Label extends JLabel {
    private boolean printProperty = false;
    private Property thisProperty;
    
    public Label(Property thisProperty) {
        this.thisProperty = thisProperty;
    }
    
    public void paintComponent(Graphics g) {
        try {
            super.paintComponent(g);
            g.drawImage(thisProperty.getPropertyImage(), 0, 0, null);            
        } catch (IOException ex) {
            Logger.getLogger(Label.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void togglePrintProperty() {
        printProperty = !printProperty;
    }

    void setProperty(Property property) {
        this.thisProperty = property;
    }
    
    Property getProperty() {
        return thisProperty;
    }
}
