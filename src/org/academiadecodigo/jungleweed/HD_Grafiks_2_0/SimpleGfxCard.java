package org.academiadecodigo.jungleweed.HD_Grafiks_2_0;

import org.academiadecodigo.jungleweed.Drawable;
import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.CardShape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by anton on 25/01/2017.
 */
public class SimpleGfxCard implements Drawable {

    private int x;
    private int y;
    private Picture pic;


    public SimpleGfxCard(CardShape shape, CardColor color) {
        //pic = new Picture(450, 0, "res/" + shape + color + ".jpeg");

    }


    @Override
    public void draw() {
        pic.draw();
        pic.grow(-400, -400);

    }

    @Override
    public void clear() {
        pic.delete();
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}
