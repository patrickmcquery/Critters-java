// This defines a simple class of critters that infect whenever they can and
// otherwise just spin around, looking for critters to infect.  This simple
// strategy turns out to be surpisingly successful.

import java.awt.*;

import javax.lang.model.util.ElementScanner6;

public class Lion extends Critter {
    private int time;
    private Color currentColor;
    public Lion ()
    {
        this.time = 0;
    }
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

    public String toString() {
        return "L";
    }
}