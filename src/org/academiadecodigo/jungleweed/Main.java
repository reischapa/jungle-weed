package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardFactory;

/**
 * Created by codecadet on 1/22/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("solanum tuberosum");
        Game game = new Game();
        game.init();
        game.start();
        System.out.println("Acabou crlh!");
    }

}
