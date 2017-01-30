package org.academiadecodigo.jungleweed.player;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 1/22/17.
 */
public class SGFXPlayerFactory extends PlayerFactory {
    public static final int[] faceUpPositionX = {30, 380, 550, 200};
    public static final int[] faceUpPositionY = {210, 30 , 390, 550};
    public static final int[] faceDownPositionX = {30 , 200, 550, 380 };
    public static final int[] faceDownPositionY = {390 , 30, 210, 550 };

    private int nPlayers;

    private List<SGFXPlayer> playerList;
    private Iterator<SGFXPlayer> iterator;


    public SGFXPlayerFactory(int nPlayers) {
        this.nPlayers = nPlayers;
        this.playerList = new LinkedList<>();
        this.addPlayersToPlayerList();

    }

    private void addPlayersToPlayerList() {

        if (this.nPlayers > 4 || this.nPlayers < 2) {
            throw new UnsupportedOperationException();
        }

        for (int i = 0; i < this.nPlayers; i++) {
            playerList.add(this.getPlayerAtPosition(i));
        }

        this.iterator = playerList.iterator();

    }

    public SGFXPlayer getNextPlayer() {
        if (!this.iterator.hasNext()) {
            this.iterator = this.playerList.iterator();
        }

        return this.iterator.next();
    }



    private SGFXPlayer getPlayerAtPosition(int index) {

        return new SGFXPlayer(faceUpPositionX[index], faceUpPositionY[index], faceDownPositionX[index], faceDownPositionY[index]);
    }


}
