package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.AbstractRepresentable;

/**
 * Created by codecadet on 1/30/17.
 */
public class EndScreen extends AbstractRepresentable {
    @Override
    public void draw() {
        System.out.println("GAME OVER MAN, GAME OVER!!!");
    }

    @Override
    public void hide() {

    }
}
