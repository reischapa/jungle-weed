package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.AbstractRepresentable;
import org.academiadecodigo.jungleweed.GameObjectsFrameWork.Representable;

/**
 * Created by codecadet on 1/29/17.
 */
public class Table extends AbstractRepresentable {

    @Override
    public void draw() {
        System.out.println("the table has been drawn");
    }

    @Override
    public void hide() {
        System.out.println("the table has been hidden");
    }
}
