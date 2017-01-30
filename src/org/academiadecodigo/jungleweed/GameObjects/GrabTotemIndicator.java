package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.AbstractIndicator;

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
