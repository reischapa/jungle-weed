package org.academiadecodigo.jungleweed.gameobjects;

import org.academiadecodigo.jungleweed.gameobjectsframework.AbstractRepresentable;

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
