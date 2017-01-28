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
    private int maxCards;
    private Iterator<Player> iterator;



    public PlayerFactory(int nPlayers, int maxCards) {
        this.nPlayers = nPlayers;
        this.maxCards = maxCards;
        this.playerList = new LinkedList<>();
        this.init();

    }

    private void init() {

        playerList.add(new PlayerList(this.maxCards, 48, 470, 48, 290));
        playerList.add(new PlayerList(this.maxCards, 640, 30, 820, 30));
        playerList.add(new PlayerList(this.maxCards, 1412, 290, 1412, 470));
        playerList.add(new PlayerList(this.maxCards, 820, 725, 640, 725));

        this.iterator = playerList.iterator();

    }

    public Player getNextPlayer() {
        if (!this.iterator.hasNext()) {
            this.iterator = playerList.iterator();
        }

        return this.iterator.next();


    }

}
