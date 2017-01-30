package org.academiadecodigo.jungleweed.gameobjects;

import org.academiadecodigo.jungleweed.gameobjectsframework.AbstractIndicator;
import org.academiadecodigo.jungleweed.gameobjectsframework.AbstractRepresentable;

/**
 * Created by codecadet on 1/30/17.
 */
public class EndScreenIndicator extends AbstractIndicator {
    @Override
    public void draw() {
        System.out.println("Player " + (this.getProperty() + 1) + " wins!!");
    }

    @Override
    public void hide() {

    }
}
