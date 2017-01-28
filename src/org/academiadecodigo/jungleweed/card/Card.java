package org.academiadecodigo.jungleweed.card;


/**
 * Created by codecadet on 1/22/17.
 */
public class Card {


    public enum CardStatus {
        VISIBLE,FACEDOWN,HIDDEN
    }


    private CardShape shape;
    private CardColor color;
    private int xFaceUp;
    private int yFaceUp;
    private int xFaceDown;
    private int yFaceDown;

    private CardStatus cardStatus;

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Card(CardShape shape, CardColor color) {
        this.cardStatus = CardStatus.VISIBLE;
        this.shape = shape;
        this.color = color;
    }

    public void setXFaceUp(int x) {
        this.xFaceUp = x;
    }

    public void setYFaceUp(int y) {
        this.yFaceUp = y;
    }

    public void setXFaceDown(int x) {
        this.xFaceDown = x;
    }

    public void setYFaceDown(int y) {
        this.yFaceDown = y;
    }

    public CardColor getColor() {
        return color;
    }

    public CardShape getShape() {
        return shape;
    }


    public int getxFaceUp() {
        return xFaceUp;
    }

    public int getyFaceUp() {
        return yFaceUp;
    }

    public int getxFaceDown() {
        return xFaceDown;
    }

    public int getyFaceDown() {
        return yFaceDown;
    }

    @Override
    public String toString() {
        return shape.toString() + " " + color.toString();
    }
}
