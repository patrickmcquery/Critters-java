// This defines a simple class of critters that infect whenever they can and
// otherwise just spin around, looking for critters to infect.  This simple
// strategy turns out to be surpisingly successful.

import java.awt.*;

import javax.lang.model.util.ElementScanner6;

public class Giant extends Critter {
    private int time;
    private int increment;
    public Giant ()
    {
        this.increment = -1;
        this.time = 0;
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
            return Action.RIGHT;
        }
    }

    public Color getColor() 
    {
        return Color.GRAY;
    }

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