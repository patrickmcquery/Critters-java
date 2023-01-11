// This defines a simple class of critters that infect whenever they can and
// otherwise just spin around, looking for critters to infect.  This simple
// strategy turns out to be surpisingly successful.

import java.awt.*;

import javax.lang.model.util.ElementScanner6;

public class Orca extends Critter {
    private int time;
    public Orca ()
    {
        this.time = 0;
    }
    public Action getMove(CritterInfo info) {
        this.time++;
        if(info.getFront() == Neighbor.OTHER)
        {
            return Action.INFECT;
        }  else if(info.getFront() == Neighbor.SAME)
        {
            return Action.RIGHT;
        } else if(info.getBack() == Neighbor.OTHER)
        {
            return Action.HOP;
        } else if(info.getRight() == Neighbor.OTHER)
        {
            return Action.RIGHT;
        } else if(info.getLeft() == Neighbor.OTHER)
        {
            return Action.LEFT;
        }else if(info.getFront() == Neighbor.EMPTY)
        {
            return Action.HOP;
        } else if(info.getFront() == Neighbor.WALL)
        {
            return Action.RIGHT;
        }
        return Action.HOP;
    }

    public Color getColor() 
    {
        return Color.MAGENTA;
    }

    public String toString() {
        return "X";
    }
}