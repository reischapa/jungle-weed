package org.academiadecodigo.jungleweed.sgfxgameobjects;

import org.academiadecodigo.jungleweed.gameobjectsframework.AbstractIndicator;
import org.academiadecodigo.jungleweed.gameobjectsframework.AbstractRepresentable;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/30/17.
 */
public class SGFXEndScreenIndicator extends AbstractIndicator {
    private Picture picture;
    private Text text;

    public SGFXEndScreenIndicator() {
        this.setX(10);
        this.setY(10);
    }

    @Override
    public void draw() {
        this.picture = new Picture(this.getX(), this.getY(), "res/ENDSCREEN.jpeg");
        this.picture.draw();
    }

    @Override
    public void hide() {
        if (this.picture != null) {
            picture.delete();
        }
    }
}
