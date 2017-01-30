package org.academiadecodigo.jungleweed.sgfxgameobjects;

import org.academiadecodigo.jungleweed.gameobjectsframework.AbstractIndicator;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/30/17.
 */
public class SGFXEndScreenIndicator extends AbstractIndicator {
    private Picture picture;
    private Text text;

    public SGFXEndScreenIndicator(int initialX, int initialY) {
        this.setX(initialX);
        this.setY(initialY);
    }

    @Override
    public void draw() {

        this.picture = new Picture(this.getX(), this.getY(), "res/ENDSCREEN.jpeg");
        this.picture.draw();

//        this.text = new Text(this.getX() + 2*this.picture.getWidth()/10 , this.getY() + 9*this.picture.getHeight()/10 , "Player " + this.getProperty() + " wins the game!");
//        this.text.setColor(Color.BLUE);
//
//        this.text.grow(120,12);
//
//        this.text.draw();

    }

    @Override
    public void hide() {
        if (this.picture != null) {
            picture.delete();
        }
    }
}
