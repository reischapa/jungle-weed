package org.academiadecodigo.jungleweed.player;

import org.academiadecodigo.jungleweed.GameObjects.SimpleGFXCard;
import org.academiadecodigo.jungleweed.card.Card;

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
            if (c instanceof SimpleGFXCard) {
                this.setCoordinates( (SimpleGFXCard) c);
            }
        }

        super.addCards(cards);
        this.setCorrectCardStatus();
    }


    public boolean revealNextCard() {
        boolean result = super.revealNextCard();
        this.setCorrectCardStatus();
        return result;
    }

    public Card[] giveCards() {
        Card[] result = super.giveCards();

        for (Card c : result) {
            if (c != null && c instanceof SimpleGFXCard) {
                ((SimpleGFXCard) c).setCardStatus(SimpleGFXCard.CardStatus.HIDDEN);
            }
        }

        return result;
    }


    private void setCoordinates(SimpleGFXCard input) {
        //TODO implement animation logic here using the values that the card had previously
       input.setXFaceUp(this.xFaceUp);
       input.setYFaceUp(this.yFaceUp);
       input.setXFaceDown(this.xFaceDown);
       input.setYFaceDown(this.yFaceDown);
    }


//    public void move(SimpleGFXCard simpleGFXCard)  {
//        while(simpleGFXCard.getXFaceDown()!= x && faceUp.getY()!=y) {
//
//            if(x > faceUp.getX() && y < faceUp.getX()) {
//                faceUp.translate( 1, -1 );
//            }else if(x > faceUp.getX() && y > faceUp.getY()){
//                faceUp.translate( 1 , 1 );
//            }else if(x < faceUp.getX() && y < faceUp.getY()){
//                faceUp.translate( -1, -1 );
//            }else{
//                faceUp.translate( -1, 1 );
//            }
//            try {
//                Thread.sleep(5);
//            } catch (Exception e) {
//                System.out.println("FUCK");
//                e.printStackTrace();
//            }
//        }
//        System.out.println(faceUp.getX());
//    }


    private void setCorrectCardStatus() {

        Iterator<Card> faceDownIterator = this.peekFaceDownCards().iterator();
        Iterator<Card> faceUpIterator = this.peekFaceUpCards().iterator();

        boolean first = true;

        while (faceDownIterator.hasNext()) {

            Card card = faceDownIterator.next();
            if (card != null && card instanceof SimpleGFXCard) {
                if (first) {
                    ((SimpleGFXCard) card).setCardStatus(SimpleGFXCard.CardStatus.FACEDOWN);
                    first = false;
                } else {
                    ((SimpleGFXCard) card).setCardStatus(SimpleGFXCard.CardStatus.HIDDEN);
                }
            }
        }

        first = true;

        while (faceUpIterator.hasNext()) {

            Card card = faceUpIterator.next();
            if (card != null && card instanceof SimpleGFXCard) {
                if (first) {
                    ((SimpleGFXCard) card).setCardStatus(SimpleGFXCard.CardStatus.VISIBLE);
                    first = false;
                } else {
                    ((SimpleGFXCard) card).setCardStatus(SimpleGFXCard.CardStatus.HIDDEN);
                }
            }
        }

    }




}
