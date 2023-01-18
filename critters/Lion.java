/*
 * The lion critter.
 */

import java.awt.*;

import javax.lang.model.util.ElementScanner6;

public class Lion extends Critter {

    private int time;
    private Color currentColor;

    //Constructor, sets time to 0
    public Lion ()
    {
        this.time = 0;
    }

    /* always infect if an enemy is in front
     * otherwise if a wall is in front or to the right, then turn left
     * otherwise if a fellow Lion is in front, then turn right
     * otherwise hop.
    */

    public Action getMove(CritterInfo info) {
        this.time++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL)
        {
            return Action.LEFT;
        } else if(info.getFront() == Neighbor.SAME)
        {
            return Action.RIGHT;
        } else
        {
            return Action.HOP;
        }
    }

    /*
     * Randomly picks one of three colors 
     * (Color.RED, Color.GREEN, Color.BLUE) and uses 
     * that color for three moves, then randomly picks 
     * one of those colors again for the next three moves,
     *  then randomly picks another one of those colors 
     * for the next three moves, and so on.
     * 
     * I used Math.random to get a random double between
     * 0.0 and 1.0 and based on the result return either
     * red blue or green. This only happens every 3 steps by
     * using the mod operator.
     */
    public Color getColor() 
    {
        double rand = Math.random();
        if(this.time % 3 == 0)
        {
            if(rand < 0.33)
            {
                currentColor = Color.RED;
            } else if(rand < 0.67)
            {
                currentColor = Color.GREEN;
            } else
            {
                currentColor = Color.BLUE;
            }
        }
        return currentColor;
    }
    
    //Returns the string "L"
    public String toString() {
        return "L";
    }
}