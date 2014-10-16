/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hci400assignment;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author http://stackoverflow.com/a/2228932
 */
public class ImagePanel extends JPanel {
    private Image image;
    private boolean tile;

    ImagePanel() {
        this.tile = true;
    };

    ImagePanel(Image image) {
        this();
        this.image = image;
    };

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image == null) {
            return;
        }
        if (tile) {
            int iw = image.getWidth(this);
            int ih = image.getHeight(this);
            if (iw > 0 && ih > 0) {
                for (int x = 0; x < getWidth(); x += iw) {
                    for (int y = 0; y < getHeight(); y += ih) {
                        g.drawImage(image, x, y, iw, ih, this);
                    }
                }
            }
        } else {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    public boolean isTile()
    {
        return tile;
    }

    public void setTile(boolean tile)
    {
        this.tile = tile;
    }

    
}
