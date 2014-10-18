/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JPanel;

/**
 *
 * @author Declan White
 */
public class Card
  extends JPanel
  implements ComponentListener
{
    public static final double DEFAULT_ASPECT_RATIO = 0.74;
    
    private double aspectRatio;

    public Card(double aspectRatioIn)
    {
        setMinimumSize(new Dimension(20, 20));

        setPreferredSize(new Dimension(20, 20));

        setAspectRatio(aspectRatioIn);

        this.addComponentListener(this);
    }
    public Card()
    {
        this(DEFAULT_ASPECT_RATIO);
    }

    @Override
    public void componentResized(ComponentEvent e)
    {
        if(getParent() != null) {
            Dimension size = getSize();
            Dimension preferredSize = getPreferredSize();
            Dimension newSize = new Dimension(
              preferredSize.width,
              (int)((double)size.width / aspectRatio)
            );
            setPreferredSize(newSize);

            Util.revalidate(getParent());
        }
    }

    @Override
    public void componentMoved(ComponentEvent e)
    {
        // 
    }

    @Override
    public void componentShown(ComponentEvent e)
    {
        // 
    }

    @Override
    public void componentHidden(ComponentEvent e)
    {
        // 
    }

    public double getAspectRatio()
    {
        return aspectRatio;
    }

    public void setAspectRatio(double aspectRatioIn)
    {
        aspectRatio = aspectRatioIn;
        componentResized(null);
    }

}
