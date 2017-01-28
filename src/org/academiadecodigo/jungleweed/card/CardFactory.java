package org.academiadecodigo.jungleweed.card;

import org.academiadecodigo.jungleweed.HD_Grafiks_2_0.SimpleGfxCard;
import org.academiadecodigo.jungleweed.Utils;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by codecadet on 1/22/17.
 */
public class CardFactory {

    private CardShape[] allowedShapes;
    private CardColor[] allowedColors;

    private Stack<Card> readyCards;

    public CardFactory(CardShape[] allowedShapes, CardColor[] allowedColors ) {

        this.allowedShapes = allowedShapes;
        this.allowedColors = allowedColors;
        this.readyCards = new Stack<>();
        this.createDeck();

    }

    private void createDeck() {

        for (int i = 0; i < this.allowedShapes.length; i++) {
            for (int j = 0; j < this.allowedColors.length; j++) {

                SimpleGfxCard sgfx = new SimpleGfxCard(this.allowedShapes[i], this.allowedColors[j]);
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

        return  this.readyCards.pop();

    }

}
