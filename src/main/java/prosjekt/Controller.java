package prosjekt;


import java.lang.Thread;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;


public class Controller {
    
    //Knapper og div
    @FXML 
    private Button Hit;
    
    @FXML 
    private Button Stand;  
    
    @FXML 
    private Button Save;  

    @FXML 
    private Button NewGame; 

    
    @FXML 
    private Label operator4; //Pengepung
    
    @FXML 
    private Label operator42;  //PlayerBet

    @FXML 
    private Label totalSum;  // totalsum til player
    
    @FXML 
    private Label totalSumField;  // totalsum til Dealer


    @FXML 
    private Slider slider;  //PlayerBet

    //tanken er at man ikke kan starte spillet før et bet er lagt inn og at man da skal trykke på new game og få to kort


    private int playerScore = 0;
    private int dealerScore = 0;
    private double penger = 100;
    private double bet;
    
    CardDeck deck = new CardDeck();
    CardHand player = new CardHand();
    Dealer dealer = new Dealer();

    
    @FXML
    private void handleHit(){
        Card kort = deck.deal();
        player.addCard(kort);
        playerScore = player.getSumCard();
        updateScore();
    }

    @FXML
    private void handleStand(){
        Hit.setDisable(true);
        play(player);
        Stand.setDisable(true);
    }

    @FXML
    private void handleSave(){
        SaveScore.Save((playerScore + dealerScore), penger);
    }
    
    @FXML
    private void handleSlider(){
        slider.setMax(penger);
        this.bet =  (int) slider.getValue();  
        operator42.setText(String.valueOf(bet));
    }
    @FXML
    private void handleNewGame(){
        this.playerScore = 0;
        this.dealerScore = 0;
        player.returnCards();
        dealer.returnCards();
        deck.newDeck();
        Hit.setDisable(false);
        Stand.setDisable(false);
        Save.setDisable(false);
        handleHit();
        handleHit();
        dealer.addCard(deck.deal()); 
        this.dealerScore = dealer.getSumCard();
        updateDealerScore();
    }

    @FXML
    private void updateScore(){
        if (playerScore >= 22){
            Hit.setDisable(true);
        }
        totalSum.setText(String.valueOf(playerScore));
    }
    
    @FXML
    private void updateDealerScore(){
        totalSumField.setText(String.valueOf(dealerScore));
    }

    @FXML
    private boolean didPlayerWin(){
        if (playerScore > 21){
            return false;
        }
        if (dealerScore < 22 && dealerScore > playerScore){
            return false;
        }
        return true;
    }
    @FXML
    private void play(CardHand hand){
        dealer.mustBeat = hand.getSumCard();
        dealer.totalsum = dealer.getSumCard();
            while (dealer.standOrHit()){
                Card kort = deck.deal();
                dealer.addCard(kort);
                dealer.totalsum = dealer.getSumCard();
                this.dealerScore = dealer.getSumCard();
                updateDealerScore();
                sleeper();
            }
            updatePenger();          
    }
    private void sleeper(){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new IllegalArgumentException("legge seg!");
        }
    }
    @FXML
    private void updatePenger(){
        if (dealerScore == playerScore){
            
        }else if (didPlayerWin()) {
            this.penger = penger + bet;
            operator4.setText(penger + "kr");
        } else {
            this.penger = penger - bet;
            operator4.setText(penger + "kr");
        }
    }
}
