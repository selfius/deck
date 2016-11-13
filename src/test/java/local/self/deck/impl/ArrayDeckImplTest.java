package local.self.deck.impl;

import local.self.deck.Card;
import local.self.deck.Deck;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Random;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link ArrayDeckImpl} unit
 */

public class ArrayDeckImplTest {


    @Test
    public void testOnTopAndTakeTop() {
        Deck<SimpleCard> deck = new ArrayDeckImpl<>();
        SimpleCard one = new SimpleCard();
        SimpleCard two = new SimpleCard();
        deck.addOnTop(one);
        assertTrue(deck.takeTopCard().equals(one));

        deck = new ArrayDeckImpl<>();
        deck.addOnTop(one);
        deck.addOnTop(two);
        deck = new ArrayDeckImpl<>();
        deck.addOnTop(one);
        deck.addOnTop(one); //is it ok to have two equal cards in a deck? I guess it's okay in general
        assertTrue(deck.takeTopCard().equals(one));
        assertTrue(deck.takeTopCard().equals(one));
    }

    @Test(expected = NoSuchElementException.class)
    public void testTakeTopThrowsException() {
        Deck<SimpleCard> deck = new ArrayDeckImpl<>();
        deck.takeTopCard();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddOnTopThrowsException() {
        Deck<SimpleCard> deck = new ArrayDeckImpl<>();
        deck.addOnTop(null);
    }

    @Test
    public void testOnBottomAndTakeBottom() {
        Deck<SimpleCard> deck = new ArrayDeckImpl<>();
        SimpleCard one = new SimpleCard();
        SimpleCard two = new SimpleCard();
        deck.addToBottom(one);
        assertTrue(deck.takeBottomCard().equals(one));

        deck = new ArrayDeckImpl<>();
        deck.addToBottom(one);
        deck.addToBottom(two);
        assertTrue(deck.takeBottomCard().equals(two));
        assertTrue(deck.takeBottomCard().equals(one));
    }

    @Test(expected = NoSuchElementException.class)
    public void testTakeBottomThrowsException() {
        Deck<SimpleCard> deck = new ArrayDeckImpl<>();
        deck.takeBottomCard();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToBottomThrowsException() {
        Deck<SimpleCard> deck = new ArrayDeckImpl<>();
        deck.addToBottom(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void mixedOperationsTest() {
        Deck<SimpleCard> deck = new ArrayDeckImpl<>();
        SimpleCard one = new SimpleCard();
        SimpleCard two = new SimpleCard();
        SimpleCard three = new SimpleCard();
        SimpleCard four = new SimpleCard();
        deck.addOnTop(three);
        deck.addToBottom(two);
        deck.addToBottom(one);
        deck.addOnTop(four);
        assertTrue(deck.takeBottomCard().equals(one));
        assertTrue(deck.takeTopCard().equals(four));
        assertTrue(deck.takeTopCard().equals(three));
        assertTrue(deck.takeBottomCard().equals(two));
        deck.takeBottomCard();
    }

    @Test
    public void shuffleTest() {
        //side note: normally I wouldn't do this, and would just blindly rely on Java Standard library
        //or if I REALLY need to check shuffle works as intended
        // I would perform some statistics analysis.. but I need to spent much more that a hour for that
        //so it's a quite useless test that coupled with the implementation... :\

        ArrayDeckImpl<SimpleCard> deck = new ArrayDeckImpl<>();
        SimpleCard one = new SimpleCard();
        SimpleCard two = new SimpleCard();
        SimpleCard three = new SimpleCard();
        SimpleCard four = new SimpleCard();

        deck.addOnTop(one);
        deck.addOnTop(two);
        deck.addOnTop(three);
        deck.addOnTop(four);

        deck.shuffle(new Random(1)); //we need a constant seed to make our results reliable
        assertTrue(deck.takeBottomCard().equals(four));
        assertTrue(deck.takeBottomCard().equals(one));
        assertTrue(deck.takeBottomCard().equals(two));
        assertTrue(deck.takeBottomCard().equals(three));
    }


    @Test
    public void isEmptyTest() {
        ArrayDeckImpl<SimpleCard> deck = new ArrayDeckImpl<>();
        assertTrue(deck.isEmpty());
        deck.addOnTop(new SimpleCard());
        assertFalse(deck.isEmpty());
    }

    /*
     * we want to test exclusively Deck implementation
     * so don't want to rely on external Card implementation.
     *  This naive implementation will suit us perfectly
     */
    private class SimpleCard implements Card {
    }

}
