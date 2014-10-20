/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import javax.swing.JPanel;

/**
 *
 * @author Declan White
 */
public class FadePanel
  extends JPanel
{

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        Color bgcol = getBackground();

        LinearGradientPaint lgp = new LinearGradientPaint(
          0, 0, getWidth(), getHeight(),
          new float[]{0.0f, 0.5f, 1.0f},
          new Color[]{
              new Color(255, 255, 255, 0),
              new Color(255, 255, 255, 128),
              new Color(255, 255, 255, 0)
          }
        );
        g2.setPaint(lgp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

}
