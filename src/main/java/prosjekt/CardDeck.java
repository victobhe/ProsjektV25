package prosjekt;


import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.image.Image;

public class CardDeck {
    ArrayList<Card> cards = new ArrayList<>();

    public CardDeck(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card card = null;
                switch (i) {
                    case 0:
                        card = new Card('S', j + 1);
                        break;
                    case 1:
                        card = new Card('H', j + 1);
                        break;
                    case 2:
                        card = new Card('D', j + 1);
                        break;
                    case 3:
                        card = new Card('C', j + 1);
                        break;
                    default:
                        break;
                }
                cards.add(card);
            }
        }
    }

    public int getCardCount(){
        return cards.size();
    }

    public Card getCard(int y) throws IllegalArgumentException {
        if (y < 0) {
            throw new IllegalArgumentException("The index of the wanted card must be a positive value");
        }
        if (y >= cards.size()) {
            throw new IllegalArgumentException("The index of the wanted card cannot be equal to or higher than the amount of cards in the deck");
        }
        Card card = cards.get(y);
        return card;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card deal(){
        return cards.remove(0);
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public void newDeck(){
        cards.clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card card = null;
                switch (i) {
                    case 0:
                        card = new Card('S', j + 1);
                        break;
                    case 1:
                        card = new Card('H', j + 1);
                        break;
                    case 2:
                        card = new Card('D', j + 1);
                        break;
                    case 3:
                        card = new Card('C', j + 1);
                        break;
                    default:
                        break;
                }
                cards.add(card);
            }
        }
        shuffleDeck();
    }

    /* public Image getImage(Card card){
        String path = "resources/prosjekt/images/cards/" + card.getFace() + card.getSuit() + ".png";
        Image image = new Image(path);
        return image;
    } */
    public Image getImage(Card card){
        String filepath = System.getProperty("user.dir");
        String path =  "file:" + filepath + "\\src\\main\\resources\\prosjekt\\images\\cards\\" + card.getFace() + card.getSuit() + ".png";
        Image image = new Image(path);
        return image;
    }
}