package org.academiadecodigo.jungleweed.player;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 1/22/17.
 */
public class SGFXPlayerFactory extends PlayerFactory {
    public static final int[] faceUpPositionX = {48, 640, 1412, 820};
    public static final int[] faceUpPositionY = {470, 30, 290, 725};
    public static final int[] faceDownPositionX = {48, 820, 1412, 640};
    public static final int[] faceDownPositionY = {290, 30, 470, 725};

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

        switch (this.nPlayers) {
            case (2):
                playerList.add(this.getPlayerAtPosition(0));
                playerList.add(this.getPlayerAtPosition(1));
            case 3:
                playerList.add(this.getPlayerAtPosition(0));
                playerList.add(this.getPlayerAtPosition(1));
                playerList.add(this.getPlayerAtPosition(2));
            case 4:
                for (int i = 0; i < 4; i++) {
                    playerList.add(this.getPlayerAtPosition(i));
                }
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
        return new SGFXPlayer(faceUpPositionX[index],
                                faceUpPositionY[index],
                                    faceDownPositionX[index],
                                        faceDownPositionY[index]);
    }


}
