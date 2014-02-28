package com.thoughtworks.nightschool.DealerStrategies;

import com.thoughtworks.nightschool.BlackJackGame;

public abstract class AbstractDealerHandResolver implements DealerHandResolver {

    protected BlackJackGame blackJackGame;

    public AbstractDealerHandResolver(BlackJackGame blackJackGame) {
        this.blackJackGame = blackJackGame;
    }

    protected AbstractDealerHandResolver() {
    }
}
