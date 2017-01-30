package org.academiadecodigo.jungleweed.Audio;
import  sun.audio.*;
import  java.io.*;

/**
 * Created by codecadet on 1/30/17.
 */
public class Audio {

    private static InputStream theme;
    private static InputStream endtheme;
    private static InputStream fileflip;

    private static AudioStream music;
    private static AudioStream effect;

    public Audio() throws FileNotFoundException {

        fileflip = new FileInputStream("res/flip.wav");
        endtheme = new FileInputStream("res/TokenTango.wav");
        theme = new FileInputStream("res/JungleJapes.wav");

    }

    public static void startTheme() throws IOException {
        music = new AudioStream(theme);
        AudioPlayer.player.start(music);
    }

    public static void stopTheme() throws IOException {
        AudioPlayer.player.stop(music);
        music.close();
    }

    public static void startEndTheme() throws IOException {
        music = new AudioStream(endtheme);
        AudioPlayer.player.start(music);
    }

    public static void stopEndTheme() throws IOException {
        AudioPlayer.player.stop(music);
        music.close();
    }

    public static void playFlip() throws IOException {
        effect = new AudioStream(fileflip);
        System.out.println(effect.getLength());
        //effect.skip(200);
        AudioPlayer.player.start(effect);

    }

    public static void stopFlip() throws IOException {

        AudioPlayer.player.stop(effect);
        effect.close();
    }


}
