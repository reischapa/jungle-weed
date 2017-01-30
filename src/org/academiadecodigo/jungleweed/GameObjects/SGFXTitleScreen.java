package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.AbstractRepresentable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/30/17.
 */
public class SGFXTitleScreen extends AbstractRepresentable {

    private Picture picture;

    public SGFXTitleScreen() {
        this.picture = new Picture(0, 0, "res/TITLESCREEN.jpeg");
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
