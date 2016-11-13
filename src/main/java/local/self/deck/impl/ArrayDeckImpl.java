package local.self.deck.impl;

import local.self.deck.Card;
import local.self.deck.Deck;

import java.util.*;

/**
 * The only implementation for out deck of cards data structure.
 */
public class ArrayDeckImpl<T extends Card> implements Deck<T> {

    /*
     * So. there is lot to think about here.
     * We need to consider what kind of performance we want to get
     * and what trade-offs are acceptable.
     * ArrayList will provide amortized constant time for the insertion/retrieval to/from the end of the deck
     * Also shuffle operation will take linear time and be quite efficient ( in terms of memory and time)
     * But the insertion/retrieval at/from the beginning can take up to linear time.
     * But let us assume that the last to is a fairly rare cases
     */
    private List<T> cards = new ArrayList<>();

    @Override
    public void addOnTop(T card) {
        if (card == null) {
            throw new IllegalArgumentException();
        }
        cards.add(card);
    }

    @Override
    public void addToBottom(T card) {
        if (card == null) {
            throw new IllegalArgumentException();
        }
        cards.add(0, card);
    }

    @Override
    public T takeTopCard() {
        if (cards.size() == 0) {
            throw new NoSuchElementException();
        }
        return cards.remove(cards.size() - 1);
    }

    @Override
    public T takeBottomCard() {
        if (cards.size() == 0) {
            throw new NoSuchElementException();
        }
        return cards.remove(0);
    }

    @Override
    public void shuffle() {
        shuffle(new Random());
    }

    protected void shuffle(Random rnd) {
        Collections.shuffle(cards, rnd);
    }

    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
