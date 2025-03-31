package prosjekt;


import java.lang.Thread;

import javafx.scene.control.Label;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;



public class HelpController {
    
    //jeg tror ikke vi trenger å bruke denne her men bare begynte siden ja...
    public int ant_kort = 1;
    
    protected void resetTable(ImageView a, ImageView b, ImageView c, ImageView d, ImageView e, ImageView f, ImageView g, ImageView h, ImageView i, ImageView j){
        a.setImage(null);
        b.setImage(null);
        c.setImage(null);
        d.setImage(null);
        e.setImage(null);
        f.setImage(null);
        g.setImage(null);
        h.setImage(null);
        i.setImage(null);
        j.setImage(null);

    }
    
    
    protected void helphandleHit(CardDeck deck, CardHand player, int playerScore){
        Card kort = deck.deal();
        player.addCard(kort);
        playerScore = player.getSumCard();
    }

    protected void helphandleStand(Button Hit, Button Stand){
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
