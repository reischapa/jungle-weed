package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.Audio.Audio;
import org.academiadecodigo.jungleweed.gameobjects.GameObjectFactory;
import org.academiadecodigo.jungleweed.gameobjectsframework.Indicator;
import org.academiadecodigo.jungleweed.sgfxgameobjects.SGFXGameObjectFactory;
import org.academiadecodigo.jungleweed.gameobjectsframework.Representable;
import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.SGFXCardFactory;
import org.academiadecodigo.jungleweed.card.CardShape;
import org.academiadecodigo.jungleweed.logic.LogicEngine;
import org.academiadecodigo.jungleweed.player.PlayerFactory;
import org.academiadecodigo.jungleweed.player.SGFXPlayerFactory;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

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
        TOTEMSTANDINGUP, TABLE, TITLESCREEN, TOTEMTUMBLED, INSTRUCTIONS
    }

    public enum IndicatorType {
        CURRENTPLAYER, GRABTOTEM, ENDSCREEN
    }


    private final int[] allRevealKeys = {KeyboardEvent.KEY_1, KeyboardEvent.KEY_0, KeyboardEvent.KEY_M, KeyboardEvent.KEY_Z};
    private final int[] allGrabKeys = {KeyboardEvent.KEY_2, KeyboardEvent.KEY_9, KeyboardEvent.KEY_N, KeyboardEvent.KEY_X};
    private final int startGameKey = KeyboardEvent.KEY_SPACE;
    private final int resetGameKey = KeyboardEvent.KEY_LEFT;
    private final int exitGameKey = KeyboardEvent.KEY_RIGHT;
    private final int debugGameKey = KeyboardEvent.KEY_DOWN;

    private List<Integer> revealKeys;
    private List<Integer> grabKeys;

    private int numPlayers;

    private Keyboard keyboard;

    private LogicEngine logicEngine;

    private PlayerFactory playerFactory;

    //private SGFXCardFactory cardFactory;

    private GameGraphicsType gameGraphicsType;

    private GameObjectFactory gameObjectFactory;

    private Representable titleScreen;

    private Representable field;

    private Representable totemStandingUp;

    private Representable instructions;

    private Indicator endScreen;

    private Indicator playerTurnIndicator;

    private Indicator playerGrabIndicator;

    private GameState gameState;

    private Audio audio;

    boolean showInstructions = true;

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


        this.keyboard = new Keyboard(this);

        this.audio = new Audio();

        this.field = this.gameObjectFactory.getRepresentableOfType(RepresentableType.TABLE);

        this.titleScreen = this.gameObjectFactory.getRepresentableOfType(RepresentableType.TITLESCREEN);

        this.totemStandingUp = this.gameObjectFactory.getRepresentableOfType(RepresentableType.TOTEMSTANDINGUP);

        this.instructions = this.gameObjectFactory.getRepresentableOfType(RepresentableType.INSTRUCTIONS);

        this.playerTurnIndicator = this.gameObjectFactory.getIndicatorOfType(IndicatorType.CURRENTPLAYER);

        this.playerGrabIndicator = this.gameObjectFactory.getIndicatorOfType(IndicatorType.GRABTOTEM);

        this.endScreen = this.gameObjectFactory.getIndicatorOfType(IndicatorType.ENDSCREEN);

        this.constructEventListeners();

    }

    public void start() {
        this.showGreetMenu();
    }

    public void reset() {
        this.init();
        this.showInstructions = true;
        this.showGreetMenu();
    }

    private void showGreetMenu() {
        this.gameState = GameState.GREET;
        this.hideAllRepresentables();

        this.audio.startTheme();

        this.titleScreen.draw();
    }


    private void showMainGame() {
        this.gameState = GameState.GAME;
        this.hideAllRepresentables();

        this.field.draw();

        this.logicEngine = new LogicEngine(this.numPlayers, playerFactory, new SGFXCardFactory(CardShape.values(), CardColor.values()));
        this.logicEngine.init();
        this.logicEngine.start();

        this.totemStandingUp.draw();

        this.playerTurnIndicator.setProperty(this.logicEngine.getPlayerTurn());
        this.playerTurnIndicator.draw();


    }

    private void showEndScreen() {
        this.gameState = GameState.GAMEEND;
        this.hideAllRepresentables();

        this.audio.stopTheme();

        this.endScreen.draw();
    }


    public void catchGreetKeys(KeyboardEvent event) {
        Integer key = event.getKey();


        if (key == startGameKey) {

            if (this.showInstructions) {
                this.instructions.draw();
                this.showInstructions = false;
                return;
            }

            this.showMainGame();
        }

    }

    public void catchGameKeys(KeyboardEvent event) {

        Integer key = event.getKey();

        if (resetGameKey == key) {
            this.reset();
            return;
        }

        if (debugGameKey == key) {
            this.logicEngine.playerInfo();
            return;
        }

        this.hideAllIndicators();
        this.totemStandingUp.draw();

        for (int i = 0; i < this.numPlayers; i++) {
            if (allRevealKeys[i] == key) {
                if (this.logicEngine.getPlayerFaceUpCard(i)) {
                    this.audio.playFlip();
                }
            }

            if (allGrabKeys[i] == key) {

                this.playerGrabIndicator.setProperty(i+1);

                if (  this.logicEngine.grabTotem(i) ) {
                    //TODO SOUND for successful player grab
                } else {
                    //TODO SOUND for unsuccessful player grab
                }

                this.playerGrabIndicator.draw();
                this.totemStandingUp.hide();
            }

        }

        int winnerTurn = this.logicEngine.getWinnerPlayerTurn();

        if (winnerTurn >= 0) {
            this.endScreen.setProperty(winnerTurn+1);
            this.showEndScreen();
            return;
        }


        this.playerTurnIndicator.setProperty(this.logicEngine.getPlayerTurn());
        this.playerTurnIndicator.draw();

    }




    public void catchEndScreenKeys(KeyboardEvent event) {

        Integer key = event.getKey();

        if (key == resetGameKey) {
            this.reset();
        }

    }

    public boolean catchCommonScreenKeys(KeyboardEvent event) {

        if (event.getKey() == exitGameKey) {
            System.exit(0);
        }

        return false;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (catchCommonScreenKeys(keyboardEvent)) {
            return;
        }

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
        this.addEventListener(debugGameKey);


    }

    private void addEventListener(Integer keyNumber) {
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(keyNumber);

        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        this.keyboard.addEventListener(event);

    }

    private void hideAllRepresentables() {
        this.field.hide();
        this.totemStandingUp.hide();
        this.titleScreen.hide();
        this.endScreen.hide();
        this.hideAllIndicators();
    }

    private void hideAllIndicators() {
        this.playerGrabIndicator.hide();
        this.playerTurnIndicator.hide();
        this.endScreen.hide();
    }

}

