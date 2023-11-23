package org.cyf;

import java.awt.*;

public class Giant extends Critter{
    private int moves; // count individual giant moves

    public Giant(){
        moves=0;
        getColor();
    }

    public Color getColor (){
        return Color.GRAY;
    }


    public String toString() {
        countMoves(); //track moves
        //"fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, then "fum" for 6 moves, then repeat.
        if (moves<=6){
            return "fee";
        } else if (moves<=12){
            return "fie";
        } else if (moves<=18){
            return "foe";
        } else {
            return "fum";
        }
    }

    // returns the move to be made by the giant
    public Action getMove(CritterInfo info) {
        //always infect if an enemy is in front, otherwise hop if possible, otherwise turn right
        if (info.getFront()==Neighbor.OTHER){
            return Action.INFECT;
        } else if(info.getFront()==Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    //once the moves reach the limit, reset to 1
    public void countMoves(){
        if (moves==24){
            moves=0;
        } else {
            moves++;
        }
    }
}
