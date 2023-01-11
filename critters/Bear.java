// This defines a simple class of critters that infect whenever they can and
// otherwise just spin around, looking for critters to infect.  This simple
// strategy turns out to be surpisingly successful.

import java.awt.*;

import javax.lang.model.util.ElementScanner6;

public class Bear extends Critter {
    private boolean polarBear;
    private int time;
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