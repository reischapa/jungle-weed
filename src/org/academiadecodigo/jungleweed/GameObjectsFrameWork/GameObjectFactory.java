package org.academiadecodigo.jungleweed.GameObjectsFrameWork;

import org.academiadecodigo.jungleweed.Game;
import org.academiadecodigo.jungleweed.GameObjects.Table;
import org.academiadecodigo.jungleweed.GameObjects.Totem;

/**
 * Created by codecadet on 1/29/17.
 */
public class GameObjectFactory {


    public Representable getRepresentableOfType(Game.RepresentableType type) {
        switch (type) {
            case TOTEM:
                return new Totem();
            case TABLE:
                return new Table();
            default:
                System.out.println("DEU MERDA");
                return null;
        }
    }


    public Indicator getIndicatorOfType(Game.IndicatorType type) {
        return null;
    }


}
