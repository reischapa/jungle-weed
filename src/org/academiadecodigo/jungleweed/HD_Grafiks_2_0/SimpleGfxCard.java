package org.academiadecodigo.jungleweed.HD_Grafiks_2_0;

import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.CardShape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by anton on 25/01/2017.
 */
public class SimpleGfxCard extends Card{

    private Picture faceUp;
    private Picture faceDown;

    public SimpleGfxCard(CardShape shape, CardColor color) {
        super(shape, color);

            faceUp = new Picture(0, 0, "res/" + shape + color + ".jpeg");
            faceDown = new Picture(0,0, "res/CARDBACK.jpeg");

    }

    @Override
    public void turn() {
        super.turn();
        if(super.isVisible()){
            faceDown.delete();
            faceUp.draw();
        }
    }

    @Override
    public void setXFaceUp(int x) {
        super.setXFaceUp(x);
        faceUp.translate(super.getxFaceUp() - x, 0);
    }

    @Override
    public void setYFaceUp(int y) {
        super.setYFaceUp(y);
        faceUp.translate(0, super.getyFaceUp() - y);
    }

    @Override
    public void setXFaceDown(int x) {
        super.setXFaceDown(x);
        faceDown.translate(super.getxFaceDown() - x, 0);
    }

    @Override
    public void setYFaceDown(int y)
    {
        super.setYFaceDown(y);
        faceDown.translate(0, super.getyFaceDown() - y);
    }

}
