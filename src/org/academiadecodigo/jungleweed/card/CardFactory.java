package org.academiadecodigo.jungleweed.card;

import org.academiadecodigo.jungleweed.HD_Grafiks_2_0.SimpleGfxCard;
import org.academiadecodigo.jungleweed.HD_Grafiks_2_0.SimpleGfxTable;
import org.academiadecodigo.jungleweed.Utils;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by codecadet on 1/22/17.
 */
public class CardFactory {


    public static Card getNextCard(CardShape shape, CardColor color) {
        return new Card(shape, color);
    }


    public static Card getRandomCard() {
        int randomShape = Utils.getBoundedRandomInt(0,CardShape.values().length - 1);
        int randomColor = Utils.getBoundedRandomInt(0,CardColor.values().length - 1);

        Card newCard = new Card(CardShape.values()[randomShape], CardColor.values()[randomColor]);

        return newCard;
    }

    public static Card[] getCardDeck(int maxNrCards){

        Card[] deckCards = new Card[maxNrCards];

        for(int i = 0; i < maxNrCards; i++){
            deckCards[i] = getRandomCard();
        }
        return deckCards;
    }

    //TODO implement this in game
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

                SimpleGfxCard sgfx = new SimpleGfxCard(this.allowedShapes[i], this.allowedColors[i]);
                Card c = new Card(this.allowedShapes[i], this.allowedColors[j], sgfx);
                this.readyCards.push(c);

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
            result[i] = (Card) this.readyCards.pop();
        }

        return result;
    }


    public Card getACard() {
        if (this.readyCards.size() == 0) {
            System.out.println("That dont work");
            throw new NullPointerException();
        }

        return (Card) this.readyCards.pop();

    }

}
