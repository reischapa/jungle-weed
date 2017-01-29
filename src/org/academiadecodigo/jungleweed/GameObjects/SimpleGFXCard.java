package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.Representable;
import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.CardShape;
import org.academiadecodigo.jungleweed.logic.LogicEngine;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by anton on 25/01/2017.
 */
public class SimpleGFXCard extends Card implements Representable{


    public enum CardStatus {
        VISIBLE,FACEDOWN,HIDDEN
    }

    private Picture faceUp;
    private Picture faceDown;

    private int xFaceUp;
    private int yFaceUp;
    private int xFaceDown;
    private int yFaceDown;

    private CardStatus cardStatus;

    private LogicEngine logicEngine;

    public SimpleGFXCard(CardShape shape, CardColor color, LogicEngine logicEngine) {
        super(shape, color);

    }

    private void recreateShapes() {

        faceUp = new Picture(this.xFaceUp, this.yFaceUp, "res/" + this.getShape() + this.getColor() + ".jpeg");
        faceDown = new Picture(this.xFaceDown, this.yFaceDown, "res/CARDBACK.jpeg");


    }

    public void setXFaceUp(int x) {
        this.xFaceUp = x;
    }

    public void setYFaceUp(int y) {
        this.yFaceUp = y;
    }

    public void setXFaceDown(int x) {
        this.xFaceDown = x;
    }

    public void setYFaceDown(int y) {
        this.yFaceDown = y;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
        this.recreateShapes();
    }

    public SimpleGFXCard.CardStatus getCardStatus() {
        return cardStatus;
    }


    @Override
    public void setX(int x) {
        //TODO change the position of both cards
    }

    @Override
    public void setY(int y) {
        //TODO change the position of both cards
    }

    @Override
    public int getX() {
        //TODO give the position of the card on the top right
        return 0;
    }

    @Override
    public int getY() {
        //TODO give the position of the card on the top right
        return 0;
    }

    @Override
    public void draw() {

        this.hide();

        this.recreateShapes();

        if (this.logicEngine.getCurrentLogicStatus() == LogicEngine.LogicStatus.WAITING) {

            switch (this.cardStatus) {
                case VISIBLE:
                    this.faceUp.draw();
                    return;
                case FACEDOWN:
                    this.faceDown.draw();
                    return;
            }

        }
    }

    @Override
    public void hide() {
        if (this.faceUp != null ) {
            this.faceUp.delete();
        }

        if (this.faceDown != null) {
            this.faceDown.delete();
        }
    }

}
