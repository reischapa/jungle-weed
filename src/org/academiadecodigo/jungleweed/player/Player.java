package org.academiadecodigo.jungleweed.player;

import org.academiadecodigo.jungleweed.card.Card;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 1/22/17.
 */
public class Player{

    private boolean agarraPau;

    private Deque<Card> faceDownCards;
    private Deque<Card> faceUpCards;



    public Player() {

        this.faceDownCards = new LinkedList<>();
        this.faceUpCards = new LinkedList<>();

    }

    //when the player recieves cards from the game
    public void addCards(Card[] cards) {

        if (cards == null || cards.length == 0) {
            return;
        }

        for (Card c : cards) {
            if (c != null) {
                if (c.isFaceUp()) {
                    c.turn();
                }
                this.faceDownCards.addLast(c);
            }
        }

    }


    public boolean revealNextCard() {

        if (this.faceDownCards.isEmpty()) {
            return true;
        }

        Card nextCard = this.faceDownCards.removeFirst();
        nextCard.turn();
        this.faceUpCards.addFirst(nextCard);

        return false;

    }


    //when the player gives all the cards in the face up pile to the game
    public Card[] giveCards() {

        List<Card> output = new LinkedList<>();

        int arraySize = this.faceUpCards.size();

        while (!this.faceUpCards.isEmpty()) {
            Card c = this.faceUpCards.removeFirst();
            if (c.isFaceUp()) {
                c.turn();
            }
            output.add(c);
        }

        Card[] output2 = new Card[arraySize];
        return output.toArray(output2);
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

    public boolean isEmptyFaceDown() {
        return this.faceDownCards.isEmpty();
    }

    public int getNumberFaceDownCards() {
        return this.faceDownCards.size();
    }

    public int getNumberRevealedCards() {
        return this.faceUpCards.size() - (this.faceUpCards.peekFirst()==null? 0:1);
    }

    public Deque<Card> peekFaceDownCards() {
        return this.faceDownCards;
    }

    public Deque<Card> peekFaceUpCards() {
        return this.faceUpCards;
    }




}
