package com.thoughtworks.nightschool;

import java.lang.String;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card {

    private Value value;
    private Suit suit;

    public Card(Suit suit, Value value) {
        this.value = value;
        this.suit = suit;
    }

    public Value getIntValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {

        String value = valuePrintMap.get(this.getIntValue());
        String suit = suitPrintMap.get(this.getSuit());

        return "" + suit +  value + "";
    }

    private static final Map<Value,String> valuePrintMap;
    static {
        Map<Value,String> m = new HashMap<Value,String>();
//        m.put(Value.ACE,'A');
//        m.put(Value.TWO,'2');
//        m.put(Value.THREE,'3');
//        m.put(Value.FOUR,'4');
//        m.put(Value.FIVE,'5');
//        m.put(Value.SIX,'6');
//        m.put(Value.SEVEN,'7');
//        m.put(Value.EIGHT,'8');
//        m.put(Value.NINE,'9');
//        m.put(Value.TEN,'T');
//        m.put(Value.JACK,'J');
//        m.put(Value.QUEEN,'Q');
//        m.put(Value.KING,'K');

        m.put(Value.ACE,"Ace.jpg");
        m.put(Value.TWO,"2.jpg");
        m.put(Value.THREE,"3.jpg");
        m.put(Value.FOUR,"4.jpg");
        m.put(Value.FIVE,"5.jpg");
        m.put(Value.SIX,"6.jpg");
        m.put(Value.SEVEN,"7.jpg");
        m.put(Value.EIGHT,"8.jpg");
        m.put(Value.NINE,"9.jpg");
        m.put(Value.TEN,"10.jpg");
        m.put(Value.JACK,"Jack.jpg");
        m.put(Value.QUEEN,"Queen.jpg");
        m.put(Value.KING,"King.jpg");
        valuePrintMap = Collections.unmodifiableMap(m);
    }

    private static final Map<Suit,String> suitPrintMap;
    static {
        Map<Suit,String> m = new HashMap<Suit,String>();
//        m.put(Suit.SPADE,'\u2660');
//        m.put(Suit.HEART,'\u2665');
//        m.put(Suit.DIAMOND,'\u2666');
//        m.put(Suit.CLUB,'\u2663');
        //m.put(Suit.SPADE,'S');
        //m.put(Suit.HEART,'H');
        //m.put(Suit.DIAMOND,'D');
        //m.put(Suit.CLUB,'C');

        m.put(Suit.SPADE,"images/cards/Spades/");
        m.put(Suit.HEART,"images/cards/Hearts/");
        m.put(Suit.DIAMOND,"images/cards/Diamonds/");
        m.put(Suit.CLUB,"images/cards/Clubs/");

        suitPrintMap = Collections.unmodifiableMap(m);
    }

}
