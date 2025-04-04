package prosjekt;

import java.util.ArrayList;

public class Dealer implements CardGame{
    public int totalsum;
    public int mustBeat;
    
    public ArrayList<Card> myCards = new ArrayList<>();

    /* public Dealer(CardHand motspiller){
        this.mustBeat = motspiller.getSumCard();
    } */
    
    public void addCard(Card card){
        myCards.add(card);
        //totalsum += card.getValue();
    }

    //Tror at denne blir viktig når man skal implementere enkeltkort som skal dukke opp på skjermen.
    public Card getLastCard(){
        return myCards.get(-1);
    }

    public int getSumCard(){
        int sum = 0;
        int ess = 0;

        for (Card card : myCards) {
            sum += card.getValue();
            if (card.getValue() == 11){
                ess++;
            }
        }
        while (sum > 21 && ess > 0){
            sum -= 10;
            ess--;
        }
        return sum;
    }
    public boolean standOrHit() {
        this.totalsum = getSumCard();
        if (!under21()){
            return false;
        }
        if (mustBeat > 21){
            return false;
        }
        if (totalsum < mustBeat){
            return true;
        }
        return false;
    }

    public boolean under21(){
        return getSumCard() < 21;
    }
    
    public void returnCards(){
        this.myCards.clear();
    }
    
    
}