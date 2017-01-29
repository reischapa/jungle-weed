package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.RepresentableGameObject;
import org.academiadecodigo.jungleweed.logic.LogicEngine;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/27/17.
 */
public class SimpleGFXTotem extends RepresentableGameObject {

    private Picture picture;
    private String pictureFileName;

    public SimpleGFXTotem(LogicEngine logicEngine) {
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
