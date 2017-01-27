package org.academiadecodigo.jungleweed.card;

import org.academiadecodigo.jungleweed.Drawable;

/**
 * Created by codecadet on 1/22/17.
 */
public class Card {

    private CardShape shape;
    private CardColor color;
    private Drawable drawableCard;
    private int x;
    private int y;

    public Card(CardShape shape, CardColor color, Drawable drawableCard) {
        this.shape = shape;
        this.color = color;
        this.drawableCard = drawableCard;
    }

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
        drawableCard.draw();
        drawableCard.setX(20);
        drawableCard.setY(20);

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void clear() {
        drawableCard.clear();
    }
}
