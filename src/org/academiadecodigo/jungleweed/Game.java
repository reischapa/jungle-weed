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

    private int numPlayers;
    private int nCardsTotal;
    private int nCardsHand;

    private Player[] players;
    private CompareType compareType;
    private Card[] deck;
    private CardFactory cardFactory;
    private Card[] comparableCards;

    private int playerTurn;

    private boolean color;

    private boolean gameEnd;

    private PlayerFactory playerFactory;

    public Game(int nPlayers, int nCardsTotal) {
        this.numPlayers = nPlayers;
        this.players = new Player[this.numPlayers];
        this.compareType = CompareType.SHAPE;
        this.nCardsTotal = nCardsTotal;
        this.nCardsHand = this.nCardsTotal / this.numPlayers;
        playerTurn = 0;
        color=false;
        gameEnd=false;
        this.playerFactory = new PlayerFactory(this.numPlayers, this.nCardsTotal);
    }


    public void init() {
        // Create Field;
        for(int i = 0; i< numPlayers; i++){
            players[i]= this.playerFactory.getNextPlayer();
        }
        cardFactory = new CardFactory(CardShape.values(), CardColor.values());
        deck = new Card[nCardsTotal];

    }


    public void start() {
        dealAllCards();
        //Field Dray
        comparableCards = new Card[players.length];

    }

    public void getPlayerFaceUpCard(int turn){

        if(playerTurn == turn){
            players[playerTurn].revealNextCard();
            comparableCards[playerTurn]=players[playerTurn].getFaceUpCard();
            if(players[playerTurn].getFaceUpCard().getShape() == CardShape.CHANGECOLOR && color == false){
                changeCompareType();
                color = true;
                System.out.println("COLOR= " + color);
            }
            else if(color==true){
                isColor();
            }
            System.out.println(players[playerTurn].getFaceUpCard().getShape() + " " + players[playerTurn].getFaceUpCard().getColor());
            nextPlayerTurn();
        }
        else{
            System.out.println("Not Your Turn");
        }

    }

    public void grabTotem(int turn){

        for(int i=0; i<players.length;i++) {
            if (players[i].isAgarraPau()) {
                System.out.println("Totem is Grabbed");
                return;
            }
        }players[turn].agarraPau();
        System.out.println("Player" + (turn+1) + " ganhou : " + comparePlayercards(turn, comparableCards[turn]));
        players[turn].largaPau();
        isGameOver();


    }

    private void isGameOver() {
        for(Player player : players){
            if(player.getTotalNumberOfCards()==0){
                this.gameEnd=true;
            }
        }
    }

    private boolean comparePlayercards(int turn, Card comparableCard) {
        comparableCards[turn]=null;
        int iterator=0;
        for(Card card : comparableCards){
            if(card != null && comparableCard !=null) {
                if (compareCards(comparableCard, card)) {
                    System.out.println((turn+1) + ":" + comparableCard.getShape() + ", " + comparableCard.getColor() + " " + (iterator+1) + ":" + card.getShape() + ", " + card.getColor());
                    tradeCards(players[turn],players[iterator]);
                    card = null;
                    return true;
                }
            }
            iterator++;
        }
        clearComparableCards();
        System.out.println(players[0].getNumberRevealedCards());
        System.out.println(players[1].getNumberRevealedCards());
        players[turn].getTotalNumberOfCards();
        tradeAllCards(turn);
        return false;

    }

    private void nextPlayerTurn(){
        if(playerTurn < players.length-1) {
            playerTurn++;
        }else{
            playerTurn = 0;
        }
    }

    private void tradeCards(Player player1, Player player2){
        player2.addCards(player1.giveCards());
        System.out.println(player2.getTotalNumberOfCards());
    }

    private void tradeAllCards(int turn){
        for(Player player : players){
            players[turn].addCards(player.giveCards());
        }
        System.out.println(players[turn].getTotalNumberOfCards());

    }

    private void isColor(){
        for(Card card : comparableCards){
            if(card.getShape() == CardShape.CHANGECOLOR){
                return;
            }
        }
        color=false;
    }

    private void dealAllCards(){
        deck = cardFactory.getNCards(nCardsTotal);

        for(int i = 0; i< numPlayers; i++) {
            Card[] cardsPlayer = new Card[nCardsHand];
            System.arraycopy(deck,i* nCardsHand,cardsPlayer,0, nCardsHand);
            players[i].addCards(cardsPlayer);
            //players[i].drawFaceDownCard();
        }

    }


    private boolean compareShape(Card c1, Card c2) {
        return c1.getShape().equals(c2.getShape());
    }


    private boolean compareColor(Card c1, Card c2) {
        if(c1.getShape()!=CardShape.CHANGECOLOR && c2.getShape()!=CardShape.CHANGECOLOR) {
            return c1.getColor() == c2.getColor();
        }
        return false;
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

    private void clearComparableCards(){
        for(Card card : comparableCards){
            card = null;
        }
    }

    public boolean getGameEnd() {
        return gameEnd;
    }

    public void playerInfo(){
        for(Player player : players){
            System.out.print("Total Cards : " + player.getTotalNumberOfCards() + " ");
            System.out.print("Revealed Cards: " + player.getNumberRevealedCards() + " ");
            System.out.print("FaceDown Cards: " + player.getNumberFaceDownCards() + " ");
            System.out.print("FaceUp Card: " + player.getFaceUpCard());
            System.out.println();
        }
    }



}
