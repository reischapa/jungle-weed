package org.academiadecodigo.jungleweed.sgfxgameobjects;

import org.academiadecodigo.jungleweed.Game;
import org.academiadecodigo.jungleweed.gameobjectsframework.Indicator;
import org.academiadecodigo.jungleweed.gameobjectsframework.Representable;
import org.academiadecodigo.jungleweed.gameobjects.GameObjectFactory;

/**
 * Created by chapa on 1/28/2017.
 */
public class SGFXGameObjectFactory extends GameObjectFactory {

    @Override
    public Representable getRepresentableOfType(Game.RepresentableType type) {

        switch (type) {
            case TOTEM:
                return new SGFXTotem();
            case TABLE:
                return new SGFXTable();
            case TITLESCREEN:
                return new SGFXTitleScreen();
            default:
                System.out.println("DEU MERDA");
                return new SGFXTotem();
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
                return new SGFXEndScreen();
            default:
                return new SGFXPlayerTurnIndicator();
        }
    }



}
