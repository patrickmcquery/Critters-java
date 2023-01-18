/*
 * Patrick McQuery
 * This is my Orca critter. I tried to create a pack hunting strategy.
 * Typically this implementation works quite well usually clearing
 * the field by step 275ish. It can even win fairly consistently with
 * only 2 starting critters. The getMove() method is hugely bloated but
 * I couldn't figure out how to get the info methods or the enums to work
 * outside of getMove so decided to leave it as is.
 */

import java.awt.*;

import javax.lang.model.util.ElementScanner6;

public class Orca extends Critter {

    private int time;

    // Constructor, sets time to 0
    public Orca() {
        this.time = 0;
    }

    /*
     * Main logic of the critter. Starts by incrementing the time each move.
     * Checks for an enemy in front, wall in front, and enemies around.
     * Tries to chase enemies loosely and chooses a random direction when
     * hitting a wall with randLorR().
     * After that it gets into the weeds with switch/case statements if there is
     * a teammate next to us. Turns to face the same direction as them.
     * After all that if they can hop forward, they do so.
     */
    public Action getMove(CritterInfo info) {
        this.time++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL) {
            return randLorR();
        } else if (info.getBack() == Neighbor.OTHER) {
            return Action.HOP;
        } else if (info.getRight() == Neighbor.OTHER) {
            return Action.RIGHT;
        } else if (info.getLeft() == Neighbor.OTHER) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            switch (info.getFrontDirection()) {
                case EAST:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.HOP;
                        case WEST:
                            return Action.RIGHT;
                        case NORTH:
                            return Action.RIGHT;
                        case SOUTH:
                            return Action.LEFT;
                    }
                case WEST:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.RIGHT;
                        case WEST:
                            return Action.HOP;
                        case NORTH:
                            return Action.LEFT;
                        case SOUTH:
                            return Action.RIGHT;
                    }
                case NORTH:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.LEFT;
                        case WEST:
                            return Action.RIGHT;
                        case NORTH:
                            return Action.HOP;
                        case SOUTH:
                            return Action.RIGHT;
                    }
                case SOUTH:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.RIGHT;
                        case WEST:
                            return Action.LEFT;
                        case NORTH:
                            return Action.RIGHT;
                        case SOUTH:
                            return Action.HOP;
                    }
            }
        } else if (info.getRight() == Neighbor.SAME) {
            switch (info.getRightDirection()) {
                case EAST:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.HOP;
                        case WEST:
                            return Action.RIGHT;
                        case NORTH:
                            return Action.RIGHT;
                        case SOUTH:
                            return Action.LEFT;
                    }
                case WEST:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.RIGHT;
                        case WEST:
                            return Action.HOP;
                        case NORTH:
                            return Action.LEFT;
                        case SOUTH:
                            return Action.RIGHT;
                    }
                case NORTH:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.LEFT;
                        case WEST:
                            return Action.RIGHT;
                        case NORTH:
                            return Action.HOP;
                        case SOUTH:
                            return Action.RIGHT;
                    }
                case SOUTH:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.RIGHT;
                        case WEST:
                            return Action.LEFT;
                        case NORTH:
                            return Action.RIGHT;
                        case SOUTH:
                            return Action.HOP;
                    }
            }
        } else if (info.getBack() == Neighbor.SAME) {
            switch (info.getBackDirection()) {
                case EAST:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.HOP;
                        case WEST:
                            return Action.RIGHT;
                        case NORTH:
                            return Action.RIGHT;
                        case SOUTH:
                            return Action.LEFT;
                    }
                case WEST:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.RIGHT;
                        case WEST:
                            return Action.HOP;
                        case NORTH:
                            return Action.LEFT;
                        case SOUTH:
                            return Action.RIGHT;
                    }
                case NORTH:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.LEFT;
                        case WEST:
                            return Action.RIGHT;
                        case NORTH:
                            return Action.HOP;
                        case SOUTH:
                            return Action.RIGHT;
                    }
                case SOUTH:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.RIGHT;
                        case WEST:
                            return Action.LEFT;
                        case NORTH:
                            return Action.RIGHT;
                        case SOUTH:
                            return Action.HOP;
                    }
            }
        } else if (info.getLeft() == Neighbor.SAME) {
            switch (info.getLeftDirection()) {
                case EAST:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.HOP;
                        case WEST:
                            return Action.RIGHT;
                        case NORTH:
                            return Action.RIGHT;
                        case SOUTH:
                            return Action.LEFT;
                    }
                case WEST:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.RIGHT;
                        case WEST:
                            return Action.HOP;
                        case NORTH:
                            return Action.LEFT;
                        case SOUTH:
                            return Action.RIGHT;
                    }
                case NORTH:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.LEFT;
                        case WEST:
                            return Action.RIGHT;
                        case NORTH:
                            return Action.HOP;
                        case SOUTH:
                            return Action.RIGHT;
                    }
                case SOUTH:
                    switch (info.getDirection()) {
                        case EAST:
                            return Action.RIGHT;
                        case WEST:
                            return Action.LEFT;
                        case NORTH:
                            return Action.RIGHT;
                        case SOUTH:
                            return Action.HOP;
                    }
            }
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        }

        return Action.HOP;
    }


    /*
     * Returns either magenta or yellow. Switches every 4 steps
     */
    public Color getColor() {
        if (this.time % 4 == 0) {
            return Color.MAGENTA;
        }
        return Color.YELLOW;
    }
    /*
     * Returns either X or x. Switches every 4 steps
     */
    public String toString() {
        if (this.time % 4 == 0) {
            return "X";
        }
        return "x";
    }
    /*
     * Returns left or right randomly.
     */
    public Action randLorR() {
        if (Math.random() <= 0.5) {
            return Action.LEFT;
        } else {
            return Action.RIGHT;
        }
    }
}