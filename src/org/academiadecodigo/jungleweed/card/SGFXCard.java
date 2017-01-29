package org.academiadecodigo.jungleweed.card;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.Representable;
import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.CardShape;
import org.academiadecodigo.jungleweed.logic.LogicEngine;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by anton on 25/01/2017.
 */
public class SGFXCard extends Card {


    private Picture faceUp;
    private Picture faceDown;


    public SGFXCard(CardShape shape, CardColor color) {
        super(shape, color);
    }


    public void draw() {

        this.hide();


        if (this.isFaceUp()) {
            this.faceUp = new Picture(this.getXFaceUp(), this.getYFaceUp(), "res/" + this.getShape() + this.getColor() + ".jpeg");
            this.faceUp.draw();
        } else {
            this.faceDown = new Picture(this.getXFaceDown(), this.getYFaceDown(), "res/CARDBACK.jpeg");
            this.faceDown.draw();
        }


    }

    public void hide() {
        if (this.faceUp != null ) {
            this.faceUp.delete();
        }

        if (this.faceDown != null) {
            this.faceDown.delete();
        }
    }


}
