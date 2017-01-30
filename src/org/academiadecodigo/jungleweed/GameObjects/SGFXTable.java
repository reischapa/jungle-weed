package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.AbstractRepresentable;
import org.academiadecodigo.jungleweed.GameObjectsFrameWork.Representable;
import org.academiadecodigo.jungleweed.logic.LogicEngine;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by chapa on 1/28/2017.
 */
public class SGFXTable extends AbstractRepresentable{

    public static final int X_PADDING = 10;
    public static final int Y_PADDING = 10;




    private Picture picture;

    public SGFXTable() {
        this.picture = new Picture(X_PADDING, Y_PADDING, "res/BACKGROUND.JPEG");
    }


    @Override
    public void draw() {
        this.picture.draw();
    }

    @Override
    public void hide() {
        this.picture.delete();
    }
}
