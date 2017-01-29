package org.academiadecodigo.jungleweed.player;

import org.academiadecodigo.jungleweed.GameObjects.SimpleGFXCard;
import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.Deque;
import java.util.Iterator;

/**
 * Created by codecadet on 1/22/17.
 */
public class SimpleGFXPlayer extends Player {

    private int xFaceDown;
    private int yFaceDown;

    private int xFaceUp;
    private int yFaceUp;

    private Text score;

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
        this.showScore();
    }


    public boolean revealNextCard() {
        boolean result = super.revealNextCard();

        this.drawCards();
        this.deleteScore();
        this.showScore();
        return result;
    }

    public Card[] giveCards() {
        Card[] result = super.giveCards();

        this.drawCards();
        this.deleteScore();
        this.showScore();
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

    private void showScore(){
        score = new Text(xFaceDown + 70, yFaceDown + 70, Integer.toString(super.getTotalNumberOfCards()));
        score.draw();
        score.setColor(Color.CYAN);
        score.grow(40,40);
    }

    private void deleteScore(){
        score.delete();
    }


}
