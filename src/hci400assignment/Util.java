/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Declan White
 */
public class Util
{

    public static Date randomDate()
    {
        // http://stackoverflow.com/a/3985644/837856
        
        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(2014, 2014);
        gc.set(GregorianCalendar.YEAR, year);

        int daysInYear = gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR);
        int dayOfYear = randBetween(1, daysInYear);
        gc.set(GregorianCalendar.DAY_OF_YEAR, dayOfYear);
        
        return gc.getTime();
    }

    public static int randBetween(int start, int end)
    {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
