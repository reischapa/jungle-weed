package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.Indicator;
import org.academiadecodigo.jungleweed.logic.LogicEngine;
import org.academiadecodigo.jungleweed.player.PlayerFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

/**
 * Created by codecadet on 1/29/17.
 */
public class SGFXPlayerTurnIndicator implements Indicator {

    private Ellipse circle;
    private int x;
    private int y;

    public SGFXPlayerTurnIndicator(int turn) {
        circle = new Ellipse(PlayerFactory.playerPositionX[turn], PlayerFactory.playerPositionY[turn], 50, 50);
        circle.setColor(Color.GREEN);
    }


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
        circle.fill();
    }

    public void hide() {
        circle.delete();
    }

    @Override
    public void setProperty(int value) {
        circle = new Ellipse(PlayerFactory.playerPositionX[value], PlayerFactory.playerPositionY[value], 50, 50);
        circle.setColor(Color.GREEN);
    }
}
