package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.Indicator;

/**
 * Created by codecadet on 1/29/17.
 */
public class PlayerTurnIndicator implements Indicator{

    private int playerTurn;

    private int x;
    private int y;

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void draw() {
    }

    public void hide() {
        System.out.println();
    }

    @Override
    public void setProperty(int value) {

    }
}
