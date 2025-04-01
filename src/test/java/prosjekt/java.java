package prosjekt;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import prosjekt.Card;
import prosjekt.Dealer;

public class java {
    Dealer dealer = new Dealer();
    Card kort1 = new Card('S', 9);
    dealer addCard(kort1);
    Card card;
    @Test
    void testTestConstructor() {
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
}
