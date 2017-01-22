package org.academiadecodigo.jungleweed.player;

/**
 * Created by codecadet on 1/22/17.
 */
public class PlayerFactory {


    public static Player getNewPlayer() {
        //TODO
        return new Player(100);
    }

    public static Player getNewPlayer(int maxCards){
        return new Player(maxCards);
    }

}
