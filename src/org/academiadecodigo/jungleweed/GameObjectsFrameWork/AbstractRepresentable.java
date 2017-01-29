package org.academiadecodigo.jungleweed.GameObjectsFrameWork;

/**
 * Created by codecadet on 1/29/17.
 */
public abstract class AbstractRepresentable implements Representable {

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
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    public abstract void draw();

    public abstract void hide();

}
