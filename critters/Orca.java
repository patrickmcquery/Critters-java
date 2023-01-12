// This defines a simple class of critters that infect whenever they can and
// otherwise just spin around, looking for critters to infect.  This simple
// strategy turns out to be surpisingly successful.

import java.awt.*;

import javax.lang.model.util.ElementScanner6;

public class Orca extends Critter {
    enum EnemyLoc
    {
        FRONT,
        BACK,
        LEFT,
        RIGHT
    }
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
            return randLorR();
        } else if(info.getRight() == Neighbor.SAME)
        {
            switch(info.getRightDirection())
            {
                case EAST:
                    switch(info.getDirection())
                    {
                        case EAST: return Action.HOP;
                        case WEST: return Action.RIGHT;
                        case NORTH: return Action.RIGHT;
                        case SOUTH: return Action.LEFT;
                    }
                case WEST:
                    switch(info.getDirection())
                        {
                            case EAST: return Action.RIGHT;
                            case WEST: return Action.HOP;
                            case NORTH: return Action.LEFT;
                            case SOUTH: return Action.RIGHT;
                        }
                case NORTH:
                    switch(info.getDirection())
                    {
                        case EAST: return Action.LEFT;
                        case WEST: return Action.RIGHT;
                        case NORTH: return Action.HOP;
                        case SOUTH: return Action.RIGHT;
                    }
                case SOUTH:
                    switch(info.getDirection())
                    {
                        case EAST: return Action.RIGHT;
                        case WEST: return Action.LEFT;
                        case NORTH: return Action.RIGHT;
                        case SOUTH: return Action.HOP;
                    }
            }
            } else if(info.getFront() == Neighbor.SAME)
            {
                switch(info.getFrontDirection())
                {
                    case EAST:
                        switch(info.getDirection())
                        {
                            case EAST: return Action.HOP;
                            case WEST: return Action.RIGHT;
                            case NORTH: return Action.RIGHT;
                            case SOUTH: return Action.LEFT;
                        }
                    case WEST:
                        switch(info.getDirection())
                            {
                                case EAST: return Action.RIGHT;
                                case WEST: return Action.HOP;
                                case NORTH: return Action.LEFT;
                                case SOUTH: return Action.RIGHT;
                            }
                    case NORTH:
                        switch(info.getDirection())
                        {
                            case EAST: return Action.LEFT;
                            case WEST: return Action.RIGHT;
                            case NORTH: return Action.HOP;
                            case SOUTH: return Action.RIGHT;
                        }
                    case SOUTH:
                        switch(info.getDirection())
                        {
                            case EAST: return Action.RIGHT;
                            case WEST: return Action.LEFT;
                            case NORTH: return Action.RIGHT;
                            case SOUTH: return Action.HOP;
                        }
                }
        }  else if(info.getBack() == Neighbor.SAME)
        {
            switch(info.getBackDirection())
            {
                case EAST:
                    switch(info.getDirection())
                    {
                        case EAST: return Action.HOP;
                        case WEST: return Action.RIGHT;
                        case NORTH: return Action.RIGHT;
                        case SOUTH: return Action.LEFT;
                    }
                case WEST:
                    switch(info.getDirection())
                        {
                            case EAST: return Action.RIGHT;
                            case WEST: return Action.HOP;
                            case NORTH: return Action.LEFT;
                            case SOUTH: return Action.RIGHT;
                        }
                case NORTH:
                    switch(info.getDirection())
                    {
                        case EAST: return Action.LEFT;
                        case WEST: return Action.RIGHT;
                        case NORTH: return Action.HOP;
                        case SOUTH: return Action.RIGHT;
                    }
                case SOUTH:
                    switch(info.getDirection())
                    {
                        case EAST: return Action.RIGHT;
                        case WEST: return Action.LEFT;
                        case NORTH: return Action.RIGHT;
                        case SOUTH: return Action.HOP;
                    }
            }
        } else if(info.getLeft() == Neighbor.SAME)
        {
            switch(info.getLeftDirection())
            {
                case EAST:
                    switch(info.getDirection())
                    {
                        case EAST: return Action.HOP;
                        case WEST: return Action.RIGHT;
                        case NORTH: return Action.RIGHT;
                        case SOUTH: return Action.LEFT;
                    }
                case WEST:
                    switch(info.getDirection())
                        {
                            case EAST: return Action.RIGHT;
                            case WEST: return Action.HOP;
                            case NORTH: return Action.LEFT;
                            case SOUTH: return Action.RIGHT;
                        }
                case NORTH:
                    switch(info.getDirection())
                    {
                        case EAST: return Action.LEFT;
                        case WEST: return Action.RIGHT;
                        case NORTH: return Action.HOP;
                        case SOUTH: return Action.RIGHT;
                    }
                case SOUTH:
                    switch(info.getDirection())
                    {
                        case EAST: return Action.RIGHT;
                        case WEST: return Action.LEFT;
                        case NORTH: return Action.RIGHT;
                        case SOUTH: return Action.HOP;
                    }
            }
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
    
    public Action randLorR ()
    {
        if(Math.random() <= 0.5)
            {
                return Action.LEFT;
            } else
            {
                return Action.RIGHT;
            }
    }
}