package org.academiadecodigo.jungleweed.Audio;
import  sun.audio.*;
import  java.io.*;

/**
 * Created by codecadet on 1/30/17.
 */
public class Audio {

    private InputStream theme;
    private InputStream fileflip;

    private AudioStream music;

    public Audio() {

        try {

            fileflip = new FileInputStream("res/flip.wav");
            theme = new FileInputStream("res/JungleJapes.wav");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void startTheme()  {

        if (music != null) {
            return;
        }

        try {
            music = new AudioStream(theme);
            AudioPlayer.player.start(music);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopTheme() {

        if (music == null) {
            return;
        }

        try {
            music.close();
            theme.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playFlip()  {

        AudioStream effect;

        try {
            fileflip = new FileInputStream("res/flip.wav");
            effect = new AudioStream(fileflip);
            AudioPlayer.player.start(effect);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            Thread.sleep(100);
            fileflip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
