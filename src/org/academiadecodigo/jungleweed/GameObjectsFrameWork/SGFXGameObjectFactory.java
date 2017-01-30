package org.academiadecodigo.jungleweed.GameObjectsFrameWork;

import org.academiadecodigo.jungleweed.Game;
import org.academiadecodigo.jungleweed.GameObjects.*;

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
            case ENDSCREEN:
                return new SGFXEndScreen();
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
            default:
                return new SGFXPlayerTurnIndicator();
        }
    }



}
