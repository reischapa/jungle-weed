package org.academiadecodigo.jungleweed.GameObjectsFrameWork;

import org.academiadecodigo.jungleweed.Game;
import org.academiadecodigo.jungleweed.GameObjects.*;

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
            case TITLESCREEN:
                return new TitleScreen();
            case ENDSCREEN:
                return new EndScreen();
            default:
                System.out.println("DEU MERDA");
                return new Totem();
        }
    }


    public Indicator getIndicatorOfType(Game.IndicatorType type) {
        switch (type) {
            case CURRENTPLAYER:
                return new PlayerTurnIndicator();
            case GRABTOTEM:
                return new GrabTotemIndicator();
            default:
                System.out.println("DEU MERDA");
                return null;
        }
    }


}
