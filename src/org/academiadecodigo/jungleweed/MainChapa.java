package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardColor;
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
            cards[i] = new Card(CardShape.CIRCLE1, CardColor.GREEN);
        }

        Player p = new Player();


        p.addCards(cards);

        if (p.getTotalNumberOfCards() != 10 ){
            throw new Exception();
        }

        p.printFaceDownCards();
        System.out.println("");
        p.printRevealedCards();

        System.out.println("");
        System.out.println(p.getNumberFaceDownCards());
        System.out.println(p.getNumberRevealedCards());
        System.out.println("");

        p.revealNextCard();

        System.out.println("");
        System.out.println(p.getNumberFaceDownCards());
        System.out.println(p.getNumberRevealedCards());
        System.out.println("");

        if (p.getFaceUpCard()==null) {
            throw new Exception();
        }


        System.out.println("");
        p.printFaceDownCards();
        System.out.println("");
        p.printRevealedCards();

        p.addCards(cards);
        p.revealNextCard();

        System.out.println("");
        p.printFaceDownCards();
        System.out.println("");
        p.printRevealedCards();

        Card[] c2 = p.giveCards();


        Player p2 = new Player();

        p2.addCards(c2);

        if (p2.getTotalNumberOfCards() != 2) {
            throw new Exception();
        }

        p2.revealNextCard();
        p2.revealNextCard();
        p2.giveCards();

        System.out.println(p2.isEmptyFaceDown());
        System.out.println(p2.getTotalNumberOfCards());

        System.out.println("");
        System.out.println(p2.getNumberFaceDownCards());
        System.out.println(p2.getNumberRevealedCards());
        System.out.println("");

        //TESTING THE NEW AND IMPROVED CARD FACTORY

//        SGFXCardFactory cf = new SGFXCardFactory(CardShape.values(), CardColor.values());
//
//        System.out.println(cf.getACard());


    }


}
