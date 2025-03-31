package prosjekt;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;


public class Controllercopy{
    
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
    HelpController help = new HelpController();
    
    @FXML
    private void handleHit(){
        help.helphandleHit(deck, player, playerScore);
        updateScore();
    }

    @FXML
    private void handleStand(){
        help.helphandleStand(Hit,Stand);
        play(player);
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
        return help.helpdidPlayerWin(playerScore, dealerScore);
    }
    @FXML
    private void play(CardHand hand){
        help.play(deck, hand, dealer, playerScore, dealerScore, totalSumField);
        updatePenger();          
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
