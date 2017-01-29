package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.AbstractIndicator;
import org.academiadecodigo.jungleweed.GameObjectsFrameWork.Indicator;

/**
 * Created by codecadet on 1/29/17.
 */
public class PlayerTurnIndicator  extends AbstractIndicator{


    @Override
    public void draw() {
        System.out.println("the current player turn is " + this.getProperty());
    }

    @Override
    public void hide() {
        System.out.println("The indicator has been hidden");
    }

}
