package org.academiadecodigo.jungleweed.card;

import org.academiadecodigo.jungleweed.Utils;

/**
 * Created by codecadet on 1/22/17.
 */
public class CardFactory {


    public static Card getNextCard(CardShape shape, CardColor color) {
        return null;
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

   //TODO make this not static
}
