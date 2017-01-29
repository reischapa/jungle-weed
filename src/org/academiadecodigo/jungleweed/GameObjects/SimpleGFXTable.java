package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.RepresentableGameObject;
import org.academiadecodigo.jungleweed.logic.LogicEngine;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by chapa on 1/28/2017.
 */
public class SimpleGFXTable extends RepresentableGameObject {

    private Picture picture;
    private String pictureFileName;

    public SimpleGFXTable(LogicEngine logicEngine) {
        super(logicEngine,10,10);
        this.pictureFileName = "res/TOTEM.jpeg";
    }


    @Override
    public void draw() {

    }

    @Override
    public void hide() {

    }
}
