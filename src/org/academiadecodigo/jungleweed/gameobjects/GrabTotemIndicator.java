package org.academiadecodigo.jungleweed.gameobjects;

import org.academiadecodigo.jungleweed.gameobjectsframework.AbstractIndicator;

/**
 * Created by codecadet on 1/29/17.
 */
public class GrabTotemIndicator extends AbstractIndicator {

    @Override
    public void draw() {
        System.out.println("Player " + this.getProperty() + " has grabbed the totem!!");
    }

    @Override
    public void hide() {
    }
}
