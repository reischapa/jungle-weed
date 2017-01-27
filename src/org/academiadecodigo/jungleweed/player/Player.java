package org.academiadecodigo.jungleweed.player;

import org.academiadecodigo.jungleweed.card.Card;

import java.util.Arrays;

/**
 * Created by codecadet on 1/22/17.
 */
public class Player {

    private Card[] faceDownCards;
    private Card[] revealedCards;
    private Card faceUpCard;


    private boolean emptyFaceDown;

    private int maxPossibleCards;

    private int numberFaceDownCards;
    private int numberRevealedCards;

    private boolean agarraPau;

    private int xFaceDown;
    private int yFaceDown;

    private int xFaceUp;
    private int yFaceUp;

    public Player(int maxPossibleCards) {
        this.maxPossibleCards = maxPossibleCards;

        this.revealedCards = new Card[this.maxPossibleCards];
        this.faceDownCards = new Card[this.maxPossibleCards];

    }


    public Player(int maxPossibleCards, int xFaceDown, int yFaceDown, int xFaceUp, int yFaceUp) {

        this.maxPossibleCards = maxPossibleCards;
        this.revealedCards = new Card[this.maxPossibleCards];
        this.faceDownCards = new Card[this.maxPossibleCards];

        this.xFaceDown = xFaceDown;
        this.yFaceDown = yFaceDown;

        this.xFaceUp = xFaceUp;
        this.yFaceUp = yFaceUp;


    }


    public boolean revealNextCard() {

        if (emptyFaceDown) {
            return true;
        }

        if (faceUpCard != null) {
            this.pushRevealedCards();

        }

        this.faceUpCard = this.faceDownCards[0];

        this.faceDownCards[0] = null;


        this.numberFaceDownCards--;

        this.defragFaceDownCards();

        if (!this.emptyFaceDown) {

        }


        this.faceUpCard.turn();

        return this.emptyFaceDown;


    }

    private void pushRevealedCards() {

        Card[] result = new Card[this.revealedCards.length];

        result[0] = this.faceUpCard;

        for (int i = 1; i < result.length ; i++) {
            result[i] = this.revealedCards[i-1];
        }

        this.numberRevealedCards++;
        this.revealedCards = result;

    }

    private void defragFaceDownCards() {

        Card[] newArray = new Card[this.faceDownCards.length];
        this.emptyFaceDown = true;
        int i = 0;
        int j = 0;
        for (; i < this.faceDownCards.length; i++) {
            if (faceDownCards[i] == null){
                continue;
            }

            this.emptyFaceDown = false;
            newArray[j] = this.faceDownCards[i];
            j++;

        }

        this.faceDownCards = newArray;
    }

    //when the player receives cards from the game
    public void addCards(Card[] cards) {

        if (cards == null) {
            return;
        }


        int j = 0;
        int i = 0;
        for(; i < this.faceDownCards.length; i++) {
            if (this.faceDownCards[i] != null) {
                continue;
            }

            if (cards[j] == null) {
                continue;
            }

            this.emptyFaceDown = false;
            this.faceDownCards[i] = cards[j];

            setCoordinates(this.faceDownCards[i]);

            this.numberFaceDownCards++;
            j++;

            if (j == cards.length) {
                break;
            }

        }

        for(int k = 0; k < this.revealedCards.length; k++) {

            if (this.revealedCards[k] == null) {
                break;
            }

            this.faceDownCards[j + k] = this.revealedCards[k];
            this.revealedCards[k] = null;

        }


        if (!this.emptyFaceDown) {

        }


    }

    private void setCoordinates(Card input) {
        input.setXFaceUp(this.xFaceUp);
        input.setYFaceUp(this.yFaceUp);
        input.setXFaceDown(this.xFaceDown);
        input.setYFaceUp(this.yFaceDown);
        input.turn();
    }


    public int getTotalNumberOfCards() {
        return this.numberFaceDownCards + this.numberRevealedCards + (this.faceUpCard != null ? 1 : 0);
    }



    //when the player gives cards to the game
    public Card[] giveCards() {

        if (this.faceUpCard == null) {
            return null;
        }

        Card[] result = new Card[this.revealedCards.length];

        result[0] = this.faceUpCard;
        this.faceUpCard = null;

        for (int i = 0; i < this.revealedCards.length - 1; i++) {

            if (this.revealedCards[i] == null) {
                break;
            }

            result[i+1] = this.revealedCards[i];
            this.revealedCards[i] = null;
            this.numberRevealedCards--;

        }

        return result;

    }

    public void printFaceDownCards() {
        for (Card c : this.faceDownCards) {
            System.out.println(c);
        }
    }

    public void printRevealedCards() {
        for (Card c : this.revealedCards) {
            System.out.println(c);
        }
    }

    public Card getFaceUpCard() {
        return this.faceUpCard;
    }

    public boolean isAgarraPau() {
        return agarraPau;
    }

    public void agarraPau() {
        this.agarraPau = true;
    }

    public void largaPau() {
        this.agarraPau = false;
    }

    public int getMaxPossibleCards() {
        return maxPossibleCards;
    }

    public boolean isEmptyFaceDown() {
        return emptyFaceDown;
    }

    public int getNumberFaceDownCards() {
        return this.numberFaceDownCards;
    }

    public int getNumberRevealedCards() {
        return this.numberRevealedCards;
    }



}
