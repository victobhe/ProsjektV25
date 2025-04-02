package prosjekt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CardDeckTest {
    CardDeck deck = new CardDeck();
    CardHand hand = new CardHand();
    Card card = new Card('S', 3);
    SaveScore save = new SaveScore();
    FindScore find = new FindScore();

    @Test
    @DisplayName("Checks that the constructor correctly makes a new deck of 52 cards")
    public void testConstructor() {
        deck = new CardDeck();
        assertEquals(52, deck.getCardCount(), "The constructor does not make a new deck containing 52 cards");
    }

    @Test
    @DisplayName("Checks that the deal() method returns the card at the top of the deck (index 0) whilst removing it from the deck")
    public void testDeal() {
        card = deck.getCard(0);
        assertEquals(card, deck.deal(), "The method does not return (deal) the card at the top of the deck (index 0)");
        assertEquals(51, deck.getCardCount(), "The method has not removed the drawn card from the deck");
        card = deck.getCard(0);
        assertEquals(card, deck.deal(), "The method does not return (deal) the card at the top of the deck (index 0)");
        assertEquals(50, deck.getCardCount(), "The method has not removed the drawn card from the deck");
    }

    @Test
    @DisplayName("Checks that the getCard(int) method only accepts desired values")
    public void testGetCard() {
        deck = new CardDeck();
        assertThrows(IllegalArgumentException.class, () -> {
            deck.getCard(-1);
        }, "The index of the wanted card must be a positive value");
        assertThrows(IllegalArgumentException.class, () -> {
            deck.getCard(-1);
        }, "The index of the wanted card must be a positive value");
        assertThrows(IllegalArgumentException.class, () -> {
            deck.getCard(52);
        }, "The index of the wanted card cannot be equal to or higher than the amount of cards in the deck");
    }

    @Test
    @DisplayName("Checks that the shuffleDeck() method shuffles the cards ArrayList")
    public void testShuffleDeck() {
        CardDeck deck2 = new CardDeck();
        deck2.shuffleDeck();
        assertTrue(deck.getCards() != deck2.getCards(), "The new deck has not been shuffled and is equal to the not shuffled first deck");
    }

    @Test
    @DisplayName("Checks that the newDeck() method correctly replenishes a deck to 52 cards")
    public void testNewDeck() {
        for (int i = 0; i < 11; i++) {
            deck.deal();
        }
        deck.newDeck();
        assertEquals(52, deck.getCardCount(), "The method does not replenish the deck to 52 cards");
    }

    @Test
    public void testReadWrite() {
        try {
            PrintWriter printer = new PrintWriter("scores.txt");
            printer.print("100" + " \n");
            printer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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
