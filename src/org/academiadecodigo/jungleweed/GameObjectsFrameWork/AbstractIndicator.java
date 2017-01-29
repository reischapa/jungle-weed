package org.academiadecodigo.jungleweed.GameObjectsFrameWork;

/**
 * Created by codecadet on 1/29/17.
 */
public abstract class AbstractIndicator extends AbstractRepresentable implements Indicator {

    private int property;

    public void setProperty(int value) {
        this.property = value;
    }

    public int getProperty() {
        return this.property;
    }

    public abstract void draw();


    public abstract void hide();


}
