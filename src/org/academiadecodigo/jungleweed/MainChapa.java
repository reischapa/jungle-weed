package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.CardFactory;
import org.academiadecodigo.jungleweed.card.CardShape;
import org.academiadecodigo.jungleweed.player.Player;

/**
 * Created by codecadet on 1/22/17.
 */
public class MainChapa {


    public static void main(String[] args) throws Exception {
        playerTests();
    }

    public static void playerTests() throws Exception {
        Card[] cards = new Card[10];

        for (int i = 0; i < 10; i++) {
            cards[i] = new Card(CardShape.CIRCLE1);
        }

        Player p = new Player(20);

        p.receiveCards(cards);

        if (p.getTotalNumberOfCards() != 10 ){
            throw new Exception();
        }

        p.printFaceDownCards();
        System.out.println("");
        p.printRevealedCards();

        p.revealNextCard();

        if (p.getFaceUpCard()==null) {
            throw new Exception();
        }


        System.out.println("");
        p.printFaceDownCards();
        System.out.println("");
        p.printRevealedCards();


        p.receiveCards(cards);
        p.revealNextCard();

        System.out.println("");
        p.printFaceDownCards();
        System.out.println("");
        p.printRevealedCards();

        Card[] c2 = p.giveCards();


        Player p2 = new Player(c2);

        if (p2.getTotalNumberOfCards() != 2) {
            throw new Exception();
        }

        p2.revealNextCard();
        p2.revealNextCard();
        p2.giveCards();

        System.out.println(p2.isEmptyFaceDown());
        System.out.println(p2.getTotalNumberOfCards());


        //TESTING THE NEW AND IMPROVED CARD FACTORY

        CardFactory cf = new CardFactory(CardShape.values(), CardColor.values());

        System.out.println(cf.getACard());


    }


}
