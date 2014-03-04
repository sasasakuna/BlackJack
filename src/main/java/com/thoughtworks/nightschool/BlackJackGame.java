package com.thoughtworks.nightschool;


import com.thoughtworks.nightschool.dealerstrategies.DealerHandResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class BlackJackGame {

    private Shoe shoe;
    private Player dealersPlayer;
    private Player playersPlayer;

    //todo: fix this so dealer's strategy can be injected
    @Autowired
    private DealerHandResolver dealerHandResolver;

    public BlackJackGame(){
        this.shoe = new Shoe(6);

        dealersPlayer = new Player();
        dealersPlayer.addCard(shoe.draw());

        playersPlayer = new Player();
        playersPlayer.addCard(shoe.draw());
        playersPlayer.addCard(shoe.draw());

    }

    public Player getDealersPlayer() {
        return dealersPlayer;
    }

    public Player getPlayersPlayer() {
        return playersPlayer;
    }

    public void setPlayersPlayer(Player player) {
        this.playersPlayer = player;
    }

    public void setDealersPlayer(Player player) {
        this.dealersPlayer = player;
    }

    public void playerHit(){
        playersPlayer.addCard(shoe.draw());
    }

    public void dealerHit(){
        dealersPlayer.addCard(shoe.draw());
    }

    public boolean playerBusted() {
        boolean allTotalsBusted = true;
        for(Integer totals : playersPlayer.getTotals()){
            if (totals <= 21){
                allTotalsBusted = false;
            }
        }
        return allTotalsBusted;
    }

    //Return false if any total is less than 21
    public boolean dealerBusted() {
        for(Integer totals : dealersPlayer.getTotals()){
            if (totals <= 21){
                return false;
            }
        }
        return true;
    }

    public void resolveDealerHand() {
        while (!dealerBusted() && dealerBelowSeventeen()) {
            dealerHit();
        }
    }

    //If any total is >= 17 but not a bust do no hit
    private boolean dealerBelowSeventeen() {
        for (Integer totals : getDealersPlayer().getTotals()) {
            if (totals >= 17 && totals < 22){ //Do not hit if dealers has 17 or greater
                return false;
            }
        }
        return true;
    }

    public String result(){
        if (playerBusted() || dealersPlayer.blackJack()){
            return "You lose! :(";
        }else if (playersPlayer.blackJack()){
            return "You win!";
        }else if (playersPlayer.finalTotal().equals(dealersPlayer.finalTotal())){
            return "Push";
        }else if ( (playersPlayer.finalTotal() < dealersPlayer.finalTotal()) && (dealersPlayer.finalTotal() < 22)){
            return "You lose! :(";
        }else{
            return "You win!";
        }
    }
}
