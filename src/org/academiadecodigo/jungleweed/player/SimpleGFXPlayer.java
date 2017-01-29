package org.academiadecodigo.jungleweed.player;

import org.academiadecodigo.jungleweed.card.Card;

import java.util.Deque;

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

        for (Card c : cards) {
            this.setCoordinates(c);
        }

        super.addCards(cards);

        this.drawCards();
    }


    public boolean revealNextCard() {
        boolean result = super.revealNextCard();

        this.drawCards();
        return result;
    }

    public Card[] giveCards() {
        Card[] result = super.giveCards();

        this.drawCards();
        return result;
    }


    private void setCoordinates(Card input) {
        //TODO implement animation logic here using the values that the card had previously
       input.setXFaceUp(this.xFaceUp);
       input.setYFaceUp(this.yFaceUp);
       input.setXFaceDown(this.xFaceDown);
       input.setYFaceDown(this.yFaceDown);
    }

    private void drawCards() {

        Deque<Card> faceDownList = this.peekFaceDownCards();
        Deque<Card> faceUpList = this.peekFaceUpCards();

        if (faceDownList != null) {
            for (Card c : faceDownList) {
                c.hide();
            }
        }

        if (faceUpList != null) {
            for (Card c : faceUpList) {
                c.hide();
            }
        }

        Card cFaceDown = this.peekFaceDownCards().peekFirst();
        Card cFaceUp = this.peekFaceUpCards().peekFirst();

        if (cFaceDown != null) {
            cFaceDown.draw();
        }

        if (cFaceUp != null) {
            cFaceUp.draw();
        }

    }


}
