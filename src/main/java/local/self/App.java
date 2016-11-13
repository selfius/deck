package local.self;

import local.self.deck.Card;
import local.self.deck.Deck;
import local.self.deck.impl.ArrayDeckImpl;
import local.self.deck.impl.StandardFrenchSuitedCard;

/**
 * Simple client app
 */
public class App {
    private static Deck<? extends Card> createStandardDeck() {
        //normally this kind of methods should be in some kind of Factory of decks of cards
        //but it's an overkill application as simple as this
        Deck<StandardFrenchSuitedCard> deck = new ArrayDeckImpl<>();
        for (StandardFrenchSuitedCard.Suit suit : StandardFrenchSuitedCard.Suit.values()) {
            for (int value = 1; value <= 13; value++) {
                deck.addOnTop(new StandardFrenchSuitedCard(value, suit));
            }
        }
        return deck;
    }

    public static void main(String[] args) {
        Deck<? extends Card> deck = createStandardDeck();
        deck.shuffle();
        while (!deck.isEmpty()) {
            System.out.println(deck.takeTopCard());
        }
    }
}
