package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.logic.LogicEngine;
import org.academiadecodigo.jungleweed.player.PlayerFactory;

/**
 * Created by codecadet on 1/22/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("AGARRA O PAU GAME START");
        LogicEngine logicEngine = new LogicEngine(new PlayerFactory(4));
        logicEngine.init();
        logicEngine.start();
        int rounds = 0;
        //logicEngine.grabTotem(0);
        while(!logicEngine.getGameEnd()) {
            logicEngine.getPlayerFaceUpCard(0);
            logicEngine.getPlayerFaceUpCard(1);
            logicEngine.getPlayerFaceUpCard(2);
            logicEngine.getPlayerFaceUpCard(3);
            logicEngine.grabTotem(0);
            rounds++;

        }
        System.out.println("ROUNDS:" + rounds);

        System.out.println("Acabou crlh!");
    }

}
