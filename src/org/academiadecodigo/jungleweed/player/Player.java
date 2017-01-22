package org.academiadecodigo.jungleweed.player;

import org.academiadecodigo.jungleweed.card.Card;

/**
 * Created by codecadet on 1/22/17.
 */
public class Player {

    private Card[] faceDownCards;
    private Card[] revealedCards;
    private Card faceUpCard;


    private int maxPossibleCards;

    private boolean agarraPau;

    public Player(int maxPossibleCards) {
        this.maxPossibleCards = maxPossibleCards;

        this.revealedCards = new Card[this.maxPossibleCards];
        this.faceDownCards = new Card[this.maxPossibleCards];

    }

    public Card revealNextCard() {
        return null;
    }


    public void receiveCards(Card[] cards) {
    }

    public int getTotalNumberOfCards() {
        return 0;
    }


    public Card[] giveCards() {
        return null;
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

}
