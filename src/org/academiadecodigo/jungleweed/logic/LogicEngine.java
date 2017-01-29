package org.academiadecodigo.jungleweed.logic;

import org.academiadecodigo.jungleweed.card.Card;
import org.academiadecodigo.jungleweed.card.CardColor;
import org.academiadecodigo.jungleweed.card.SimpleGFXCardFactory;
import org.academiadecodigo.jungleweed.card.CardShape;
import org.academiadecodigo.jungleweed.player.Player;
import org.academiadecodigo.jungleweed.player.PlayerFactory;

/**
 * Created by codecadet on 1/22/17.
 */
public class LogicEngine {

    private enum CompareType {
        COLOR, SHAPE;
    }

    public enum LogicStatus {
        TOBERUN, WAITING, GRABBING, TRADING, FINISHED;
    }


    private int numPlayers;
    private int nCardsTotal;
    private int nCardsHand;

    private Player[] players;
    private CompareType compareType;
    private Card[] deck;
    private SimpleGFXCardFactory cardFactory;
    private Card[] comparableCards;

    private int playerTurn;
    private boolean color;
    private boolean gameEnd;
    private PlayerFactory playerFactory;


    public LogicEngine(PlayerFactory playerFactory, SimpleGFXCardFactory cardFactory) {

        this.playerFactory = playerFactory;
        this.numPlayers = this.playerFactory.getNPlayers();
        this.players = new Player[this.numPlayers];
        this.compareType = CompareType.SHAPE;
        this.nCardsTotal = CardShape.values().length * CardColor.values().length;
        this.nCardsHand = this.nCardsTotal / this.numPlayers;
        this.playerTurn = 0;
        this.color = false;
        this.gameEnd = false;

        this.cardFactory = cardFactory;
    }

    // Initializes Players, creates a deck of crads and deals all the cards to the respective players.
    public void init() {

        for (int i = 0; i < numPlayers; i++) {

            this.players[i] = this.playerFactory.getNextPlayer();

        }

    }


    public void start() {

        this.deck = new Card[nCardsTotal];
        dealAllCards();
        this.comparableCards = new Card[this.players.length];

    }

    // Turns one player card from the face down pile to the top of the face up pile, if it's that player's turn,
    // if the turned up card is a ChangeColor card, the game will now compare card colors instead of shapes,
    // when that card is no longer on top changes the game logic back to shapes.
    public void getPlayerFaceUpCard(int turn) {

        if (this.playerTurn == turn) {

            this.players[this.playerTurn].revealNextCard();
            this.comparableCards[this.playerTurn] = this.players[this.playerTurn].getFaceUpCard();

            if (this.comparableCards[this.playerTurn].getShape() == CardShape.CHANGECOLOR && this.color == false) {

                changeCompareType();
                this.color = true;
                System.out.println("COLOR= " + this.color);

            } else if (this.color) {

                isColor();

            }

            System.out.println(comparableCards[playerTurn].getShape() + " " + comparableCards[playerTurn].getColor());
            nextPlayerTurn();

        } else {

            System.out.println("Not Your Turn");

        }

    }

    // When the player grabs the totems it compares all cards, if there's a match between the player's card and any other card on top of the face up pile,
    // the player wins and the loser must take his cards, if he loses he must take everybody's face up cards.
    public void grabTotem(int turn) {

        for (int i = 0; i < this.players.length; i++) {

            if (this.players[i].isAgarraPau()) {

                System.out.println("SimpleGFXTotem is Grabbed");
                return;

            }
        }

        this.players[turn].agarraPau();
        boolean ganhou = this.comparePlayerCards(turn, this.comparableCards[turn]);

        System.out.println("Player" + (turn + 1) + " ganhou : " + ganhou);

        this.players[turn].largaPau();
        isGameOver();

    }

    //Checks if the game is over by looking at all the player cards, if a player has no cards then the game is over.
    private void isGameOver() {

        for (Player player : players) {

            if (player.getTotalNumberOfCards() == 0) {

                this.gameEnd = true;
            }

        }

    }

    //Resets the game back to the beginning, creates all the cards again and gives them to the players.
    public void reset() {

        this.gameEnd = false;
        this.playerTurn = 0;
        clearComparableCards();
        init();
        start();

    }

