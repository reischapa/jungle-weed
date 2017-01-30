package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.AbstractRepresentable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/30/17.
 */
public class SGFXEndScreen extends AbstractRepresentable {
    private Picture picture;

    public SGFXEndScreen() {
        this.picture = new Picture(10, 10, "res/ENDSCREEN.jpeg");
    }

    @Override
    public void draw() {
        this.picture.translate(this.getX() - this.picture.getX(), this.getY() - this.picture.getY());
        this.picture.draw();
    }

    @Override
    public void hide() {
        if (this.picture != null) {
            picture.delete();
        }
    }
}
