package org.academiadecodigo.jungleweed.card;

/**
 * Created by codecadet on 1/22/17.
 */
public class Card {

    private CardShape shape;
    private CardColor color;

    public Card(CardShape shape, CardColor color) {
        this.shape = shape;
        this.color = color;
    }

    public Card(CardShape shape) {
        this.shape = shape;
        this.color = CardColor.BLUE;
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
}
