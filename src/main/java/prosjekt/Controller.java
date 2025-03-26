package prosjekt;

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
    private Label operator42;  //PlayerBett


    @FXML
    private Label totalSum;

    @FXML
    private Slider slider;  //PlayerBett



    private int playerScore = 0;
    private int dealerScore = 0;
    private double penger = 150;
    private double bett;
    
    CardDeck deck = new CardDeck();
    CardHand player = new CardHand();
    Dealer dealer = new Dealer(player);

    
    @FXML
    public void handleHit(){
        Card kort = deck.deal();
        player.addCard(kort);
        playerScore += kort.getValue();
        updateScore();
    }

    @FXML
    public void handleStand(){
        //dealer.play();
    }

    @FXML
    public void handleSave(){
        //.saveToFile
    }
    
    @FXML
    public void handleSlider(){
        slider.setMax(penger);
        this.bett =  (int) slider.getValue();  
        operator42.setText(bett + "");
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
    public void updatePenger(){
        if (didPlayerWin()){
            this.penger = penger + bett;
            operator4.setText(penger + "kr");
        }else{
           this.penger -= bett;
           operator4.setText(penger + "kr");
        }
    }


}
