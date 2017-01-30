package org.academiadecodigo.jungleweed.sgfxgameobjects;

import org.academiadecodigo.jungleweed.gameobjectsframework.AbstractRepresentable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/30/17.
 */
public class SGFXTitleScreen extends AbstractRepresentable {

    private Picture picture;

    public SGFXTitleScreen() {
        this.setX(10);
        this.setY(10);
        this.picture = new Picture(this.getX(), this.getY(), "res/TITLESCREEN.png");
    }

    @Override
    public void draw() {
       this.picture.draw();
    }

    @Override
    public void hide() {
        if (this.picture != null) {
            picture.delete();
        }
    }
}
