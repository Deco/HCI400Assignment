/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui;

import hci400assignment.model.Item;
import javax.swing.JPanel;

/**
 *
 * @author Declan White
 */
public abstract class RootPanel
  extends JPanel
{

    public RootPanel()
    {
        setDoubleBuffered(true);
    }

    public abstract void focusItem(Item item);

    public abstract void showHomeScreen();

    public abstract void showFriendsScreen();

    public abstract void showSearchScreen();

    public abstract void showSettingsWindow();

    public abstract void goBack();

}
