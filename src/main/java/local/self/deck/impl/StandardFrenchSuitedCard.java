package local.self.deck.impl;

import local.self.deck.Card;

/**
 * Simple immutable implementation of poker card
 */
public class StandardFrenchSuitedCard implements Card {

    /**
     * Standard French pack card constructor
     * @param value value of the card accepts value in range from 1 to 13 see {@link NickNames}
     * @param suit suit of the card
     * @throws IllegalArgumentException if value param is out of valid range
     */
    public StandardFrenchSuitedCard(int value, Suit suit) {
        if (value < 1 || value > 13 || suit == null) {
            throw new IllegalArgumentException();
        }
        this.value = value;
        this.suit = suit;
    }

    /**
     * Created a card that normally have no numerical representation ( an have a nickname)
     * @param nickname nickname of the card
     * @param suit suit of the card
     */
    public StandardFrenchSuitedCard(NickNames nickname, Suit suit) {
        if (nickname == null || suit == null ) {
            throw new IllegalArgumentException();
        }
        this.value = nickname.getValue();
        this.suit = suit;
    }

    /**
     * returns the numerical value of the card
     * @return returns numerical value of the card
     */
    public int getValue() {
        return value;
    }

    /**
     * return the suit of the card
     * @return suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * NickNames for nonnumerical cards in stands French deck
     */
    public enum NickNames {
        JOKER(1), ACE(2), JACK(11), QUEEN(12), KING(13);

        private int value;

        NickNames(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int idxDiff = 0;
        if (this.value > 10) {
            idxDiff = -10;
        }
        if (this.value < 2 || this.value > 10) {
            sb.append(NickNames.values()[this.value+idxDiff].toString().toLowerCase());
        } else {
            sb.append(this.value);
        }
        return sb.append(" of ").
                append(suit.toString().toLowerCase()).toString();
    }

    /**
     * Suits of a standard French deck
     */
    public enum Suit {
        SPADES,
        CLUBS,
        DIAMONDS,
        HEARTS
    }

    //numerical representation of a card value
    final private int value;

    //suit of a card
    final private Suit suit;

}
