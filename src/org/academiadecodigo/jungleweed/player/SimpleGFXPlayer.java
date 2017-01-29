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

        for (int i = 0; i < cards.length; i++) {
            if (cards[i] instanceof SimpleGFXCard) {
                if (i == 0) {
                    ((SimpleGFXCard) cards[i]).setCardStatus(SimpleGFXCard.CardStatus.VISIBLE);
                } else {
                    ((SimpleGFXCard) cards[i]).setCardStatus(SimpleGFXCard.CardStatus.HIDDEN);
                }
                this.setCoordinates( (SimpleGFXCard) cards[i] );

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
       if(input.getCardStatus() == SimpleGFXCard.CardStatus.VISIBLE) {
           while (input.getXFaceUp() != this.xFaceDown && input.getYFaceUp() != this.yFaceDown) {
               System.out.println(input.getXFaceUp());
               if (this.xFaceDown > input.getXFaceUp() && this.yFaceDown < input.getYFaceUp()) {
                   input.setXFaceUp(input.getXFaceUp() + 2);
                   input.setYFaceUp(input.getYFaceUp() - 2);
               } else if (this.xFaceDown > input.getXFaceUp() && this.yFaceDown > input.getYFaceUp()){
                   input.setXFaceUp(input.getXFaceUp() + 2);
                   input.setYFaceUp(input.getYFaceUp() + 2);
               }else if(this.xFaceDown < input.getXFaceUp() && this.yFaceDown > input.getYFaceUp()){
                   input.setXFaceUp(input.getXFaceUp() - 2);
                   input.setYFaceUp(input.getYFaceUp() + 2);
               }else{
                   input.setXFaceUp(input.getXFaceUp() - 2);
                   input.setYFaceUp(input.getYFaceUp() - 2);
               }
               try {
                   Thread.sleep(20);
               } catch (Exception e) {
                   e.printStackTrace();
               }
               input.draw();
           }
       }
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