    //Compares the cards on the field with the card of the player who called the check, return true if there is any card on top of the face up pile that matches the player's card.
    private boolean comparePlayerCards(int turn, Card comparableCard) {

        this.comparableCards[turn] = null;
        int iterator = 0;

        for (Card card : this.comparableCards) {

            if (card != null && comparableCard != null) {

                if (compareCards(comparableCard, card)) {

                    System.out.println((turn + 1) + ":" + comparableCard.getShape() + ", " + comparableCard.getColor() + " " + (iterator + 1) + ":" + card.getShape() + ", " + card.getColor());
                    tradeCards(this.players[turn], this.players[iterator]);
                    card = null;
                    this.playerTurn = iterator;
                    return true;

                }

            }

            iterator++;
        }

        this.playerTurn = turn;
        clearComparableCards();
        System.out.println(players[0].getNumberRevealedCards());
        System.out.println(players[1].getNumberRevealedCards());
        this.players[turn].getTotalNumberOfCards();
        tradeAllCards(turn);
        return false;

    }

    //Changes playerTurn to the next playerTurn until the max number of players.
    private void nextPlayerTurn() {

        if (this.playerTurn < this.players.length - 1) {

            this.playerTurn++;

        } else {

            this.playerTurn = 0;

        }

    }

    //Trades Cards from the winning player to the losing player.
    private void tradeCards(Player player1, Player player2) {

        player2.addCards(player1.giveCards());
        player2.addCards(player2.giveCards());
        System.out.println(player2.getTotalNumberOfCards());

    }

    //Gives the player all the other player's cards.
    private void tradeAllCards(int turn) {

        for (Player player : this.players) {

            this.players[turn].addCards(player.giveCards());

        }

        System.out.println(players[turn].getTotalNumberOfCards());

    }

    //Checks if the CHANGECOLOR card is still on the table, if not it changes back the compare type to shapes.
    private void isColor() {

        for (Card card : this.comparableCards) {

            if (card != null && card.getShape() == CardShape.CHANGECOLOR) {
                return;
            }

        }

        changeCompareType();
        this.color = false;

    }

    //Deals all cards to the respective players equally.
    private void dealAllCards() {

        this.deck = this.cardFactory.getNCards(nCardsTotal);

        for (int i = 0; i < this.numPlayers; i++) {

            Card[] cardsPlayer = new Card[this.nCardsHand];
            System.arraycopy(this.deck, i * this.nCardsHand, cardsPlayer, 0, this.nCardsHand);
            this.players[i].addCards(cardsPlayer);

        }

    }

    //Compare shape between two cards.
    private boolean compareShape(Card c1, Card c2) {

        return c1.getShape().equals(c2.getShape());

    }

    //Compare Color between two cards.
    private boolean compareColor(Card c1, Card c2) {

        if (c1.getShape() != CardShape.CHANGECOLOR && c2.getShape() != CardShape.CHANGECOLOR) {

            return c1.getColor() == c2.getColor();

        }

        return false;

    }

    //Compares two cards depending on the compare type.
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

    //Changes the compare type from shape to color and from color to shape.
    private void changeCompareType() {

        if (this.compareType == CompareType.SHAPE) {

            this.compareType = CompareType.COLOR;

        } else {

            this.compareType = CompareType.SHAPE;

        }
    }

    //Clears all comparable cards.
    private void clearComparableCards() {

        for (Card card : this.comparableCards) {

            card = null;

        }

    }

    //Returns boolean gameEnd.
    public boolean getGameEnd() {

        return this.gameEnd;

    }

    //Debugging tools

    //Prints all player info to the console.
    public void playerInfo() {

        for (Player player : this.players) {

            System.out.print("Total Cards : " + player.getTotalNumberOfCards() + " ");
            System.out.print("Revealed Cards: " + player.getNumberRevealedCards() + " ");
            System.out.print("FaceDown Cards: " + player.getNumberFaceDownCards() + " ");
            System.out.print("FaceUp Card: " + player.getFaceUpCard());
            System.out.println();

        }

    }

    //Returns a player's total number of cards.
    public int playerTotalCards(int turn) {

        return this.players[turn].getTotalNumberOfCards();

    }

    //Returns a player's face down cards.
    public int playerFaceDownCards(int turn) {

        return this.players[turn].getNumberFaceDownCards();

    }

    //Return a player's revealed card.
    public int playerRevealedCards(int turn) {

        return this.players[turn].getNumberRevealedCards();

    }

    //Returns the current player turn.
    public int getPlayerTurn() {

        return this.playerTurn;

    }

    public LogicStatus getCurrentLogicStatus() {
        //TODO give proper information regarding the game status
        return LogicStatus.WAITING;
    }

}
