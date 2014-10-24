/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui;

import javax.swing.JTextField;

/**
 *
 * @author Declan White
 */
public class HintTextField
  extends JTextField
{
    private String hintText = "";

    public HintTextField()
    {
        super();
    }

    public String getHintText()
    {
        return hintText;
    }

    public void setHintText(String hintTextIn)
    {
        hintText = hintTextIn;
    }
}
