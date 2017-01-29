package org.academiadecodigo.jungleweed.player;

import org.academiadecodigo.jungleweed.card.Card;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 1/22/17.
 */
public class SimpleGFXPlayer extends Player {

    private int xFaceDown;
    private int yFaceDown;

    private int xFaceUp;
    private int yFaceUp;

    public SimpleGFXPlayer( int xFaceDown, int yFaceDown, int xFaceUp, int yFaceUp) {

        super();

        this.xFaceDown = xFaceDown;
        this.yFaceDown = yFaceDown;

        this.xFaceUp = xFaceUp;
        this.yFaceUp = yFaceUp;

    }

    //when the player recieves cards from the game
    public void addCards(Card[] cards) {

        super.addCards(cards);

        this.setCorrectCardStatus();
    }


    public boolean revealNextCard() {
        boolean result = super.revealNextCard();

        this.setCorrectCardStatus();

        return result;
    }

    private void setCoordinates(Card input) {
        input.setXFaceUp(this.xFaceUp);
        input.setYFaceUp(this.yFaceUp);
        input.setXFaceDown(this.xFaceDown);
        input.setYFaceDown(this.yFaceDown);
    }


    private void setCorrectCardStatus() {



    }




}
