package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.CardShape;
import org.academiadecodigo.jungleweed.player.Player;

/**
 * Created by codecadet on 1/22/17.
 */
public class MainChapa {



    public static void main(String[] args) {

        Card[] cards = new Card[10];

        for (int i = 0; i < 10; i++) {
            cards[i] = new Card(CardShape.CIRCLE1);
        }

        Player p = new Player(20);

        p.receiveCards(cards);

        p.printFaceDownCards();
        System.out.println("");
        p.printRevealedCards();

        int i = 0;

        while (i < 10) {
            p.revealNextCard();
            i++;
        }

        System.out.println("");

        p.printFaceDownCards();
        System.out.println("");
        p.printRevealedCards();


        Card[] c = p.giveCards();







    }


}
