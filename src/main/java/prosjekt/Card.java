package prosjekt;

public class Card {
    private char suit;
    private String face;
    private int value;
    
    public Card(char suit, int face) throws IllegalArgumentException {
        if (suit != 'H' && suit != 'D' && suit != 'C' && suit != 'S') {
            throw new IllegalArgumentException("The suit of the card must be one of H, D, C and S");
        }
        this.suit = suit;
        if (face <= 0 || face >= 14) {
            throw new IllegalArgumentException("The face of the card must be a value equal to or higher than 1 and equal to or lower than 13");
        }
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
    public void setValue(int i){
        this.value = i;
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
