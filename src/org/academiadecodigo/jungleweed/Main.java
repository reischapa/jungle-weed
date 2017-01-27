package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardFactory;

/**
 * Created by codecadet on 1/22/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("AGARRA O PAU GAME START");
        Game game = new Game(4,80);
        game.init();
        game.start();
        int rounds = 0;
        //game.grabTotem(0);
        while(!game.getGameEnd()) {
            game.getPlayerFaceUpCard(0);
            game.getPlayerFaceUpCard(1);
            game.getPlayerFaceUpCard(2);
            game.getPlayerFaceUpCard(3);
            game.grabTotem(0);
            rounds++;

        }
        System.out.println("ROUNDS:" + rounds);

        System.out.println("Acabou crlh!");
    }

}
