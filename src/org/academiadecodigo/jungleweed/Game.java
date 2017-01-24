package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardFactory;
import org.academiadecodigo.jungleweed.player.Player;
import org.academiadecodigo.jungleweed.player.PlayerFactory;

/**
 * Created by codecadet on 1/22/17.
 */
public class Game {

    private static int NUMBER_PLAYERS = 2;
    private static int NUMBER_CARDS_TOTAL = 80;
    private static int NUMBER_HAND_CARDS;

    private Player[] players;
    private CompareType compareType;



    public Game(/*TODO NumberPlayers here*/) {
        //TODO
        this.players = new Player[NUMBER_PLAYERS];
        this.compareType = CompareType.SHAPE;
        NUMBER_HAND_CARDS = NUMBER_CARDS_TOTAL / NUMBER_PLAYERS;
    }


    public void init() {
        for(int i=0; i<NUMBER_PLAYERS;i++){
            players[i]= PlayerFactory.getNewPlayer(NUMBER_CARDS_TOTAL);
            Card[] cards = new Card[NUMBER_HAND_CARDS];
            for(int j=0; j < NUMBER_HAND_CARDS; j++){
                cards[j]=CardFactory.getRandomCard();
            }
            players[i].addCards(cards);
            //System.out.println(players[i]);
        }

    }


    public void start() {

        while(true){
            Card[] comparableCards = new Card[players.length];
            int iterator = 0;
            for(Player player : players){
                if(player.getTotalNumberOfCards() == 0){
                    System.out.println("Game Over");
                    return;
                }
                player.revealNextCard();
                comparableCards[iterator] = player.getFaceUpCard();

                iterator++;

            }
            iterator=0;
            Player[] playerCardBattle = compareAllcards(comparableCards, players);
            if(playerCardBattle[1]!=null) {
                playerCardBattle[0].addCards(playerCardBattle[1].giveCards());
                System.out.println(playerCardBattle[0].getTotalNumberOfCards());
            }

        }


    }

    private Player[] compareAllcards(Card[] comparableCards, Player[] players){
        Player[] playerCardBattle = new Player[2];
        for(int i=0; i<comparableCards.length -1 ; i++){
            for(int j=i+1; j<comparableCards.length;j++) {
                if (compareCards(comparableCards[i], comparableCards[j])) {
                    playerCardBattle[0]=players[i];
                    playerCardBattle[1]=players[j];
                    System.out.println("Player" + i + " and Player" + j + " Cards Match!");
                    return playerCardBattle;
                } else {
                    System.out.println("Cards Dont Match");
                }
            }
        }
        return playerCardBattle;
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
                System.out.println("Deu Merda wtf is Happening ?!");
                return this.compareShape(c1, c2);
        }

    }

    private void changeCompareType(){
        if(compareType == CompareType.SHAPE){
            compareType = CompareType.COLOR;
        }else{
            compareType = CompareType.SHAPE;
        }
    }


}
