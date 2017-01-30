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
import org.academiadecodigo.jungleweed.player.SGFXPlayerFactory;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
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

    private enum GameState {
        GREET, GAME, GAMEEND,
    }


    public enum RepresentableType {
        TOTEM, TABLE, TITLESCREEN,
    }

    public enum IndicatorType {
        CURRENTPLAYER, GRABTOTEM
    }


    private final Integer[] allRevealKeys = {KeyboardEvent.KEY_1, KeyboardEvent.KEY_4, KeyboardEvent.KEY_7, KeyboardEvent.KEY_0};
    private final Integer[] allGrabKeys = {KeyboardEvent.KEY_Q, KeyboardEvent.KEY_R, KeyboardEvent.KEY_Y, KeyboardEvent.KEY_O};
    private final Integer startGameKey = KeyboardEvent.KEY_SPACE;
    private final Integer resetGameKey = KeyboardEvent.KEY_Z;
    private final Integer exitGameKey = KeyboardEvent.KEY_RIGHT;

    private List<Integer> revealKeys;
    private List<Integer> grabKeys;

    private int numPlayers;

    private Keyboard keyboard;

    private LogicEngine logicEngine;

    private PlayerFactory playerFactory;

    private SGFXCardFactory cardFactory;

    private GameGraphicsType gameGraphicsType;

    private GameObjectFactory gameObjectFactory;

    private Representable titleScreen;

    private Representable field;

    private Representable totem;

    private Indicator playerTurnIndicator;

    private Indicator playerGrabIndicator;

    private GameState gameState;

    public static void main(String[] args) {

        Game c = new Game(4, GameGraphicsType.SIMPLEGFX);

        c.init();
        c.start();

    }

    public Game(int numPlayers, GameGraphicsType type) {

        if (numPlayers > this.allRevealKeys.length || numPlayers < 2) {
            throw new IllegalArgumentException();
        }

        this.revealKeys = new LinkedList<>();
        this.grabKeys = new LinkedList<>();

        this.numPlayers = numPlayers;

        this.gameGraphicsType = type;

        this.gameState = GameState.GREET;

    }


    public void init() {


        switch (this.gameGraphicsType) {
            case CONSOLE:
                this.gameObjectFactory = new GameObjectFactory();
                this.playerFactory = new PlayerFactory();
                break;
            case SIMPLEGFX:
                this.gameObjectFactory = new SGFXGameObjectFactory();
                this.playerFactory = new SGFXPlayerFactory(this.numPlayers);
                break;
            default:
                System.out.println("DEU MERDA");
                throw new UnsupportedOperationException();
        }

        this.logicEngine = new LogicEngine(this.numPlayers, playerFactory, new SGFXCardFactory(CardShape.values(), CardColor.values()));
        this.logicEngine.init();

        this.keyboard = new Keyboard(this);

        this.field = this.gameObjectFactory.getRepresentableOfType(RepresentableType.TABLE);
        this.totem = this.gameObjectFactory.getRepresentableOfType(RepresentableType.TOTEM);
        this.titleScreen = this.gameObjectFactory.getRepresentableOfType(RepresentableType.TITLESCREEN);

        this.playerTurnIndicator = this.gameObjectFactory.getIndicatorOfType(IndicatorType.CURRENTPLAYER);
        this.playerGrabIndicator = this.gameObjectFactory.getIndicatorOfType(IndicatorType.GRABTOTEM);

        this.constructEventListeners();

    }

    public void start() {
        this.showGreetMenu();
    }

    public void reset() {
        this.init();
        this.showGreetMenu();
    }

    private void showGreetMenu() {
        this.hideAllRepresentables();
        this.gameState = GameState.GREET;
        this.titleScreen.setX(10);
        this.titleScreen.setY(10);
        this.titleScreen.draw();
    }


    private void showMainGame() {
        this.gameState = GameState.GAME;
        this.titleScreen.hide();

        this.field.draw();

        this.logicEngine.start();

        this.totem.draw();

        this.playerTurnIndicator.setProperty(this.logicEngine.getPlayerTurn());
        this.playerTurnIndicator.draw();


    }

    private void showEndScreen() {
        this.gameState = GameState.GAMEEND;
    }


    public void catchGreetKeys(KeyboardEvent event) {
        Integer key = event.getKey();

        if (key == startGameKey) {
            this.showMainGame();
        }

        if (key == exitGameKey) {
            System.exit(0);
        }

    }

    public void catchGameKeys(KeyboardEvent event) {

        Integer key = event.getKey();

        for (int i = 0; i < this.numPlayers; i++) {
            if (allRevealKeys[i] == key) {
                this.logicEngine.getPlayerFaceUpCard(i);
                return;
            }

            if (allGrabKeys[i] == key) {
                this.logicEngine.grabTotem(i);
                return;
            }
        }

        if (exitGameKey == key) {
            System.exit(0);
        }

        if (resetGameKey == key) {
            this.reset();
            this.showGreetMenu();
            return;
        }

    }


    public void catchEndScreenKeys(KeyboardEvent event) {
        this.catchGreetKeys(event);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (this.gameState) {
            case GREET:
                this.catchGreetKeys(keyboardEvent);
                break;
            case GAME:
                this.catchGameKeys(keyboardEvent);
                break;
            case GAMEEND:
                this.catchEndScreenKeys(keyboardEvent);
                break;
            default:
                System.out.println("Deu merda");
                throw new UnsupportedOperationException();
        }

    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    private void constructEventListeners() {

        for (Integer i : allRevealKeys) {
            this.addEventListener(i);
        }

        for (Integer i : allGrabKeys) {
            this.addEventListener(i);
        }

        this.addEventListener(startGameKey);
        this.addEventListener(resetGameKey);
        this.addEventListener(exitGameKey);


    }

    private void addEventListener(Integer keyNumber) {
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(keyNumber);

        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        this.keyboard.addEventListener(event);

    }

    private void hideAllRepresentables() {
        this.field.hide();
        this.totem.hide();
        this.playerGrabIndicator.hide();
        this.playerTurnIndicator.hide();
    }



}

