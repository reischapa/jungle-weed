package org.academiadecodigo.jungleweed.GameObjects;

import org.academiadecodigo.jungleweed.GameObjectsFrameWork.AbstractIndicator;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/29/17.
 */
public class SGFXGrabTotemIndicator extends AbstractIndicator {

    private final int XPOSITION = 320 + SGFXTable.X_PADDING;
    private final int YPOSITION = 320 + SGFXTable.Y_PADDING;

    private Text text;

    @Override
    public void draw() {
        this.text = new Text(XPOSITION, YPOSITION, "Player " + super.getProperty() + " has grabbed the Totem!!");
        this.text.grow(40,40);
        this.text.draw();
    }

    @Override
    public void hide() {
        this.text.delete();
    }
}
