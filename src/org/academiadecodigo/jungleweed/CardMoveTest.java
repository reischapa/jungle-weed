package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.HD_Grafiks_2_0.SimpleGfxCard;
import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.CardShape;

/**
 * Created by Luis on 29/01/2017.
 */
public class CardMoveTest {
    public static void main(String[] args) throws InterruptedException {
        SimpleGfxCard sgfx = new SimpleGfxCard(CardShape.BALLS1, CardColor.GREEN);
        sgfx.setXFaceUp(10);
        sgfx.setYFaceUp(10);
        sgfx.setCardStatus(Card.CardStatus.VISIBLE);
        sgfx.move(500,500);
    }

}
