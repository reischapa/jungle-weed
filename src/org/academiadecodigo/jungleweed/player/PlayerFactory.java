package org.academiadecodigo.jungleweed.player;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 1/22/17.
 */
public class PlayerFactory {

    private int nPlayers;

    private List<Player> playerList;
    private Iterator<Player> iterator;



    public PlayerFactory(int nPlayers) {
        this.nPlayers = nPlayers;
        this.playerList = new LinkedList<>();
        this.init();

    }

    private void init() {

        playerList.add(new SimpleGFXPlayer(50, 470, 50, 290));
        playerList.add(new SimpleGFXPlayer(640, 30, 820, 30));
        playerList.add(new SimpleGFXPlayer(1410, 290, 1410, 470));
        playerList.add(new SimpleGFXPlayer(820, 720, 640, 720));

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
