package org.academiadecodigo.jungleweed.gameobjects;

import org.academiadecodigo.jungleweed.gameobjectsframework.AbstractRepresentable;

/**
 * Created by codecadet on 1/29/17.
 */
public class TotemStandingUp extends AbstractRepresentable {

    @Override
    public void draw() {
        System.out.println("The totem has been put in the table.");
    }

    @Override
    public void hide() {
        System.out.println("The totem has been grabbed!");
    }

}
