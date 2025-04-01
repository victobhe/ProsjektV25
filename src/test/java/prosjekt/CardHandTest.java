package prosjekt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CardHandTest {
    CardHand hand = new CardHand();
    Card card = new Card('C', 10);
    Card card2 = new Card('C', 1);
    @Test
    void testAddCard() {
        assertFalse(hand.getSumCard() != 0);
        hand.addCard(card);
        hand.addCard(card);
        assertTrue(hand.getSumCard() == 20);
        assertTrue(hand.getFirstCard() == card);
    }


    @Test
    void testGetSumCard() {
        assertTrue(hand.getSumCard() == 0);

        hand.addCard(card);
        hand.addCard(card);
        assertTrue(hand.getSumCard() == 20);

        hand.addCard(card);
        assertTrue(hand.getSumCard() == 30);
        hand.addCard(card);
    }

    @Test
    void testReturnCards() {
        hand.addCard(card);
        assertTrue(hand.getSumCard() == 10);
        hand.returnCards();
        assertTrue(hand.getSumCard() == 0);
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
