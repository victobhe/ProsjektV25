package prosjekt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class CardTest {
    private Card card;

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
            card = new Card('S', 14);
        }, "Cannot have a card with a face value higher than 13");
        card = new Card('S', 1);
    }

    @Test
    @DisplayName("Checks that the Card constructor correctly sets the correct face value")
    void testFaceConstructor() {
        card = new Card('S', 6);
        assertEquals("6", card.getFace(), "The constructor does not set the expected value (String \"6\")");
        card = new Card('S', 11);
        assertEquals("J", card.getFace(), "The constructor does not set the expected value (String \"J\")");
        card = new Card('S', 12);
        assertEquals("Q", card.getFace(), "The constructor does not set the expected value (String \"Q\")");
        card = new Card('S', 13);
        assertEquals("K", card.getFace(), "The constructor does not set the expected value (String \"K\")");
        card = new Card('S', 1);
        assertEquals("A", card.getFace(), "The constructor does not set the expected value (String \"A\")");
    }

    @Test
    @DisplayName("Checks that the Card constructor correctly sets the correct value value")
    void testValueConstructor() {
        card = new Card('S', 3);
        assertEquals(3, card.getValue(), "The constructor does not set the expected value (Int 3)");
        card = new Card('S', 1);
        assertEquals(11, card.getValue(), "The constructor does not set the expected value (Int 11)");
        card = new Card('S', 11);
        assertEquals(10, card.getValue(), "The constructor does not set the expected value (Int 10)");
        card = new Card('S', 12);
        assertEquals(10, card.getValue(), "The constructor does not set the expected value (Int 10)");
        card = new Card('S', 13);
        assertEquals(10, card.getValue(), "The constructor does not set the expected value (Int 10)");
    }

    @Test
    @DisplayName("Checks that the setValue() method cannot set unwanted values")
    void testSetValue() {
        card = new Card('S', 1);
        assertThrows(IllegalArgumentException.class, () -> {
            card.setValue(0);
        }, "Cannot set the value of a card to a value lower than 1");
        assertThrows(IllegalArgumentException.class, () -> {
            card.setValue(12);
        }, "Cannot set the value of a card to a value higher than 11");
    }
}
