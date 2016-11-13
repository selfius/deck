package local.self.deck.impl;


import org.junit.Test;
import local.self.deck.impl.StandardFrenchSuitedCard.Suit;
import local.self.deck.impl.StandardFrenchSuitedCard.NickNames;

import static org.junit.Assert.assertTrue;

/**
 * Test for {@link StandardFrenchSuitedCard}
 */
public class StandardFrenchSuitedCardTest {

    @Test
    public void testCardCreation() {
        StandardFrenchSuitedCard card = new StandardFrenchSuitedCard(2, Suit.SPADES);
        assertTrue(card.getSuit().equals(Suit.SPADES));
        assertTrue(card.getValue() == 2);
    }

    @Test
    public void testCardCreationWithNickName() {
        StandardFrenchSuitedCard card = new StandardFrenchSuitedCard(NickNames.JOKER, Suit.SPADES);
        assertTrue(card.getSuit().equals(Suit.SPADES));
        assertTrue(card.getValue() == NickNames.JOKER.getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertThrowsOnIllegalData() {
        StandardFrenchSuitedCard card = new StandardFrenchSuitedCard(100, Suit.SPADES);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertThrowsOnIllegalDataNullNickname() {
        StandardFrenchSuitedCard card = new StandardFrenchSuitedCard(null, Suit.CLUBS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertThrowsOnIllegalDataNullSuits() {
        StandardFrenchSuitedCard card = new StandardFrenchSuitedCard(NickNames.KING, null);
    }


}
