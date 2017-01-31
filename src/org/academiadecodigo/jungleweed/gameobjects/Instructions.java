package org.academiadecodigo.jungleweed.gameobjects;

import org.academiadecodigo.jungleweed.gameobjectsframework.AbstractRepresentable;

/**
 * Created by codecadet on 1/31/17.
 */
public class Instructions extends AbstractRepresentable {
    @Override
    public void draw() {
        System.out.println("P1 controls: 1 to Turn Cards, 2 to Grab Totem.");
        System.out.println("P2 controls: 0 to Turn Cards, 9 to Grab Totem.");
        System.out.println("P3 controls: M to Turn Cards, N to Grab Totem.");
        System.out.println("P4 controls: Z to Turn Cards, x to Grab Totem.");
        System.out.println("Press space to start, right arrow to exit, left arrow to reset.");
    }

    @Override
    public void hide() {

    }
}
