package prosjekt;

public class Card {
    private char suit;
    private String face;
    private int value;
    
    public Card(char suit, int face) {
        this.suit = suit;
        if (face >= 2 && face <= 10) {
            this.face = Integer.toString(face);
            this.value = face;
        } else if (face >= 11 && face <= 13) {
            this.value = 10;
        }
        switch (face) {
            case 1:
                this.face = "A";
                this.value = 11;
                break;
            case 11:
                this.face = "J";
                break;
            case 12:
                this.face = "Q";
                break;
            case 13:
                this.face = "K";
                break;
            default:
                break;
        }

    }

    public char getSuit() {
        return suit;
    }

    public String getFace() {
        return face;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(suit) + String.valueOf(face);
    }
}
