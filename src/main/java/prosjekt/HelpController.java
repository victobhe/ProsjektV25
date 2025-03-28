package prosjekt;


import java.lang.Thread;

import javafx.scene.control.Label;
import javafx.scene.control.Button;



public class HelpController {
    
    //jeg tror ikke vi trenger å bruke denne her men bare begynte siden ja...
    
    
    protected void helphandleHit(CardDeck deck, CardHand player, int playerScore){
        Card kort = deck.deal();
        player.addCard(kort);
        playerScore = player.getSumCard();
    }

    protected void handleStand(Button Hit, Button Stand){
        Hit.setDisable(true);
        Stand.setDisable(true);
    }
    
    

    
    protected boolean helpdidPlayerWin(int playerScore, int dealerScore){
        if (playerScore > 21){
            return false;
        }
        if (dealerScore < 22 && dealerScore > playerScore){
            return false;
        }
        return true;
    }
    private void updateDealerScore(Label totalSumField, int dealerScore){
        totalSumField.setText(String.valueOf(dealerScore));
    }
    
    protected void play(CardDeck deck, CardHand hand, Dealer dealer,int playerScore, int dealerScore, Label totalSumField){
        dealer.mustBeat = hand.getSumCard();
        dealer.totalsum = dealer.getSumCard();
            while (dealer.standOrHit()){
                Card kort = deck.deal();
                dealer.addCard(kort);
                dealer.totalsum = dealer.getSumCard();
                dealerScore = dealer.getSumCard();
                updateDealerScore(totalSumField, dealerScore);
                sleeper();
            }

                     
    }
    protected void sleeper(){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new IllegalArgumentException("legge seg!");
        }
    }
    
    

}
