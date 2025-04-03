package prosjekt;

import java.util.ArrayList;

public class CardHand  implements CardGame{
    public int cardHandSum;
    ArrayList<Card> myCards = new ArrayList<>();

    public void addCard(Card card){
        myCards.add(card);
        if (under21()){
        }
    }
    public Card getFirstCard(){
        return myCards.get(0);
    }

    public int getSumCard(){
        int sum = 0;
        int ess = 0;

        for (Card card : myCards) {
            if (card.getValue() == 11){
                ess++;
            }
            sum += card.getValue();
        }
        while (sum > 21 && ess > 0){
            sum -= 10;
            ess--;
        }
        return sum;
    }

    public boolean under21(){
        int sum = 0;
        for (Card card : myCards) {
            sum += card.getValue();
        }
        return (sum < 22);
    }

    public void returnCards(){
        this.myCards.clear();
    }
    public static void main(String[] args) {
        Card kort1 = new Card('S', 11);
        Card kort2 = new Card('S', 9);
        Card kort3 = new Card('S', 3);
        Card kort4 = new Card('S', 1);

        CardHand hand = new CardHand();
        hand.addCard(kort1);
        hand.addCard(kort4);
        System.out.println(hand.getSumCard());
        hand.addCard(kort2);
        System.out.println(hand.getSumCard());

        hand.addCard(kort3);
        System.out.println(hand.getSumCard());

    }
    }
    
