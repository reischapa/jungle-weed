package org.academiadecodigo.jungleweed.card;


/**
 * Created by codecadet on 1/22/17.
 */
public class Card {


    private CardShape shape;
    private CardColor color;

    private int xFaceUp;
    private int yFaceUp;
    private int xFaceDown;
    private int yFaceDown;


    private boolean isFaceUp;

    public Card(CardShape shape, CardColor color) {
        this.shape = shape;
        this.color = color;
    }

    public CardColor getColor() {
        return color;
    }

    public CardShape getShape() {
        return shape;
    }

    @Override
    public String toString() {
        return shape.toString() + " " + color.toString();
    }

    public void draw() {
        //System.out.println("Cut my life into pieces");
    }

    public void hide() {
        //System.out.println("This is my last resort");
    }

    public void turn() {
        isFaceUp = !isFaceUp;
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


    public int getXFaceUp() {
        return xFaceUp;
    }

    public int getYFaceUp() {
        return yFaceUp;
    }

    public int getXFaceDown() {
        return xFaceDown;
    }

    public int getYFaceDown() {
        return yFaceDown;
    }


    public boolean isFaceUp() {
        return isFaceUp;
    }



}

