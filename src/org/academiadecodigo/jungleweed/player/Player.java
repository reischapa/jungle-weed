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

    //TODO remove before commmit

    public Player(Card[] cards) {
        this(cards.length);

        this.faceDownCards = cards;

    }

    public void revealNextCard() {
        if (faceUpCard != null) {
            this.pushRevealedCards();
        }

        this.faceUpCard = this.faceDownCards[0];

        this.faceDownCards[0] = null;

        this.defragFaceDownCards();

    }

    private void pushRevealedCards() {

        Card[] result = new Card[this.revealedCards.length];

        result[0] = this.faceUpCard;

        for (int i = 0; i < this.revealedCards.length; i++) {
            result[i+1] = this.revealedCards[i];
        }

        this.revealedCards = result;



    }

    private void defragFaceDownCards() {

        Card[] result = new Card[this.faceDownCards.length];

        int i = 0;
        int j = 0;
        for (; i < this.faceDownCards.length; i++) {
            if (faceDownCards[i] == null){
                continue;
            }

            result[j] = this.faceDownCards[i];
            System.out.println(result[j]);
            j++;

        }

        this.faceDownCards = result;
    }


    //when you give the player cards
    public void receiveCards(Card[] cards) {

        int i = 0;
        int j = 0;
        for(; i < this.faceDownCards.length; i++) {
            if (this.faceDownCards[i] != null) {
                continue;
            }

            this.faceDownCards[i] = cards[j];
            j++;

        }

    }


    public int getTotalNumberOfCards() {
        return this.faceDownCards.length + this.revealedCards.length + (this.revealedCards == null ? 1 : 0);
    }


    //when you take cards from the revealed cards pile and also the last revealed one
    public Card[] giveCards() {

        if (this.faceUpCard == null) {
            return null;
        }

        Card[] result = new Card[this.revealedCards.length];

        result[0] = this.faceUpCard;

        for (int i = 0; i < this.revealedCards.length; i++) {

            result[i+1] = this.revealedCards[i];
            this.revealedCards[i] = null;

        }


        return result;

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
