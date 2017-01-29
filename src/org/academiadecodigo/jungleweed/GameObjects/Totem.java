package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.Representable;

/**
 * Created by codecadet on 1/29/17.
 */
public class Totem implements Representable {

    private int x;
    private int y;


    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void draw() {
        System.out.println("the totem has been drawn");
    }

    @Override
    public void hide() {
        System.out.println("the totem has been hidden");
    }

}
