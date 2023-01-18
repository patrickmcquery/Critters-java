
//The giant critter.

import java.awt.*;

import javax.lang.model.util.ElementScanner6;

public class Giant extends Critter {

    private int time;
    private int increment;

    //Constructor, Sets time to 0, and the increment to -1
    public Giant ()
    {
        this.increment = -1;
        this.time = 0;
    }

    /*always infect if an enemy is in front
      otherwise hop if possible
      otherwise turn right.
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
            return Action.RIGHT;
        }
    }
    //returns gray
    public Color getColor() 
    {
        return Color.GRAY;
    }
    
    /*
     * "fee" for 6 moves, then "fie" for 6 moves, 
     * then "foe" for 6 moves, then "fum" for 6 moves, 
     * then repeat.
     * 
     * I do this by incrementing through an array. The increment
     * only happens every 6 steps by using the mod operator
     */
    public String toString() {
        String[] ffff = {"fee","fie","foe","fum"};
        if(time % 6 == 0)
        {
            increment++;
            if(increment == 4)
            {
                increment = 0;
            }
        }
        return ffff[increment];
    }
}