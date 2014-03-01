package com.thoughtworks.nightschool;


import com.thoughtworks.nightschool.DealerStrategies.DealerHandResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class BlackJackGame {

    private Shoe shoe;
    private Role dealers;
    private Role players;

    //todo: fix this so dealer's strategy can be injected
    @Autowired
    private DealerHandResolver dealerHandResolver;

    public BlackJackGame(){
        this.shoe = new Shoe(6);

        dealers = new Role();
        dealers.addCard(shoe.draw());

        players = new Role();
        players.addCard(shoe.draw());
        players.addCard(shoe.draw());

    }


    public Role getDealers() {
        return dealers;
    }

    public Role getPlayers() {
        return players;
    }

    public void setPlayers(Role role) {
        this.players = role;
    }

    public void setDealers(Role role) {
        this.dealers = role;
    }

    public void playerHit(){
        players.addCard(shoe.draw());
    }

    public void dealerHit(){
        dealers.addCard(shoe.draw());
    }


    public boolean playerBusted() {
        boolean allTotalsBusted = true;
        for(Integer totals : players.getTotals()){
            if (totals <= 21){
                allTotalsBusted = false;
            }
        }
        return allTotalsBusted;
    }

    //Return false if any total is less than 21
    public boolean dealerBusted() {
        for(Integer totals : dealers.getTotals()){
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
        for (Integer totals : getDealers().getTotals()) {
            if (totals >= 17 && totals < 22){ //Do not hit if dealers has 17 or greater
                return false;
            }
        }
        return true;
    }

    public String result(){
        if (playerBusted() || dealers.blackJack()){
            return "You lose! :(";
        }else if (players.blackJack()){
            return "You win!";
        }else if (players.finalTotal().equals(dealers.finalTotal())){
            return "Push";
        }else if ( (players.finalTotal() < dealers.finalTotal()) && (dealers.finalTotal() < 22)){
            return "You lose! :(";
        }else{
            return "You win!";
        }
    }
}
