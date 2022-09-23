/**
 * The Game of patience main class
 * @author Thomas Roethenbaugh
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {

    private ArrayList<Card> cards = new ArrayList<>();

    /**
     * Constructor for deck class
     * @param
     * @param
     */
    public Deck() {
    }

    /**
     * This loads the deck from the file
     * @param filename takes file input to read the ID and the suit
     */
    public void loadDeck(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            Scanner infile = new Scanner(br);
            for(int i = 0; i < 52; i++) {
                String cardID = infile.nextLine();
                String cardSuit = infile.nextLine();
                String cardName = cardID + cardSuit;
                Card loadedCard = new Card(cardSuit, cardID, cardName);
                cards.add(loadedCard);

            }
        } catch (FileNotFoundException e) {
            System.err.println("The file" + filename + "have you accidentally deleted the file?");
        } catch (IOException e) {
            System.err.println("An unexpected error occurred when trying to open the file " + filename);
            System.err.println(e.getMessage());
        }
        shuffleCards(cards);
    }

    /**
     * Getter for deck of cards
     * @return
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * gets first card
     * @return first card
     */
    public Card getFirstCard() {
        return cards.get(0);
    }

    public void addCard(Card fromDeck) {
        cards.add(fromDeck);
    }

    public void removeCard() {
        cards.remove(0);
    }

    public boolean checkIfMoveIsLegal(Card startCard, Card endCard) {
        boolean isLegal = false;
        if(startCard.getCardSuit().equals(endCard.getCardSuit())||startCard.getCardID().equals(endCard.getCardID()))
        {
            isLegal=true;
        }
        return isLegal;
    }

    /**
     * Setter for deck of cards
     * @param cards cards object
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * Shuffles deck of cards
     * @param cards deck of cards
     */
    public void shuffleCards(ArrayList<Card> cards){
        Collections.shuffle(cards);
    }

    public void getDeckNames() {
        String printName;
        for (Card deck : cards) {
            printName = deck.getCardName() + " ";
            System.out.print(printName);
        }
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
