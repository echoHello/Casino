package codecrushermountaincasino;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Stella on 1/30/16.
 */

public class HandSpec {
    private Card queenOfHearts;
    private Card kingOfHearts;
    private Card jackOfHearts;

    Hand hand;

    @Before
    public void setUp() {
        hand = new Hand();
        jackOfHearts = new Card(Card.Rank.JACK, Card.Suit.HEARTS);
        kingOfHearts = new Card(Card.Rank.KING, Card.Suit.HEARTS);
        queenOfHearts = new Card(Card.Rank.QUEEN, Card.Suit.HEARTS);
        hand.addCard(jackOfHearts);
        hand.addCard(kingOfHearts);
        hand.addCard(queenOfHearts);

    }


    @Test
    public void addCardTest(){
        Card kingOfSpades = new Card(Card.Rank.KING, Card.Suit.SPADES);
        int lengthOfHandsArrayBeforeAdd = hand.getHand().size();
        hand.addCard(kingOfSpades);
        int lengthOfHandsArrayAfterAdd = hand.getHand().size();
        assertEquals("Card was not added", lengthOfHandsArrayBeforeAdd+1, lengthOfHandsArrayAfterAdd);
    }

    @Test
    public void removeCardTest(){
        //find a way to check if the card has been removed from the deck
        int lengthOfHandsArrayBeforeRemoveCard = hand.getHand().size();
        hand.removeCard(kingOfHearts);
        int lengthOfHandsArrayAfterRemoveCard = hand.getHand().size();
        assertEquals("Card was not removed", lengthOfHandsArrayBeforeRemoveCard-1, lengthOfHandsArrayAfterRemoveCard);
    }

    @Test
    public void removeCardIntTest(){
        int lengthOfHandsArrayBeforeRemoveCard = hand.getHand().size();
        hand.removeCard(2);
        int lengthOfHandsArrayAfterRemoveCard = hand.getHand().size();
        assertEquals("Card was not removed", lengthOfHandsArrayBeforeRemoveCard-1, lengthOfHandsArrayAfterRemoveCard);
    }



}
