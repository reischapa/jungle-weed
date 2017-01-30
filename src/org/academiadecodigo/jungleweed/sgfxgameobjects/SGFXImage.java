package org.academiadecodigo.jungleweed.sgfxgameobjects;

import org.academiadecodigo.jungleweed.gameobjectsframework.AbstractRepresentable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/30/17.
 */
public class SGFXImage extends AbstractRepresentable {

    private String path;
    private Picture picture;

    public SGFXImage(String path, int initX, int initY) {
        this.path = path;
        this.setX(initX);
        this.setY(initY);
    }



    @Override
    public void draw() {
        if (this.picture == null) {
            this.picture = new Picture(this.getX(), this.getY(), this.path);
        }
        this.picture.draw();
    }

    @Override
    public void hide() {
        if (this.picture != null) {
            picture.delete();
        }
    }
}
