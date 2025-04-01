package prosjekt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CardDeckTest {
    CardDeck deck = new CardDeck();
    CardHand hand = new CardHand();
    Card card = new Card('S', 3);
    SaveScore save = new SaveScore();
    FindScore find = new FindScore();

    


    @Test
    void testDeal() {
    hand.addCard(deck.deal());
    hand.addCard(deck.deal());
    assertEquals(50, deck.getCardCount());

    }

    @Test
    void testGetCardCount() {
        assertEquals(52, deck.getCardCount());
        deck.deal();
        assertEquals(51, deck.getCardCount());
        for (int i = 0; i < 11; i++) {
            deck.deal();
        }
        assertTrue(deck.getCardCount() == 40);
    }

    @Test
    void testNewDeck() {
        for (int i = 0; i < 11; i++) {
            hand.addCard(deck.deal());
        }
        hand.returnCards();
        deck.newDeck();
        assertEquals(52, deck.getCardCount());
    }

    @Test
    void testShuffleDeck() {
        CardDeck deck2 = new CardDeck();
        deck2.shuffleDeck();
        assertFalse(deck.getCard(0) == deck2.getCard(0));
    }
    @Test
    void testSetValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            card = new Card('B', 1);
        }, "Cannot have a card with a suit other than 'H', 'D', 'C' or 'S'");
        assertThrows(IllegalArgumentException.class, () -> {
            card = new Card('S', 0);
        }, "Cannot have a card with a face value lower than 1");
        assertThrows(IllegalArgumentException.class, () -> {
            card = new Card('S', 14);
        }, "Cannot have a card with a face value higher than 13");
    }

@Test
    void testReadWrite() {
        CardDeck deck2 = new CardDeck();
        deck2.shuffleDeck();
        SaveScore.Save(20,100000);
        double mellom = Double.parseDouble(find.findFirstPlace());
        int x = (int) mellom;
        assertEquals(100000, x);

        SaveScore.Save(20,20000);
        double mellom2 = Double.parseDouble(find.findSecondPlace());
        int y = (int) mellom2;
        assertEquals(20000, y);

        SaveScore.Save(20,3000);
        double mellom3 = Double.parseDouble(find.findThirdPlace());
        int z = (int) mellom3;
        assertEquals(3000, z);
        
        
        
    }
}
