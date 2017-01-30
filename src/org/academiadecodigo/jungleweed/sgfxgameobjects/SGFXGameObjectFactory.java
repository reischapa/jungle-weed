package org.academiadecodigo.jungleweed.sgfxgameobjects;

import org.academiadecodigo.jungleweed.Game;
import org.academiadecodigo.jungleweed.gameobjectsframework.Indicator;
import org.academiadecodigo.jungleweed.gameobjectsframework.Representable;
import org.academiadecodigo.jungleweed.gameobjects.GameObjectFactory;

/**
 * Created by chapa on 1/28/2017.
 */
public class SGFXGameObjectFactory extends GameObjectFactory {

    private static int WIDTH = 900;
    private static int HEIGHT = 900;

    private static int X_PADDING = 10;
    private static int Y_PADDING = 10;

    @Override
    public Representable getRepresentableOfType(Game.RepresentableType type) {

        switch (type) {
            case TOTEMSTANDINGUP:
                return new SGFXImage("res/TOTEMSTANDINGUP.png", WIDTH/2 - 80, HEIGHT/2 - 100);
            case TABLE:
                return new SGFXImage("res/BACKGROUND2.JPEG", X_PADDING, Y_PADDING);
            case TITLESCREEN:
                return new SGFXImage("res/TITLESCREEN.png", X_PADDING, Y_PADDING);
            case TOTEMTUMBLED:
                return new SGFXImage("res/TOTEMSTANDINGUP.png", WIDTH/2 - 80, HEIGHT/2 - 100);
            default:
                System.out.println("DEU MERDA");
                return new SGFXTotemStandingUp();
        }

    }

    @Override
    public Indicator getIndicatorOfType(Game.IndicatorType type) {
        switch (type) {
            case CURRENTPLAYER:
                return new SGFXPlayerTurnIndicator();
            case GRABTOTEM:
                return new SGFXGrabTotemIndicator();
            case ENDSCREEN:
                return new SGFXEndScreenIndicator();
            default:
                return new SGFXPlayerTurnIndicator();
        }
    }



}
