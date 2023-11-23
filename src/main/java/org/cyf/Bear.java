package org.cyf;

import java.awt.*;

public class Bear extends Critter {

    // private variables to measure the count of the instances and polarity of the bear
    private boolean isPolar; // true = polar bar; false = black bear
    private String move = "/";

    // constructor for the critter bear
    public Bear() {
        this.isPolar = Math.random() < 0.5;
    }

    // returns the color of the bear depending on the boolean polar (white if true, black if false)
    // Color.WHITE for a polar bear (when polar is true), Color.BLACK otherwise (when polar is false)
    public Color getColor() {
        if (isPolar) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    // returns the move to be made by the bear
    public Action getMove(CritterInfo info) {
        // always infect if an enemy is in front, otherwise hop if possible, otherwise turn left.
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

    // returns the string value of the bear
    // Should alternate on each different move between a slash character (/) and a backslash character () starting
    // with a slash.
    public String toString() {
        String myChar = this.move;
        if (this.move.equals("/")) { this.move = "\\"; }
        else { this.move = "/"; }
        return myChar;
    }

}
