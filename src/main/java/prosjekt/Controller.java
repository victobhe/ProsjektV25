package prosjekt;

import java.lang.Thread;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

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
    private Label forsteplass;  // plasser til leaderboard

    @FXML 
    private Label andreplass;

    @FXML 
    private Label tredjeplass;


    @FXML 
    private Slider slider;  //PlayerBet

    //bilder av kort
    
    @FXML
    private ImageView Card1;
    @FXML
    private ImageView Card2;
    @FXML
    private ImageView Card3;
    @FXML
    private ImageView Card4;
    @FXML
    private ImageView Card5;
    @FXML
    private ImageView hiddenCard;
    @FXML
    private ImageView Dcard1;
    @FXML
    private ImageView Dcard2;
    @FXML
    private ImageView Dcard3;
    @FXML
    private ImageView Dcard4;
    @FXML
    private ImageView Dcard5;


    //tanken er at man ikke kan starte spillet før et bet er lagt inn og at man da skal trykke på new game og få to kort


    private int playerScore = 0;
    private int dealerScore = 0;
    private double penger = 100;
    private double bet;
    private int ant_kort = 1; //antall kort trukket, brukes både til player og dealer
    
    CardDeck deck = new CardDeck();
    CardHand player = new CardHand();
    Dealer dealer = new Dealer();
    HelpController help = new HelpController();
    FindScore findScore = new FindScore();
    
    @FXML
    private void handleHit(){
        Card kort = deck.deal();
        player.addCard(kort);
        playerScore = player.getSumCard();
        updateScore();
        slider.setDisable(true);
        switch (ant_kort) {
            case 1:
                Card1.setImage(deck.getImage(kort));
                break;
            case 2:
                Card2.setImage(deck.getImage(kort));
                break;
            case 3:
                Card3.setImage(deck.getImage(kort));
                break;
            case 4:
                Card4.setImage(deck.getImage(kort));
                break;
            case 5:
                Card5.setImage(deck.getImage(kort));
                break;
            default:
                break;
        }
        ant_kort++;
    }
    @FXML
    private void handleStand(){
        Hit.setDisable(true);
        Stand.setDisable(true);
        play(player);
    }

    @FXML
    private void handleSave(){
        SaveScore.Save((playerScore + dealerScore), penger);
        penger = 100;
        operator4.setText(penger + "kr");
    }
    
    @FXML
    private void handleSlider(){
        slider.setMax(penger);
        this.bet =  (int) slider.getValue();  
        operator42.setText(String.valueOf(bet));
    }
    @FXML
    private void handleNewGame(){
        forsteplass.setText("1. " + findScore.findFirstPlace() + "kr");
        andreplass.setText("2. " + findScore.findSecondPlace() + "kr");
        tredjeplass.setText("3. " + findScore.findThirdPlace() + "kr");
        this.playerScore = 0;
        this.dealerScore = 0;
        player.returnCards();
        dealer.returnCards();
        deck.newDeck();
        Hit.setDisable(false);
        Stand.setDisable(false);
        Save.setDisable(false);
        hiddenCard.setVisible(true);
        help.resetTable(Card1, Card2, Card3, Card4, Card5, Dcard1, Dcard2, Dcard3, Dcard4, Dcard5);
        this.ant_kort = 1;
        handleHit();
        handleHit();
        Card kort = deck.deal();
        dealer.addCard(kort); 
        slider.setDisable(false);
        this.dealerScore = dealer.getSumCard();
        updateDealerScore();
        Dcard1.setImage(deck.getImage(kort));
        

    }

    @FXML
    private void updateScore(){
        this.playerScore = player.getSumCard();
        totalSum.setText(String.valueOf(playerScore));
        if (playerScore >= 22){
            Hit.setDisable(true);
        }
    }
    
    @FXML
    private void updateDealerScore(){
        this.dealerScore = dealer.getSumCard();
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
        //dealer.totalsum = dealer.getSumCard();
        this.ant_kort = 1;
        Card card = deck.deal();
        dealer.addCard(card);
        Dcard2.setImage(deck.getImage(card));
            while (dealer.standOrHit()){
                System.out.println(dealerScore);
                Card kort = deck.deal();
                dealer.addCard(kort);
                switch (ant_kort) {
                    case 1:
                        Dcard3.setImage(deck.getImage(kort));
                        break;    
                    case 2:
                        Dcard4.setImage(deck.getImage(kort));
                        break;
                    case 3:
                        Dcard5.setImage(deck.getImage(kort));
                        break;
                }
                ant_kort++;
                sleeper();
            }
        updateDealerScore();
        updatePenger();          
    }




    //@SuppressWarnings("unused") //gidder ikke vente når jeg skal teste koden
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
