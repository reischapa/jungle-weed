package org.academiadecodigo.jungleweed.sgfxgameobjects;

import org.academiadecodigo.jungleweed.gameobjectsframework.AbstractIndicator;
import org.academiadecodigo.jungleweed.player.SGFXPlayerFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/29/17.
 */
public class SGFXPlayerTurnIndicator extends AbstractIndicator {

    private Picture picture;

    public void draw() {
//        if (this.picture == null) {
            this.picture = new Picture(SGFXPlayerFactory.faceUpPositionX[this.getProperty()], SGFXPlayerFactory.faceUpPositionY[this.getProperty()], "res/PLAYERINDICATOR.png");
//        }

        this.picture.draw();
    }

    public void hide() {
        if (this.picture != null) {
            this.picture.delete();
        }
    }


}
