package org.academiadecodigo.jungleweed;

import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.CardFactory;
import org.academiadecodigo.jungleweed.card.CardShape;
import org.academiadecodigo.jungleweed.player.Player;
import org.academiadecodigo.jungleweed.player.PlayerFactory;

/**
 * Created by codecadet on 1/22/17.
 */
public class Game {

    private static int NUMBER_PLAYERS = 4;
    private static int NUMBER_CARDS_TOTAL = 56;
    private static int NUMBER_HAND_CARDS;

    private Player[] players;
    private CompareType compareType;
    private Card[] deck;
    private CardFactory cardFactory;
    private Card[] comparableCards;

    private int playerTurn;



    public Game(/*TODO NumberPlayers here*/) {
        //TODO
        this.players = new Player[NUMBER_PLAYERS];
        this.compareType = CompareType.SHAPE;
        NUMBER_HAND_CARDS = NUMBER_CARDS_TOTAL / NUMBER_PLAYERS;
        playerTurn = 0;
    }


    public void init() {
        // Create Field;
        for(int i=0; i<NUMBER_PLAYERS;i++){
            players[i]= PlayerFactory.getNewPlayer(NUMBER_CARDS_TOTAL);
        }
        cardFactory = new CardFactory(CardShape.values(), CardColor.values());
        deck = new Card[NUMBER_CARDS_TOTAL];

    }


    public void start() {
        dealAllCards();
        //Field Dray
        comparableCards = new Card[players.length];

        /*while(true){

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

        }*/


    }

    public void getPlayerFaceUpCard(int turn){

        if(playerTurn == turn){
            players[playerTurn].revealNextCard();
            comparableCards[playerTurn]=players[playerTurn].getFaceUpCard();
            nextPlayerTurn();
        }
        else{
            System.out.println("Not Your Turn");
        }

    }

    public void grabTotem(int turn){

        for(int i=0; i<players.length;i++) {
            if (players[i].isAgarraPau()) {
                return;
            }
        }players[turn].agarraPau();

        System.out.println(comparePlayercards(turn, comparableCards[turn]));
        players[turn].largaPau();

    }

    private boolean comparePlayercards(int turn, Card comparableCard) {
        comparableCards[turn]=null;
        int iterator=0;
        for(Card card : comparableCards){
            if(card != null && comparableCard !=null) {
                if (compareCards(comparableCard, card)) {
                    System.out.println(comparableCard.getShape() + " " + card.getShape());
                    return true;
                }
            }
        }
        return false;

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

    private void nextPlayerTurn(){
        if(playerTurn < players.length-1) {
            playerTurn++;
        }else{
            playerTurn = 0;
        }
    }

    private void tradeCards(Player player1, Player player2){

    }

    private void tradeAllCards(Player[] players){

    }



    private void dealAllCards(){
        deck = cardFactory.getNCards(NUMBER_CARDS_TOTAL);
       /* for(int i=0; i<deck.length; i++) {
            deck[i] = CardFactory.getRandomCard();
        }*/

        for(int i=0; i<NUMBER_PLAYERS;i++) {
            Card[] cardsPlayer = new Card[NUMBER_HAND_CARDS];
            System.arraycopy(deck,i*NUMBER_HAND_CARDS,cardsPlayer,0,NUMBER_HAND_CARDS);
            //changeCardPosition(cardsPlayer, players[i]);
            players[i].addCards(cardsPlayer);
        }

    }

    private void changeCardPosition(Card[] cards, Player player){
        for(Card card : cards){
            card.setX(player.getX());
            card.setY(player.getY());
        }
    }

    private boolean compareShape(Card c1, Card c2) {
        return c1.getShape().equals(c2.getShape());
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
