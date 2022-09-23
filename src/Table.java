import java.util.ArrayList;
import java.util.Collections;

/**
 * The Table class handles all the logic of the game
 * and contains all the elements of the game such as
 * card deck and card piles.
 * @author Thomas Roethenbaugh
 * @version 1.0
 */

public class Table {

    private Deck deck;
    private ArrayList<Card> piles;
    private int score;
    private String filename = "cards.txt";

    public Table(Deck deck, int scores) {
        this.deck = deck;
        this.piles = new ArrayList<Card>();
        this.score = scores;
    }

    /**
     *
     * @return
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Method for game to load deck
     */
    public void initialiseDeck() {
        deck.loadDeck(filename);
    }

    /**
     * Method to add pile to game
     */
    public void addPile() {
        piles.add(deck.getFirstCard());
        score += 1;
        deck.removeCard();
    }

    public void removePile() {
        piles.remove(0);
        score -= 1;
    }

    /**
     * Move pile onto previous pile
     */
    public void moveLastPileOntoPrevious() {
        if (deck.checkIfMoveIsLegal(piles.get(piles.size() - 2), piles.get(piles.size() - 1))){
            piles.remove(piles.get(piles.size() - 2));
            System.out.println("Card moved!");
        }
        else {
            System.out.println("Move illegal!");
        }
    }

    /**
     * Move pile over two piles
     */
    public void moveLastPileOverTwoPiles() {
        if (deck.checkIfMoveIsLegal(piles.get(piles.size() - 3), piles.get(piles.size() - 1))){
            Collections.swap(piles, piles.indexOf(piles.size() - 3), piles.indexOf(piles.size() - 1));
            piles.remove(piles.get(piles.size() - 1));
            System.out.println("Card moved over two piles!");
        }
        else {
            System.out.println("Move illegal!");
        }
    }

    /**
     * Does not properly amalgamate
     */
    public void amalgamate() {
        moveLastPileOverTwoPiles();
        moveLastPileOntoPrevious();


        /*Card startCard = piles.get(piles.lastIndexOf(piles));
        Card endCard = new Card();
        for (Card pile : piles) {
            if (pile.getCardSuit().equals(startCard) || pile.getCardID().equals(startCard)) {
                endCard = pile;
            }
        }*/

    }

    public void playForMeOnce() {

    }

    public void printDeck() {
        deck.getDeckNames();
    }

    public void printScore() {
        System.out.println(score);
    }

    public Card getFirstCardFromDeck() {
        return piles.get(piles.size() - 1);
    }

    @Override
    public String toString() {
        return "Table{" +
                "deck=" + deck +
                ", piles=" + piles +
                ", score=" + score +
                ", filename='" + filename + '\'' +
                '}';
    }
}
