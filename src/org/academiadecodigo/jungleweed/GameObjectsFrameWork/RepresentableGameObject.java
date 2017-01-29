package org.academiadecodigo.jungleweed.GameObjectsFrameWork;

import org.academiadecodigo.jungleweed.logic.LogicEngine;

/**
 * Created by chapa on 1/28/2017.
 */
public abstract class RepresentableGameObject implements Representable  {

    private int x;
    private int y;
    private LogicEngine logicEngine;

    public RepresentableGameObject(LogicEngine logicEngine, int x, int y) {
        this.x = x;
        this.y = y;
        this.logicEngine = logicEngine;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public LogicEngine getLogicEngine() {
        return this.logicEngine;
    }

    public abstract void draw();

    public abstract void hide();

}
