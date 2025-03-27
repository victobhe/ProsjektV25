package prosjekt;

import java.util.ArrayList;

public class CardHand {
    public int cardHandSum;
    ArrayList<Card> myCards = new ArrayList<>();

    public void addCard(Card card){
        if (under21()){
            myCards.add(card);
        }
    }
    public Card getLastCard(){
        return myCards.get(-1);
    }

    public int getSumCard(){
        int sum = 0;
        for (Card card : myCards) {
            if (sum > 21){
                for (Card card2 : myCards) {
                    if (card2.getValue() == 11){
                        card2.setValue(1);
                        break;
                    }
                }
            }
            sum += card.getValue();
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
