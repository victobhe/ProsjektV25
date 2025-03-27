package prosjekt;

import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;


public class Controller {
    
    //Knapper og div
    @FXML private Button Hit;
    
    @FXML
    private Button Stand;  
    
    @FXML
    private Button Save;  
    

    @FXML
    private Label operator4; //Pengepung
    
    @FXML
    private Label operator42;  //PlayerBet


    @FXML
    private Label totalSum;

    @FXML
    private Slider slider;  //PlayerBet



    private int playerScore = 0;
    private int dealerScore = 0;
    private double penger = 100;
    private double bet;
    
    CardDeck deck = new CardDeck();
    CardHand player = new CardHand();
    Dealer dealer = new Dealer();

    
    @FXML
    public void handleHit(){
        Card kort = deck.deal();
        player.addCard(kort);
        playerScore += kort.getValue();
        updateScore();
    }

    @FXML
    public void handleStand(){
        play(player);
    }

    @FXML
    public void handleSave(){
        SaveScore.Save((playerScore + dealerScore), penger);
    }
    
    @FXML
    public void handleSlider(){
        slider.setMax(penger);
        this.bet =  (int) slider.getValue();  
        operator42.setText(bet + "");
    }

    @FXML
    public void updateScore(){
        totalSum.setText(playerScore + "");
    }

    @FXML
    public boolean didPlayerWin(){
        if (playerScore > 21){
            return false;
        }
        if (dealerScore < 22 && dealerScore > playerScore){
            return false;
        }
        return true;
    }
    @FXML
    public void play(CardHand hand){
        dealer.mustBeat = hand.getSumCard();
        dealer.totalsum = dealer.getSumCard();

        new Thread(() -> {
            try{
                while (dealer.standOrHit()){
                    Card kort = deck.deal();
                    dealer.addCard(kort);
                    dealer.totalsum = dealer.getSumCard();
                    TimeUnit.SECONDS.sleep(1);        
                    }
                this.dealerScore = dealer.getSumCard();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }).start();

    }

    @FXML
    public void updatePenger(){
        if (didPlayerWin()) {
            this.penger = penger + bet;
            operator4.setText(penger + "kr");
        } else {
            this.penger -= bet;
            operator4.setText(penger + "kr");
        }
    }


}
