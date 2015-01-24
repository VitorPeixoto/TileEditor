package editordetiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Peixoto
 */
public class TilesLabel extends JLabel{
    private boolean Grid;
    
    private final int width,
                      height;

    private int x = 0, y = 0;
    public TilesLabel(int width, int height) {
        this.width = width;
        this.height = height;
    
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
                if(Grid) {
                    x = e.getX();
                    y = e.getY();
                    x = getCloserGridPositionX();
                    y = getCloserGridPositionY();
                }
                else {
                    x = e.getX()-(TilesLabel.this.width/2);
                    y = e.getY()-(TilesLabel.this.height/2);                
                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

            private int getCloserGridPositionX() {
                int pos = x/TilesLabel.this.width;
                return (pos*TilesLabel.this.width);
            }

            private int getCloserGridPositionY() {
                int pos = y/TilesLabel.this.height;
                return (pos*TilesLabel.this.height);
            }
        });
    }
    
    public void paintComponent(Graphics g) {
        if(getIcon() != null)g.drawImage(((ImageIcon)getIcon()).getImage(), 0, 0, null);
        g.setColor(Color.red);
        g.drawRect(x, y, width, height);        
    }
    
    public ImageIcon getTileIcon() {
        /*BufferedImage bi = (BufferedImage) ((ImageIcon)getIcon()).getImage();
        return new ImageIcon(bi.getSubimage(x, y, width, height));*/
        /*    BufferedImage buffImage = new BufferedImage(getIcon().getIconWidth(), getIcon().getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = buffImage.createGraphics();
            g.drawImage(((ImageIcon)getIcon()).getImage(), x, y, width, height, 0, 0, width, height, null);
            return new ImageIcon(buffImage);*/
        
            BufferedImage buffImage = new BufferedImage(getIcon().getIconWidth(), getIcon().getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = buffImage.createGraphics();
            //g.drawImage(((ImageIcon)getIcon()).getImage(), x, y, width, height, 0, 0, width, height, null);
            g.drawImage(((ImageIcon)getIcon()).getImage(), 0, 0, null);
            return new ImageIcon(buffImage.getSubimage(x, y, width, height));        
    }
    
     void setGrid(boolean selected) {
        Grid = selected;
    }    
}
