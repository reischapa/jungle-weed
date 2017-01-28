package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.RepresentableGameObject;
import org.academiadecodigo.jungleweed.LogicEngine.LogicEngine;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by chapa on 1/28/2017.
 */
public class Table extends RepresentableGameObject {

    private Picture picture;
    private String pictureFileName;

    public Table(LogicEngine logicEngine) {
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
