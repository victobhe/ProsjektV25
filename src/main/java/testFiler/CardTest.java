/* package testFiler;
import prosjekt.Card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class CardTest {
    Card card;

    @Test
    @DisplayName("Checks that the Card constructor only accepts desirable values");
    void testConstructor() {
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
 */