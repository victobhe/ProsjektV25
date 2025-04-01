package prosjekt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class CardTest {
    Card card;
    
    @Test
    @DisplayName("Checks that the Card constructor only accepts desirable values")
    void testConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            card = new Card('B', 1);
        }, "Cannot have a card with a suit other than 'H', 'D', 'C' or 'S'");
        assertThrows(IllegalArgumentException.class, () -> {
            card = new Card('S',0);
        }, "Cannot have a card with a face value lower than 1");
        assertThrows(IllegalArgumentException.class, () -> {
            card = new Card('S',-1);
        }, "Cannot have a card with a face value lower than 1");
        assertThrows(IllegalArgumentException.class, () -> {
            card = new Card('S', 14);
        }, "Cannot have a card with a face value higher than 13");
        card = new Card('S', 1);
    }

    @Test
    @DisplayName("Checks that the getFace() method returns the correct value")
    void testGetFace() {
        card = new Card('S', 2);
        assertEquals("2", card.getFace(), "getFace() does not return the expected value (String \"2\")");
        card = new Card('S', 7);
        assertEquals("7", card.getFace(), "getFace() does not return the expected value (String \"7\")");
        card = new Card('S', 11);
        assertEquals("J", card.getFace(), "getFace() does not return the expected value (String \"J\")");
        card = new Card('S', 12);
        assertEquals("Q", card.getFace(), "getFace() does not return the expected value (String \"Q\")");
        card = new Card('S', 13);
        assertEquals("K", card.getFace(), "getFace() does not return the expected value (String \"K\")");
        card = new Card('S', 1);
        assertEquals("A", card.getFace(), "getFace() does not return the expected value (String \"A\")");
    }

    @Test
    void testGetSuit() {

    }

    @Test
    void testGetValue() {

    }

    @Test
    void testSetValue() {

    }
}
