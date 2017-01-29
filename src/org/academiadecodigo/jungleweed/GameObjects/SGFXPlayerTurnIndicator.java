package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.AbstractIndicator;
import org.academiadecodigo.jungleweed.GameObjectsFrameWork.Indicator;
import org.academiadecodigo.jungleweed.player.SGFXPlayerFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

/**
 * Created by codecadet on 1/29/17.
 */
public class SGFXPlayerTurnIndicator extends AbstractIndicator {

    private Ellipse circle;
    private int x;
    private int y;

    public SGFXPlayerTurnIndicator() {
        circle = new Ellipse(0, 0, 50, 50);
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
        super.setProperty(value);
        circle = new Ellipse(SGFXPlayerFactory.faceUpPositionX[this.getProperty()], SGFXPlayerFactory.faceUpPositionY[this.getProperty()], 50, 50);
        circle.setColor(Color.GREEN);
    }

    @Override
    public int getProperty() {
        return super.getProperty();
    }
}
