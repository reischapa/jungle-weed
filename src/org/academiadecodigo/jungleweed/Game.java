package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.GameObjectFactory;
import org.academiadecodigo.jungleweed.GameObjectsFrameWork.Representable;
import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.SimpleGFXCardFactory;
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

    private final Integer[] allRevealKeys = {KeyboardEvent.KEY_1, KeyboardEvent.KEY_4, KeyboardEvent.KEY_7, KeyboardEvent.KEY_0};
    private final Integer[] allGrabKeys = {KeyboardEvent.KEY_Q, KeyboardEvent.KEY_R, KeyboardEvent.KEY_Y, KeyboardEvent.KEY_O};

    private List<Integer> revealKeys;
    private List<Integer> grabKeys;

    private int numPlayers;

    private Keyboard keyboard;

    private LogicEngine logicEngine;

    private GameObjectFactory objectFactory;

    private List<Representable> representables;

    public static void main(String[] args) {

        Game c = new Game(4);

        c.init();
        c.start();

    }

    public Game(int numPlayers) {

        if (numPlayers > this.allRevealKeys.length || numPlayers < 2) {
            throw new IllegalArgumentException();
        }

        this.revealKeys = new LinkedList<>();
        this.grabKeys = new LinkedList<>();

        switch (numPlayers) {
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

        this.numPlayers = numPlayers;

    }


    public void init() {

        this.logicEngine = new LogicEngine(new PlayerFactory(this.numPlayers),new SimpleGFXCardFactory(CardShape.values(), CardColor.values()));

        this.keyboard = new Keyboard(this);

        this.objectFactory = new GameObjectFactory(this.logicEngine);

        this.logicEngine.init();

    }

    public void start() {

        this.logicEngine.start();
        this.representables = this.objectFactory.getRepresentableGameObjects();
        this.constructEventListeners();
        this.drawAllGameObjects();

    }

    private void drawAllGameObjects() {
        for (Representable r : this.representables) {
            r.draw();
        }
    }

    private void hideAllGameObjects() {
        for (Representable r : this.representables) {
            r.hide();
        }
    }

    public void addRepresentable(Representable r) {
        this.representables.add(r);
    }

    public LogicEngine getLogicEngine() {
        return this.logicEngine;
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

        this.drawAllGameObjects();

    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}

}
