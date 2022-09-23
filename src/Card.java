/**
 * The card class handles all the data of each card as well
 * as some rules
 * @author Thomas Roethenbaugh
 * @version 1.0
 */

public class Card {

    private String cardSuit;
    private String cardID;
    private String cardName;

    /**
     *
     * @param cardSuit
     * @param cardID
     * @param cardName
     */
    public Card(String cardSuit, String cardID, String cardName) {
        this.cardSuit = cardSuit;
        this.cardID = cardID;
        this.cardName = cardName;
    }

    public Card(){
        cardSuit = null;
        cardID = null;
        cardName = null;
    }

    /**
     *
     * @return
     */
    public String getCardSuit() {
        return cardSuit;
    }

    /**
     *
     * @param cardSuit
     */
    public void setCardSuit(String cardSuit) {
        this.cardSuit = cardSuit;
    }

    /**
     *
     * @return
     */
    public String getCardID() {
        return cardID;
    }

    /**
     *
     * @param cardID
     */
    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardSuit='" + cardSuit + '\'' +
                ", cardID='" + cardID + '\'' +
                ", cardID='" + cardName + '\'' +
                '}';
    }
}
