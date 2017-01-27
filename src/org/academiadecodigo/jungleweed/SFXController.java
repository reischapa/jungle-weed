package org.academiadecodigo.jungleweed;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 1/27/17.
 */
public class SFXController implements KeyboardHandler {

    private final int[] revealKeys = {KeyboardEvent.KEY_1, KeyboardEvent.KEY_4, KeyboardEvent.KEY_7, KeyboardEvent.KEY_0};
    private final int[] grabKeys = {KeyboardEvent.KEY_Q, KeyboardEvent.KEY_R, KeyboardEvent.KEY_Y, KeyboardEvent.KEY_O} ;

    private int numPlayers;

    private Keyboard keyboard;

    private Game game;


    public static void main(String[] args) {

        SFXController c = new SFXController(4);


    }

    public SFXController(int numPlayers) {

        this.numPlayers = numPlayers;

        this.game = new Game();

        this.keyboard = new Keyboard(this);

        this.constructEventListeners();


    }


    private void constructEventListeners() {

        for (int i = 0; i < this.revealKeys.length; i++) {

            KeyboardEvent revealEvent = new KeyboardEvent();
            KeyboardEvent grabEvent = new KeyboardEvent();

            revealEvent.setKey(this.revealKeys[i]);
            grabEvent.setKey(this.grabKeys[i]);

            revealEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            grabEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            this.keyboard.addEventListener(revealEvent);
            this.keyboard.addEventListener(grabEvent);

        }

    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        for (int i = 0; i < this.revealKeys.length; i++) {

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                System.exit(0);
            }

            if (keyboardEvent.getKey() == this.revealKeys[i]) {
                System.out.println(i);
            }

            if (keyboardEvent.getKey() == this.grabKeys[i]) {
                System.out.println("grabbing " + i);
            }

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        System.out.println("BOOP");
    }
}
