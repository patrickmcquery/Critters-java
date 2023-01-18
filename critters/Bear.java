//The bear critter

import java.awt.*;

import javax.lang.model.util.ElementScanner6;

public class Bear extends Critter {

    private boolean polarBear;
    private int time;

    /*
     *  Sets the polar boolean to the appropriate value
     */
    public Bear (boolean polar)
    {
        this.time = 0;

        if(polar)
        {
            polarBear = true;
        } else
        {
            polarBear = false;
        }
    }

    /*
     *  always infect if an enemy is in front
     * otherwise hop if possible
     * otherwise turn left.
     */
    public Action getMove(CritterInfo info) {
        this.time++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.EMPTY)
        {
            return Action.HOP;
        } else
        {
            return Action.LEFT;
        }
    }

    /*
     *  Color.WHITE for a polar bear (when polar is true), 
     *  Color.BLACK otherwise (when polar is false)
     * 
     *  Pretty easy if/else statement.
     */
    public Color getColor() 
    {
        if(polarBear)
        {
            return Color.WHITE;
        } else
        {
            return Color.BLACK;
        }
    }

    /*
     *  Should alternate on each different move between 
     * a slash character (/) and a backslash character (\)
     *  starting with a slash.
     * 
     *  I do this with the mod operator.
     */
    public String toString() {
        if(time % 2 == 0)
        {
            return "/";
        } else
        {
            return "\\";
        }
        
    }
}