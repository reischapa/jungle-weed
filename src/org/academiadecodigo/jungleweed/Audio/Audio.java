package org.academiadecodigo.jungleweed.Audio;
import  sun.audio.*;
import  java.io.*;

/**
 * Created by codecadet on 1/30/17.
 */
public class Audio {

    private InputStream theme;
    private InputStream endtheme;
    private InputStream fileflip;

    private AudioStream music;
    private AudioStream effect;

    public Audio() {

        try {

            fileflip = new FileInputStream("res/flip.wav");
            endtheme = new FileInputStream("res/TokenTango.wav");
            theme = new FileInputStream("res/JungleJapes.wav");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void startTheme()  {
        try {
            music = new AudioStream(theme);
            AudioPlayer.player.start(music);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopTheme() {
        AudioPlayer.player.stop(music);
        try {
            music.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startEndTheme()  {
        try {
            music = new AudioStream(endtheme);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AudioPlayer.player.start(music);
    }

    public void stopEndTheme() {
        AudioPlayer.player.stop(music);
        try {
            music.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playFlip()  {


        try {
            fileflip = new FileInputStream("res/flip.wav");
            effect = new AudioStream(fileflip);
            System.out.println(effect.getLength());
            AudioPlayer.player.start(effect);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }



        try {
            Thread.sleep(100);
            fileflip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void stopFlip()  {
        try {
            this.effect.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
