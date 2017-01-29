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

    public SimpleGfxCard(CardShape shape, CardColor color) {
        super(shape, color);

    }

    private void recreateShapes() {


        if (this.faceUp != null ) {
            this.faceUp.delete();
        }

        if (this.faceDown != null) {
            this.faceDown.delete();
        }
        faceUp = new Picture(this.getxFaceUp(), this.getyFaceUp(), "res/" + this.getShape() + this.getColor() + ".jpeg");
        faceDown = new Picture(this.getxFaceDown(), this.getyFaceDown(), "res/CARDBACK.jpeg");

        switch (this.getCardStatus()) {

            case VISIBLE:
                this.faceUp.draw();
                break;
            case FACEDOWN:
                this.faceDown.draw();
                break;
        }



    }

    @Override
    public void setXFaceUp(int x) {
        super.setXFaceUp(x);
    }

    @Override
    public void setYFaceUp(int y) {
        super.setYFaceUp(y);
    }

    @Override
    public void setXFaceDown(int x) {
        super.setXFaceDown(x);
    }

    @Override
    public void setYFaceDown(int y) {
        super.setYFaceDown(y);
    }


    @Override
    public void setCardStatus(CardStatus cardStatus) {
        super.setCardStatus(cardStatus);
        this.recreateShapes();
    }
}
