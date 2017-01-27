package org.academiadecodigo.jungleweed;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.security.Key;
import java.util.IllegalFormatCodePointException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 1/27/17.
 */
public class SFXController implements KeyboardHandler {

    private final Integer[] allRevealKeys = {KeyboardEvent.KEY_1, KeyboardEvent.KEY_4, KeyboardEvent.KEY_7, KeyboardEvent.KEY_0};
    private final Integer[] allGrabKeys = {KeyboardEvent.KEY_Q, KeyboardEvent.KEY_R, KeyboardEvent.KEY_Y, KeyboardEvent.KEY_O};

    private List<Integer> revealKeys;
    private List<Integer> grabKeys;

    private int numPlayers;

    private Keyboard keyboard;

    private Game game;


    public static void main(String[] args) {

        SFXController c = new SFXController(2);



    }

    public SFXController(int numPlayers) {

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

        this.game = new Game(numPlayers,60);

        this.game.init();
        this.game.start();

        this.keyboard = new Keyboard(this);

        this.constructEventListeners();


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

        for (int i = 0; i < this.allRevealKeys.length; i++) {

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                System.exit(0);
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                this.game.playerInfo();
                return;
            }

            if (keyboardEvent.getKey() == this.revealKeys.get(i)) {
                this.game.getPlayerFaceUpCard(i);
                return;
            }

            if (keyboardEvent.getKey() == this.allGrabKeys[i]) {
                this.game.grabTotem(i);
                return;
            }

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        System.out.println("BOOP");
    }
}
