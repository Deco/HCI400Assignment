/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Declan White
 */
public class Card
  extends JPanel
  implements ComponentListener, MouseListener
{
    public static final double DEFAULT_ASPECT_RATIO = 0.74;

    private double aspectRatio;

    public Card(double aspectRatioIn)
    {
        setMinimumSize(new Dimension(20, 20));

        setPreferredSize(new Dimension(20, 20));

        setAspectRatio(aspectRatioIn);

        this.addComponentListener(this);
        this.addMouseListener(this);
    }

    public Card()
    {
        this(DEFAULT_ASPECT_RATIO);
    }

    public void relayout()
    {
        componentResized(null);
    }

    @Override
    public void componentResized(ComponentEvent e)
    {
        if(getParent() != null) {
            Dimension size = getSize();
            Dimension preferredSize = getPreferredSize();
            Dimension newSize = new Dimension(
              0,
              (int)((double)size.width / aspectRatio)
            );
            setPreferredSize(newSize);

            GUIUtil.revalidate(getParent());
        }
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

    @Override
    public void mouseEntered(MouseEvent me)
    {
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        setCursor(cursor);
    }

    @Override
    public void mouseExited(MouseEvent me)
    {
        Cursor cursor = Cursor.getDefaultCursor();
        setCursor(cursor);
    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
        // 
    }

    @Override
    public void mousePressed(MouseEvent me)
    {
        // 
    }

    @Override
    public void mouseReleased(MouseEvent me)
    {
        // 
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

}
