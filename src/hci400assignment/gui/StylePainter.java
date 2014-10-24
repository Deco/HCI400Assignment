/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.plaf.synth.ColorType;
import javax.swing.plaf.synth.SynthConstants;
import javax.swing.plaf.synth.SynthContext;
import javax.swing.plaf.synth.SynthPainter;

/**
 *
 * @author Declan White
 */
public class StylePainter
  extends SynthPainter
{
    static final Stroke THIN_STROKE = new BasicStroke(2);

    double roundness = 5.0;
    double outlinePadding = 3.0;

    //****** BUTTON ******/
    // <editor-fold defaultstate="collapsed" desc="Button Painters">
    @Override
    public void paintButtonBorder(
      SynthContext sc, Graphics g,
      int x, int y, int w, int h
    )
    {
        if((sc.getComponentState() & SynthConstants.MOUSE_OVER) != 0) {
            RoundRectangle2D.Double rect = new RoundRectangle2D.Double();

            Insets insets = sc.getComponent().getInsets();
            rect.setRoundRect(
              x + insets.left - outlinePadding, y + insets.top - outlinePadding,
              w - 1 - insets.left - insets.right + 2 * outlinePadding,
              h - 1 - insets.top - insets.bottom + 2 * outlinePadding,
              (int)roundness, (int)roundness
            );

            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(Color.WHITE);
            g2d.draw(rect);
        }
    }

    @Override
    public void paintButtonBackground(
      SynthContext sc, Graphics g,
      int x, int y, int w, int h
    )
    {
        Color col = sc.getStyle().getColor(sc, ColorType.BACKGROUND);
        g.setColor(col);
        g.fillRect(x, y, w, h);
    }
    // </editor-fold>


    //AHGJAHSDFJHSADFJKAHSDJFHAGJHASDF
    @Override
    public void paintComboBoxBackground(SynthContext context, Graphics graphics,
      int x, int y, int w, int h)
    {
        paintVerticalGradient(context, graphics, x, y, w, h);
    }


    //****** TEXTFIELD ******/
    // <editor-fold defaultstate="collapsed" desc="TextField Painters">
    @Override
    public void paintTextFieldBackground(
      SynthContext sc, Graphics g,
      int x, int y, int w, int h
    )
    {
        Color col = sc.getStyle().getColor(sc, ColorType.BACKGROUND);
        g.setColor(col);
        g.fillRect(x, y, w, h);

        if(sc.getComponent() instanceof HintTextField) {
            HintTextField comp = (HintTextField)sc.getComponent();

            if(comp.getText().trim().isEmpty()) {
                String hint = comp.getHintText();

                g.setColor(new Color(180, 180, 180));

                Font font = comp.getFont();
                font = font.deriveFont(Font.BOLD | Font.ITALIC);
                g.setFont(font);

                FontMetrics fm = g.getFontMetrics();
                int hintWidth = fm.stringWidth(hint);

                g.drawString(
                  hint,
                  x + w / 2 - hintWidth / 2,
                  y + h / 2 + fm.getAscent() / 2
                );
            }
        }
    }
    // </editor-fold>

    //****** SCROLLBAR ******/
    // <editor-fold defaultstate="collapsed" desc="Scrollbar Painters">
    @Override
    public void paintScrollBarThumbBackground(
      SynthContext sc, Graphics g, int x, int y, int w, int h, int orientation)
    {
        Graphics2D g2 = (Graphics2D)g;

        Color bgCol = sc.getStyle().getColor(sc, ColorType.BACKGROUND);
        g2.setColor(
          createTransparentColor(
            bgCol.darker().darker()
          )
        );
        g2.fillRect(x + 1, y + 1, w - 2, h - 2);
    }
    // </editor-fold>

    //****** SLIDER ******/
    // <editor-fold defaultstate="collapsed" desc="Slider Painters">
    @Override
    public void paintSliderBackground(
      SynthContext sc, Graphics g,
      int x, int y, int w, int h, int orientation
    )
    {
        paintBorder(sc, g, x, y, w, h);

        paintVerticalGradient(
          sc, g,
          x, y,
          w,
          h
        );
    }
    // </editor-fold>

    //****** PROGRESS BAR ******/
    // <editor-fold defaultstate="collapsed" desc="ProgressBar Painters">
    @Override
    public void paintProgressBarBackground(SynthContext context,
      Graphics graphics, int x, int y, int w, int h)
    {
        paintBorder(context, graphics, x, y, w, h);

        double percent
          = ((JProgressBar)context.getComponent()).getPercentComplete();

        paintVerticalGradient(
          context, graphics,
          x, y,
          (int)(w * percent),
          h
        );
    }
    // </editor-fold>

    //****** UTILITIES ******/
    // <editor-fold defaultstate="collapsed" desc="Painter Utility Methods">
    // http://www.alexecollins.com/content/tutorial-swing-synth-plaf-template-part-1/
    private static Color createTransparentColor(Color color)
    {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), 0x88);
    }

    // http://www.alexecollins.com/content/tutorial-swing-synth-plaf-template-part-1/
    public static void paintVerticalGradient(
      Graphics g,
      int x, int y, int w, int h, int arc,
      Color fg, Color bg
    )
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setPaint(getGradient(x, y, h, fg, bg));
        g2.fillRoundRect(x, y, w - 1, h - 1, arc, arc);
        g2.setRenderingHint(
          RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2.setColor(fg);
        g2.setStroke(THIN_STROKE);
        g2.drawRoundRect(x, y, w - 1, h - 1, arc, arc);
    }

    // http://www.alexecollins.com/content/tutorial-swing-synth-plaf-template-part-1/
    private void paintVerticalGradient(
      SynthContext context, Graphics g,
      int x, int y, int w, int h
    )
    {
        final int arc = getArc(context);
        Graphics2D g2 = (Graphics2D)g;
        g2.setPaint(getGradient(context, x, y, h));
        g2.fillRoundRect(x, y, w - 1, h - 1, arc, arc);
        g2.setRenderingHint(
          RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2.setColor(context.getStyle().getColor(context, ColorType.FOREGROUND));
        g2.setStroke(THIN_STROKE);
        g2.drawRoundRect(x, y, w - 1, h - 1, arc, arc);
    }

    // http://www.alexecollins.com/content/tutorial-swing-synth-plaf-template-part-1/
    private void paintBorder(
      SynthContext context, Graphics g,
      int x, int y, int w, int h
    )
    {
        Graphics2D g2 = (Graphics2D)g;

        final int arc = getArc(context);
        final boolean isFocused = (context.getComponentState()
          & SynthConstants.FOCUSED) > 0;

        g2.setColor(context.getStyle().getColor(context, ColorType.BACKGROUND));
        g2.fillRoundRect(x + 1, y + 1, w - 3, h - 3, arc, arc);
        g2.setRenderingHint(
          RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2.setColor(isFocused
          ? context.getStyle().getColor(context, ColorType.FOCUS)
          : context.getStyle().getColor(context, ColorType.FOREGROUND)
        );
        g2.setStroke(THIN_STROKE);
        g2.drawRoundRect(x, y, w - 1, h - 1, arc, arc);
    }

    // http://www.alexecollins.com/content/tutorial-swing-synth-plaf-template-part-1/
    private static GradientPaint getGradient(
      int x, int y, int h,
      Color fg, Color bg
    )
    {
        return new GradientPaint(x, y, bg, x, y + h, fg);
    }

    // http://www.alexecollins.com/content/tutorial-swing-synth-plaf-template-part-1/
    private GradientPaint getGradient(SynthContext context, int x, int y, int h)
    {
        // For simplicity this always recreates the GradientPaint. In a
        // real app you should cache this to avoid garbage.
        return new GradientPaint(
          x, y,
          context.getStyle().getColor(context, ColorType.BACKGROUND),
          x, y + h,
          mix(
            context.getStyle().getColor(context, ColorType.BACKGROUND),
            context.getStyle().getColor(context, ColorType.FOREGROUND)
          )
        );
    }

    // http://www.alexecollins.com/content/tutorial-swing-synth-plaf-template-part-1/
    private static int getArc(Component component)
    {
        // lists appear to mess up arcs
        return component instanceof JList ? 0
          : component.getFont().getSize() / 2;
    }

    // http://www.alexecollins.com/content/tutorial-swing-synth-plaf-template-part-1/
    private int getArc(SynthContext context)
    {
        return getArc(context.getComponent());
    }

    // http://www.alexecollins.com/content/tutorial-swing-synth-plaf-template-part-1/
    private Color mix(Color a, Color b)
    {
        return new Color(
          (a.getRed() + b.getRed()) / 2,
          (a.getGreen() + b.getGreen()) / 2,
          (a.getBlue() + b.getBlue()) / 2,
          (a.getAlpha() + b.getAlpha()) / 2
        );
    }
    // </editor-fold>
}
