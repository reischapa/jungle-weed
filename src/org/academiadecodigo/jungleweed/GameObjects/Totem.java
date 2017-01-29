package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.AbstractRepresentable;

/**
 * Created by codecadet on 1/29/17.
 */
public class Totem extends AbstractRepresentable {

    @Override
    public void draw() {
        System.out.println("the totem has been drawn");
    }

    @Override
    public void hide() {
        System.out.println("the totem has been hidden");
    }

}
