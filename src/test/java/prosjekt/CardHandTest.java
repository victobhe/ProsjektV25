package prosjekt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardHandTest {
    CardHand hand = new CardHand();
    Card card = new Card('C', 10);
    Card card2 = new Card('C', 1);
    Card card3 = new Card('S', 4);
    
    @Test
    @DisplayName("Checks that the addCard() method correctly adds a given card to the hand myCards ArrayList")
    void testAddCard() {
        hand = new CardHand();
        assertTrue(hand.getSumCard() == 0, "The sum of the cards in the hand cannot be anything other than 0 when the hand contains no cards");
        hand.addCard(card);
        hand.addCard(card2);
        assertTrue(hand.getSumCard() == 21, "The method does not correctly sum the value of the cards in the hand");
        assertTrue(hand.getFirstCard() == card, "The first card inserted into the hand is not correctly placed in the first slot the hands myCards ArrayList");
    }


    @Test
    @DisplayName("Checks that the getSumCard() method correctly returns the expected cardHandSum value, and correctly reduces the value of an ace in the hand if the player hits to a sum above 21")
    void testGetSumCard() {
        hand = new CardHand();
        assertEquals(0, hand.getSumCard(), "The sum of the cards in the hand cannot be anything other than 0 when the hand contains no cards");
        hand.addCard(card);
        hand.addCard(card2);
        assertEquals(21, hand.getSumCard(), "The method does not correctly sum the value of the cards in the hand");
        hand.addCard(card3);
        assertEquals(15, hand.getSumCard(), "The method does not correctly decrease the value of an ace from 11 to 1 when reaching a sum above 21");

        hand = new CardHand();
        hand.addCard(card2);
        hand.addCard(card3);
        assertEquals(15, hand.getSumCard(), "The method does not correctly sum the value of the cards in the hand");
        hand.addCard(card);
        assertEquals(15, hand.getSumCard(), "The method does not correctly decrease the value of an ace from 11 to 1 when reaching a sum above 21");
        hand.addCard(card2);
        assertEquals(16, hand.getSumCard(), "The method does not correctly decrease the value of an ace from 11 to 1 when reaching a sum above 21");
    }

    @Test
    @DisplayName("Checks that the returnCards() method correctly empties the CardHand myCards ArrayList")
    void testReturnCards() {
        hand.addCard(card);
        assertTrue(hand.getSumCard() == 10);
        hand.returnCards();
        assertTrue(hand.getSumCard() == 0, "The method does not correctly empty the CardHand myCards ArrayList");
    }

    @Test
    void testUnder21() {
        assertTrue(hand.under21());
        hand.addCard(card);
        assertTrue(hand.under21());
        hand.addCard(card);
        assertTrue(hand.under21());
        hand.addCard(card2);
        assertFalse(hand.under21());
        hand.addCard(card2);
        assertFalse(hand.under21());





    }
}
