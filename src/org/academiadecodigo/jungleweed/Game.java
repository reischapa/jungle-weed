package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.GameObjectFactory;
import org.academiadecodigo.jungleweed.GameObjectsFrameWork.Indicator;
import org.academiadecodigo.jungleweed.GameObjectsFrameWork.SGFXGameObjectFactory;
import org.academiadecodigo.jungleweed.GameObjectsFrameWork.Representable;
import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.SGFXCardFactory;
import org.academiadecodigo.jungleweed.card.CardShape;
import org.academiadecodigo.jungleweed.logic.LogicEngine;
import org.academiadecodigo.jungleweed.player.PlayerFactory;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 1/27/17.
 */
public class Game implements KeyboardHandler {

    private enum GameGraphicsType {
        CONSOLE, SIMPLEGFX,
    }

    public enum RepresentableType {
        TOTEM, TABLE,
    }

    public enum IndicatorType {
        CURRENTPLAYER,
    }


    private final Integer[] allRevealKeys = {KeyboardEvent.KEY_1, KeyboardEvent.KEY_4, KeyboardEvent.KEY_7, KeyboardEvent.KEY_0};
    private final Integer[] allGrabKeys = {KeyboardEvent.KEY_Q, KeyboardEvent.KEY_R, KeyboardEvent.KEY_Y, KeyboardEvent.KEY_O};

    private List<Integer> revealKeys;
    private List<Integer> grabKeys;

    private int numPlayers;

    private Keyboard keyboard;

    private LogicEngine logicEngine;

    private GameGraphicsType gameGraphicsType;

    private GameObjectFactory gameObjectFactory;

    private Representable field;

    private Representable totem;

    private Indicator playerTurnIndicator;

    public static void main(String[] args) {

        Game c = new Game(4,GameGraphicsType.CONSOLE);

        c.init();
        c.startGame();

    }

    public Game(int numPlayers, GameGraphicsType type) {

        if (numPlayers > this.allRevealKeys.length || numPlayers < 2) {
            throw new IllegalArgumentException();
        }

        this.revealKeys = new LinkedList<>();
        this.grabKeys = new LinkedList<>();

        this.numPlayers = numPlayers;

        this.gameGraphicsType = type;

    }


    public void init() {


        switch (this.gameGraphicsType) {
            case CONSOLE:
                this.gameObjectFactory = new GameObjectFactory();
                break;
            case SIMPLEGFX:
                this.gameObjectFactory = new SGFXGameObjectFactory();
                break;
            default:
                System.out.println("DEU MERDA");
                this.gameObjectFactory = new GameObjectFactory();
        }

        this.keyboard = new Keyboard(this);

        this.registerInputKeys();
        this.constructEventListeners();

    }



    public void startGame() {

        this.field = this.gameObjectFactory.getRepresentableOfType(RepresentableType.TABLE);
        this.field.draw();

        this.logicEngine = new LogicEngine(new PlayerFactory(this.numPlayers),new SGFXCardFactory(CardShape.values(), CardColor.values()));

        this.logicEngine.init();

        this.logicEngine.start();

        this.totem = this.gameObjectFactory.getRepresentableOfType(RepresentableType.TOTEM);
        this.totem.draw();

        this.playerTurnIndicator = this.gameObjectFactory.getIndicatorOfType(IndicatorType.CURRENTPLAYER);

        this.playerTurnIndicator.setProperty(this.logicEngine.getPlayerTurn());
        this.playerTurnIndicator.draw();

    }




    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        for (int i = 0; i < this.numPlayers; i++) {

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                System.exit(0);
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                this.logicEngine.playerInfo();
                break;
            }

            if (keyboardEvent.getKey() == this.revealKeys.get(i)) {
                this.logicEngine.getPlayerFaceUpCard(i);
                break;
            }

            if (keyboardEvent.getKey() == this.grabKeys.get(i)) {
                this.logicEngine.grabTotem(i);
                break;
            }

        }

        this.playerTurnIndicator.setProperty(this.logicEngine.getPlayerTurn());
        this.playerTurnIndicator.draw();
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}



    public void registerInputKeys() {

        switch (this.numPlayers) {
            case 2:
                this.revealKeys.add(this.allRevealKeys[0]);
                this.revealKeys.add(this.allRevealKeys[3]);
                this.grabKeys.add(this.allGrabKeys[0]);
                this.grabKeys.add(this.allGrabKeys[3]);
                break;
            case 3:
                this.revealKeys.add(this.allRevealKeys[0]);
                this.revealKeys.add(this.allRevealKeys[2]);
                this.revealKeys.add(this.allRevealKeys[3]);
                this.grabKeys.add(this.allGrabKeys[0]);
                this.grabKeys.add(this.allGrabKeys[2]);
                this.grabKeys.add(this.allGrabKeys[0]);
                break;
            case 4:
                this.revealKeys.add(this.allRevealKeys[0]);
                this.revealKeys.add(this.allRevealKeys[1]);
                this.revealKeys.add(this.allRevealKeys[2]);
                this.revealKeys.add(this.allRevealKeys[3]);
                this.grabKeys.add(this.allGrabKeys[0]);
                this.grabKeys.add(this.allGrabKeys[1]);
                this.grabKeys.add(this.allGrabKeys[2]);
                this.grabKeys.add(this.allGrabKeys[3]);
                break;
        }

    }

    private void constructEventListeners() {


        KeyboardEvent exitEvent = new KeyboardEvent();
        KeyboardEvent debugEvent = new KeyboardEvent();

        exitEvent.setKey(KeyboardEvent.KEY_RIGHT);
        debugEvent.setKey(KeyboardEvent.KEY_LEFT);

        exitEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        debugEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        this.keyboard.addEventListener(exitEvent);
        this.keyboard.addEventListener(debugEvent);


        for (int i = 0; i < this.revealKeys.size(); i++) {

            KeyboardEvent revealEvent = new KeyboardEvent();
            KeyboardEvent grabEvent = new KeyboardEvent();

            revealEvent.setKey(this.revealKeys.get(i));
            grabEvent.setKey(this.grabKeys.get(i));

            revealEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            grabEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            this.keyboard.addEventListener(revealEvent);
            this.keyboard.addEventListener(grabEvent);

        }

    }

}
