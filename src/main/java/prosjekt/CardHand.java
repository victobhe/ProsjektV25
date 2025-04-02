package prosjekt;

import java.util.ArrayList;

public class CardHand  implements CardGame{
    public int cardHandSum;
    ArrayList<Card> myCards = new ArrayList<>();

    public CardHand() {
        myCards = new ArrayList<>();
        cardHandSum = 0;
    }

    public void addCard(Card card){
        if (under21()){
            myCards.add(card);
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
        return (sum < 21);
    }

    public void returnCards(){
        this.myCards.clear();
    }
}
    
