/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment;

import java.awt.Container;
import javax.swing.SwingUtilities;

/**
 *
 * @author 16142600
 */
public class Util
{
    public static void revalidate(final Container comp)
    {

        comp.invalidate();

        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                comp.validate();
                comp.repaint();
            }
        });
    }
}
