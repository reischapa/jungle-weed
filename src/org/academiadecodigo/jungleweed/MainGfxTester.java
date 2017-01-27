package org.academiadecodigo.jungleweed;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/25/17.
 */
public class MainGfxTester {
    public static void main(String[] args) {
        //SimpleGfxCard card = new SimpleGfxCard("Bolas1", "Amarela");

        Rectangle rect = new Rectangle(10, 10, 1000, 1000);
        rect.fill();
        rect.setColor(Color.GREEN);


        Picture pic = new Picture(0,-300 , "res/JungleWeed " + "Bolas1" + "Laranja"+ ".jpeg");
        pic.grow(-400, -400);
        pic.draw();


        Picture pic2 = new Picture(400, 20, "res/JungleWeed " + "Bolas1" + "Laranja"+ ".jpeg");
        pic2.grow(-400, -400);
        pic2.draw();

        Picture pic3 = new Picture(-400, 20, "res/JungleWeed " + "Bolas1" + "Laranja"+ ".jpeg");
        pic3.grow(-400, -400);
        pic3.draw();

        Picture pic4 = new Picture(0, 300, "res/JungleWeed " + "Bolas1" + "Laranja"+ ".jpeg");
        pic4.grow(-400, -400);
        pic4.draw();
    }

}
