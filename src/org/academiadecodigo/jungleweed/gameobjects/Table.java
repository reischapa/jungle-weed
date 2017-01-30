package org.academiadecodigo.jungleweed.gameobjects;

import org.academiadecodigo.jungleweed.gameobjectsframework.AbstractRepresentable;

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
