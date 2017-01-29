package org.academiadecodigo.jungleweed.player;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 1/22/17.
 */
public class PlayerFactory {
    public static final int[] playerPositionX = {48, 640, 1412, 820};
    public static final int[] playerPositionY = {470, 30, 290, 725};


    private int nPlayers;

    private List<Player> playerList;
    private Iterator<Player> iterator;



    public PlayerFactory(int nPlayers) {
        this.nPlayers = nPlayers;
        this.playerList = new LinkedList<>();
        this.init();

    }

    private void init() {

        playerList.add(new SimpleGFXPlayer(48, 470, 48, 290));
        playerList.add(new SimpleGFXPlayer(640, 30, 820, 30));
        playerList.add(new SimpleGFXPlayer(1412, 290, 1412, 470));
        playerList.add(new SimpleGFXPlayer(820, 725, 640, 725));

        this.iterator = playerList.iterator();

    }

    public Player getNextPlayer() {
        if (!this.iterator.hasNext()) {
            this.iterator = playerList.iterator();
        }

        return this.iterator.next();

    }

    public int getNPlayers() {
        return this.nPlayers;
    }

}
