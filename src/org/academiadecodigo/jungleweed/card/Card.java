package org.academiadecodigo.jungleweed.card;

import org.academiadecodigo.jungleweed.Drawable;

/**
 * Created by codecadet on 1/22/17.
 */
public class Card {

    private CardShape shape;
    private CardColor color;
    private boolean visible;
    private int xFaceUp;
    private int yFaceUp;
    private int xFaceDown;
    private int yFaceDown;

    public Card(CardShape shape, CardColor color) {
        this.shape = shape;
        this.color = color;
    }

    public void turn(){
       visible = !visible;
    }

    public void setXFaceUp(int x) {
        this.xFaceUp = x;
    }

    public void setYFaceUp(int y) {
        this.yFaceUp = y;
    }

    public void setXFaceDown(int y) {
        this.xFaceDown = y;
    }

    public void setYFaceDown(int x) {
        this.yFaceDown = x;
    }

    public CardColor getColor() {
        return color;
    }

    public CardShape getShape() {
        return shape;
    }

    public boolean isVisible() {
        return visible;
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
