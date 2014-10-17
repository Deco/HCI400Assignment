/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JPanel;

/**
 *
 * @author Declan White
 */
public class ImagePanel
  extends JPanel
  implements ComponentListener
{
    public enum Mode
    {
        ANCHOR,
        CENTER_HORIZONTAL,
        CENTER_VERTICAL,
        CENTER_BOTH,
        TILE,
        FILL,
        FIT_WIDTH,
        FIT_HEIGHT,
        FIT_MIN,
        FIT_MAX
    }

    private Image image;
//    private Image resizedImage;
    private Mode mode;

    public ImagePanel()
    {
        setMode(Mode.CENTER_HORIZONTAL);

        setBackground(new Color(21, 21, 21));
    }

    public ImagePanel(Image imageIn)
    {
        this();
        setImage(imageIn);
    }

    public ImagePanel(Image imageIn, Mode modeIn)
    {
        this(imageIn);
        setMode(modeIn);
    }

    private Mode getImageCoords(int[] pos, int[] size)
    {
        int iw, ih, ix, iy;
        int ow = image.getWidth(this);
        int oh = image.getHeight(this);
        if(ow <= 0 || oh <= 0) {
            return mode;
        }
        double aspectRatio = (double)ow / (double)oh;

        Mode paintMode = mode;
        double widthMul = (double)getWidth() / (double)ow;
        double heightMul = (double)getHeight() / (double)oh;
        if(mode == Mode.FIT_MIN) {
            if(widthMul >= heightMul) {
                paintMode = Mode.FIT_HEIGHT;
            } else {
                paintMode = Mode.FIT_WIDTH;
            }
        }
        if(mode == Mode.FIT_MAX) {
            if(widthMul <= heightMul) {
                paintMode = Mode.FIT_HEIGHT;
            } else {
                paintMode = Mode.FIT_WIDTH;
            }
        }

        switch(paintMode) {
            case ANCHOR:
                iw = ow;
                ih = oh;
                ix = 0;
                iy = 0;
                break;
            case CENTER_HORIZONTAL:
                iw = ow;
                ih = oh;
                ix = getWidth() / 2 - iw / 2;
                iy = 0;
                break;
            case CENTER_VERTICAL:
                iw = ow;
                ih = oh;
                ix = 0;
                iy = getHeight() / 2 - ih / 2;
                break;
            case CENTER_BOTH:
                iw = ow;
                ih = oh;
                ix = getWidth() / 2 - iw / 2;
                iy = getHeight() / 2 - ih / 2;
                break;
//            case TILE:
//                iw = 0;
//                ih = 0;
//                ix = 0;
//                iy = 0;
//                break;
            case FILL:
                iw = getWidth();
                ih = getHeight();
                ix = 0;
                iy = 0;
                break;
            case FIT_WIDTH:
                iw = getWidth();
                ih = (int)((double)iw / aspectRatio);
                ix = 0;
                iy = getHeight() / 2 - ih / 2;
                break;
            case FIT_HEIGHT:
                ih = getHeight();
                iw = (int)((double)ih * aspectRatio);
                ix = getWidth() / 2 - iw / 2;
                iy = 0;
                break;
            default:
                throw new IllegalStateException("Invalid ImagePanel mode");
        }

        pos[0] = ix;
        pos[1] = iy;
        size[0] = iw;
        size[1] = ih;
        return paintMode;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if(image == null) {
            return;
        }
        int ow = image.getWidth(this);
        int oh = image.getHeight(this);
        if(ow <= 0 || oh <= 0) {
            return;
        }

        switch(mode) {
            case CENTER_HORIZONTAL:
            case CENTER_VERTICAL:
            case CENTER_BOTH:
            case FILL:
            case FIT_WIDTH:
            case FIT_HEIGHT:
            case FIT_MIN:
            case FIT_MAX:
                int[] pos = new int[2];
                int[] size = new int[2];
                getImageCoords(pos, size);
                g.drawImage(image, pos[0], pos[1], size[0], size[1], this);
                break;
            case TILE:
                // http://stackoverflow.com/a/2228932
                for(int ix = 0; ix < getWidth(); ix += ow) {
                    for(int iy = 0; iy < getHeight(); iy += oh) {
                        g.drawImage(image, ix, iy, ow, oh, this);
                    }
                }
                break;
            default:
                throw new IllegalStateException("Invalid ImagePanel mode");
        }
    }

    @Override
    public void componentResized(ComponentEvent ce)
    {
//        resizedImage = image.getScaledInstance(getWidth(), getHeight(), 0);
//        repaint();
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
        componentResized(null);
    }

    public Mode getMode()
    {
        return mode;
    }

    public void setMode(Mode modeIn)
    {
        this.mode = modeIn;
        componentResized(null);
    }

    @Override
    public void componentMoved(ComponentEvent ce)
    {
        //
    }

    @Override
    public void componentShown(ComponentEvent ce)
    {
        //
    }

    @Override
    public void componentHidden(ComponentEvent ce)
    {
        //
    }

}
