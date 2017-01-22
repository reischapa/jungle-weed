package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardFactory;
import org.academiadecodigo.jungleweed.player.Player;
import org.academiadecodigo.jungleweed.player.PlayerFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by codecadet on 1/22/17.
 */
public class Game {

    public static int NUMBER_PLAYERS = 2;

    private Player[] players;
    private CompareType compareType;



    public Game(/*TODO NumberPlayers here*/) {
        //TODO
        this.players = new Player[NUMBER_PLAYERS];
        this.compareType = CompareType.SHAPE;
    }


    public void init() {
        for(int i=0; i<NUMBER_PLAYERS;i++){
            players[i]= PlayerFactory.getNewPlayer(20);
            int maxPlayerCards = players[i].getMaxPossibleCards();
            Card[] cards = new Card[maxPlayerCards];
            for(int j=0; j<maxPlayerCards; j++){
                cards[j]=CardFactory.getRandomCard();
            }
            players[i].receiveCards(cards);
            System.out.println(players[i]);
        }

    }


    public void start() {

        while(true){
            Card[] comparableCards = new Card[players.length];
            int iterator = 0;
            for(Player player : players){
                if(player.getTotalNumberOfCards()==0){
                    System.out.println("Game Over");
                    return;
                }
                player.revealNextCard();
            }
            for(Player player : players){
                comparableCards[iterator] = player.getFaceUpCard();
                iterator++;
            }


        }


    }

    private boolean compareShape(Card c1, Card c2) {
        return c1.getShape() == c2.getShape();
    }


    private boolean compareColor(Card c1, Card c2) {
        return c1.getColor() == c2.getColor();
    }


    private boolean compareCards(Card c1, Card c2) {
        switch (this.compareType) {
            case COLOR:
                return this.compareColor(c1, c2);
            case SHAPE:
                return this.compareShape(c1, c2);
            default:
                System.out.println("Piço");
                return this.compareShape(c1, c2);
        }

    }


}
