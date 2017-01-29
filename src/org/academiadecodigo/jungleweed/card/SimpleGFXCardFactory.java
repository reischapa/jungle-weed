package org.academiadecodigo.jungleweed.card;

import org.academiadecodigo.jungleweed.Game;
import org.academiadecodigo.jungleweed.GameObjects.SimpleGFXCard;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by codecadet on 1/22/17.
 */
public class SimpleGFXCardFactory {

    private CardShape[] allowedShapes;
    private CardColor[] allowedColors;

    private Stack<Card> readyCards;

    private Game game;

    public SimpleGFXCardFactory(CardShape[] allowedShapes, CardColor[] allowedColors ) {

        this.allowedShapes = allowedShapes;
        this.allowedColors = allowedColors;
        this.readyCards = new Stack<>();
        this.createDeck();

        this.game = game;
    }

    private void createDeck() {

        for (int i = 0; i < this.allowedShapes.length; i++) {
            for (int j = 0; j < this.allowedColors.length; j++) {

                SimpleGFXCard sgfx = new SimpleGFXCard(this.allowedShapes[i], this.allowedColors[j]);
                this.readyCards.push(sgfx);

            }
        }

        Collections.shuffle(this.readyCards);
    }


    public Card[] getNCards(int n) {
        if (n > this.readyCards.size()) {
            System.out.println("That dont work");
            throw new NullPointerException();
        }

        Card[] result = new Card[n];

        for (int i = 0; i < result.length; i++) {
            result[i] =  this.readyCards.pop();
        }

        return result;
    }


    public Card getACard() {
        if (this.readyCards.size() == 0) {
            System.out.println("That dont work");
            throw new NullPointerException();
        }

        return this.readyCards.pop();

    }


}
