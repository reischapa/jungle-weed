package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.RepresentableGameObject;
import org.academiadecodigo.jungleweed.LogicEngine.LogicEngine;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/27/17.
 */
public class Totem extends RepresentableGameObject {

    private Picture picture;
    private String pictureFileName;

    public Totem(LogicEngine logicEngine) {
        super(logicEngine,800,450);
        this.pictureFileName = "res/TOTEM.jpeg";
    }


    public void draw() {
        this.picture = new Picture(this.getX(), this.getY(), this.pictureFileName);
        this.picture.draw();
    }

    public void hide() {
        this.picture.delete();
    }
}
