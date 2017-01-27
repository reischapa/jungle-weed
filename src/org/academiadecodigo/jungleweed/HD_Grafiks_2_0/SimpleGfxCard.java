package org.academiadecodigo.jungleweed.HD_Grafiks_2_0;

import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.CardShape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by anton on 25/01/2017.
 */
public class SimpleGfxCard extends Card {

    private Picture faceUp;
    private Picture faceDown;

    private boolean hasBeenFirstDrawn;

    public SimpleGfxCard(CardShape shape, CardColor color) {
        super(shape, color);

        faceUp = new Picture(0, 0, "res/" + shape + color + ".jpeg");
        faceDown = new Picture(0, 0, "res/CARDBACK.jpeg");

    }

    private void recreateShapes() {

        this.faceUp.delete();
        this.faceDown.delete();

        faceUp = new Picture(this.getxFaceUp(), this.getyFaceUp(), "res/" + this.getShape() + this.getColor() + ".jpeg");
        faceDown = new Picture(this.getxFaceDown(), this.getyFaceDown(), "res/CARDBACK.jpeg");

        if (this.isVisible()) {
            faceUp.draw();
        } else {
            faceDown.draw();
        }

    }

    @Override
    public void turn() {
        super.turn();
        if (super.isVisible()) {
            this.recreateShapes();
        }

    }

    private void drawFirstTime() {
        if (!hasBeenFirstDrawn) {
            faceUp.draw();
            faceDown.draw();
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
    public void setYFaceDown(int y) {
        super.setYFaceDown(y);
        faceDown.translate(0, super.getyFaceDown() - y);
    }

}
