package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.RepresentableGameObject;
import org.academiadecodigo.jungleweed.logic.LogicEngine;
import org.academiadecodigo.jungleweed.player.PlayerFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

/**
 * Created by codecadet on 1/29/17.
 */
public class SimpleGfxIndicator {

    private Ellipse circle;
    private int x;
    private int y;

    public SimpleGfxIndicator(int turn) {
        circle = new Ellipse(PlayerFactory.playerPositionX[turn], PlayerFactory.playerPositionY[turn], 50, 50);
        circle.setColor(Color.GREEN);
        circle.fill();
    }


    public void draw() {
        circle.fill();
    }

    public void hide() {
        circle.delete();
    }

    public void setPosition(int turn) {
        circle = new Ellipse(PlayerFactory.playerPositionX[turn], PlayerFactory.playerPositionY[turn], 50, 50);
        circle.setColor(Color.GREEN);
    }
}
