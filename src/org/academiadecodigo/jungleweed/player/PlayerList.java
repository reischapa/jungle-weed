package org.academiadecodigo.jungleweed.player;

import org.academiadecodigo.jungleweed.card.Card;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 1/22/17.
 */
public class PlayerList extends Player {

    private int maxPossibleCards;

    private int numberFaceDownCards;
    private int numberRevealedCards;

    private boolean agarraPau;

    private int xFaceDown;
    private int yFaceDown;

    private int xFaceUp;
    private int yFaceUp;


    private Deque<Card> faceDownCards;
    private Deque<Card> faceUpCards;



    public PlayerList(int maxPossibleCards) {

        super(maxPossibleCards);

//        this.maxPossibleCards = maxPossibleCards;
        this.faceDownCards = new LinkedList<>();
        this.faceUpCards = new LinkedList<>();

    }


    public PlayerList(int maxPossibleCards, int xFaceDown, int yFaceDown, int xFaceUp, int yFaceUp) {
        super(maxPossibleCards, xFaceDown, yFaceDown, xFaceUp, yFaceUp);

//        this.maxPossibleCards = maxPossibleCards;
//
        this.faceDownCards = new LinkedList<>();
        this.faceUpCards = new LinkedList<>();
//
//        this.xFaceDown = xFaceDown;
//        this.yFaceDown = yFaceDown;
//
//        this.xFaceUp = xFaceUp;
//        this.yFaceUp = yFaceUp;

    }

    //when the player recieves cards from the game
    public void addCards(Card[] cards) {

        if (cards == null || cards.length == 0) {
            return;
        }

        for (Card c : cards) {
            if (c != null) {
                this.setCoordinates(c);
                c.setCardStatus(Card.CardStatus.HIDDEN);
                this.faceDownCards.addLast(c);
            }
        }

        if (!this.faceDownCards.isEmpty()) {
            this.faceDownCards.getFirst().setCardStatus(Card.CardStatus.FACEDOWN);
        }

    }


    public boolean revealNextCard() {

        if (this.faceDownCards.isEmpty()) {
            return true;
        }

        if (!this.faceUpCards.isEmpty()) {
            this.faceUpCards.getFirst().setCardStatus(Card.CardStatus.HIDDEN);
        }

        Card nextCard = this.faceDownCards.removeFirst();
        nextCard.setCardStatus(Card.CardStatus.VISIBLE);
        this.faceUpCards.addFirst(nextCard);

        if (!this.faceDownCards.isEmpty()) {
            this.faceDownCards.getFirst().setCardStatus(Card.CardStatus.FACEDOWN);
        }

        return false;

    }


    //when the player gives all the cards in the face up pile to the game
    public Card[] giveCards() {

        List<Card> output = new LinkedList<>();

        while (!this.faceUpCards.isEmpty()) {
            output.add(this.faceUpCards.removeFirst());
        }

        Card[] output2 = new Card[this.maxPossibleCards];
        return output.toArray(output2);
    }



    private void setCoordinates(Card input) {
        input.setXFaceUp(this.getxFaceUp());
        input.setYFaceUp(this.getyFaceUp());
        input.setXFaceDown(this.getxFaceDown());
        input.setYFaceDown(this.getyFaceDown());
    }


    public int getTotalNumberOfCards() {
        return this.getNumberFaceDownCards() + this.getNumberRevealedCards() + (this.faceUpCards.peekFirst()==null? 0:1);
    }


    public void printFaceDownCards() {
        for (Card c : this.faceDownCards) {
            System.out.println(c);
        }
    }

    public void printRevealedCards() {
        for (Card c : this.faceUpCards) {
            System.out.println(c);
        }
    }

    public Card getFaceUpCard() {
        return this.faceUpCards.peekFirst();
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
        return this.faceDownCards.isEmpty();
    }

    public int getNumberFaceDownCards() {
        return this.faceDownCards.size();
    }

    public int getNumberRevealedCards() {
        return this.faceUpCards.size() - (this.faceUpCards.peekFirst()==null? 0:1);
    }



}
