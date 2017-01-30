package org.academiadecodigo.jungleweed.gameobjects;

import org.academiadecodigo.jungleweed.Game;
import org.academiadecodigo.jungleweed.gameobjectsframework.Indicator;
import org.academiadecodigo.jungleweed.gameobjectsframework.Representable;

/**
 * Created by codecadet on 1/29/17.
 */
public class GameObjectFactory {


    public Representable getRepresentableOfType(Game.RepresentableType type) {
        switch (type) {
            case TOTEMSTANDINGUP:
                return new TotemStandingUp();
            case TABLE:
                return new Table();
            case TITLESCREEN:
                return new TitleScreen();
            case TOTEMTUMBLED:
                return new TotemTumbled();
            case INSTRUCTIONS:
                return new Table();
            default:
                throw new UnsupportedOperationException();
        }
    }


    public Indicator getIndicatorOfType(Game.IndicatorType type) {
        switch (type) {
            case CURRENTPLAYER:
                return new PlayerTurnIndicator();
            case GRABTOTEM:
                return new GrabTotemIndicator();
            case ENDSCREEN:
                return new EndScreenIndicator();
            default:
                throw new UnsupportedOperationException();
        }
    }


}
