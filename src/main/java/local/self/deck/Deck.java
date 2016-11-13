package local.self.deck;

import java.util.NoSuchElementException;

/**
 * Separate interface for deck data structure.
 * It' a little bit of overkill to have a separate interface for a single implementation
 * but most of the time we need to keep "what" and "how" separate.
 *
 * @param <T> card type parameter, we may want to create deck of different type of card( poker, MTG, whatever)
 */
public interface Deck<T extends Card> {
    /*
     * we don't know any actual requirements for the interface
     * so i am going to list "natural" stuff that I can do with a
     * deck of cards
     */

    /**
     * Adds a new card on top of the deck.
     *
     * @param card the card you want to put in the deck
     * @throws IllegalArgumentException if the card is null
     */
    void addOnTop(T card);

    /**
     * Adds a new card to the bottom of the deck.
     *
     * @param card the card you want to put in the deck
     * @throws IllegalArgumentException if the card is null
     */
    void addToBottom(T card);

    /**
     * Takes the first card from the top of the deck.
     *
     * @return top card from the deck
     * @throws NoSuchElementException if the deck is empty
     */
    T takeTopCard();

    /**
     * Takes a card from the bottom of the deck.
     *
     * @return a card from the bottom of the deck
     * @throws NoSuchElementException if the deck is empty
     */
    T takeBottomCard();

    /**
     * Shuffles the deck.
     */
    void shuffle();

    /**
     * Shows if deck is empty or not
     * @return flag that shows whether deck is empty or not
     */
    boolean isEmpty();


}
