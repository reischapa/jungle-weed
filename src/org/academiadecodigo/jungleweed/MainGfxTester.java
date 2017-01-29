package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.CardShape;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/25/17.
 */
public class MainGfxTester {
    public static void main(String[] args) {
        //SGFXCard card = new SGFXCard("Bolas1", "Amarela");

        Rectangle rect = new Rectangle(10, 10, 1600, 900);
        rect.fill();
        rect.setColor(Color.BLACK);


//        SGFXCard sgfx = new SGFXCard(CardShape.BALLS1, CardColor.GREEN);

        Picture pic = new Picture(410,20 , "res/" + CardShape.BALLS1 + CardColor.GREEN+ ".jpeg");
        pic.draw();

        Picture pic2 = new Picture(30 ,270 , "res/" + CardShape.BALLS1 + CardColor.ORANGE+ ".jpeg");
        pic2.draw();

        Picture pic3 = new Picture(410, 510 , "res/" + CardShape.BALLS1 + CardColor.GREEN+ ".jpeg");
        pic3.draw();

        Picture pic4 = new Picture(830,270 , "res/" + CardShape.BALLS1 + CardColor.GREEN+ ".jpeg");
        pic4.draw();
//
//
//        Picture pic2 = new Picture(400, 20, "res/JungleWeed " + "Bolas1" + "Laranja"+ ".jpeg");
//        pic2.draw();
//
//        Picture pic3 = new Picture(-400, 20, "res/JungleWeed " + "Bolas1" + "Laranja"+ ".jpeg");
//        pic3.draw();
//
//        Picture pic4 = new Picture(0, 300, "res/JungleWeed " + "Bolas1" + "Laranja"+ ".jpeg");
//        pic4.draw();
    }

}
