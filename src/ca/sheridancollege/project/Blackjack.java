/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.*;

/**
 *
 * @author kwamz
 */
public class Blackjack extends Game{
    private int playerScore;
    private int dealerScore;
    private List<Integer> deck;

    public Blackjack(String name) {
        super(name);
        playerScore = 0;
        dealerScore = 0;
        deck = new ArrayList<Interger>();
        for(int i = 1; i <= 10; i++){
            for(int j = 0; j < 4; j++){
                deck.add(i);
            }
        }
        Collections.shuffle(deck);
    }

    private Blackjack() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void play() {
        System.out.println("Welcome to Blackjack");
        dealcards();
        playerTurn();
        dealerTurn();
        calculateScores();
        declareWinner();
    }

    @Override
    public void declareWinner() {
        if (playerScore > 21) {
            System.out.println("You lose!!");
        } else if (dealerScore > 21) {
            System.out.println("You win!");
        } else if (dealerScore > playerScore) {
            System.out.println("You lose!");
        } else {
            System.out.println("It's a draw");
        }
    }

    private void dealcards() {
        System.out.println("Declearing Cards......");
        playerScore = 0;
        dealerScore = 0;
        for (int i = 0; i < 2; i++) {
            int card = deck.remove(0);
            playerScore += card;
            System.out.println("Youre were dealt a " + card);
            card = deck.remove(0);
            dealerScore += card;
            if (i == 0) {
                System.out.println("The dealer was dealt a hidden card");
            } else {
                System.out.println("The dealer was dealt a " + card);
            }
        }
    }
    
    public static void main(String[] args){
        Blackjack blackjack = new Blackjack();
        blackjack.play();
    }
    
    private void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("You score is " + playerScore);
            System.out.print("Do you want to hit or stand?");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("hit")) {
                int card = deck.remove(0);
                playerScore += card;
                System.out.println("You were dealt a " + card);
                if (playerScore > 21){
                    System.out.println("Dang!!! Your score is " + playerScore);
                    return;
                }
            } else if(input.equals("stand")){
                System.out.println("You have a score of " + playerScore);
                return;
            } else{
                System.out.println("Invalid input, please enter 'hit' or 'stand'");
            }     
        }
    }

    private void dealerTurn() {
        System.out.println("Dealer's turn.....");
        System.out.println("The dealer has a hidden card and that card is" + deck.get(0));
        while(dealerScore < 17){
            int card = deck.remove(0);
            dealerScore += card;
            System.out.println("The dealer hit and gets a " + card + ", for a score of " + dealerScore);
            if (dealerScore > 21){
                System.out.println("Too bad, the dealer busts!! Their score is " + dealerScore);
                return;       
            }
        }
            
            System.out.println("Dealer has a score of " + dealerScore);
    }

    private void calculateScores() {
        System.out.println("Calculating scores...... please wait");
        System.out.println("Your score is " + playerScore);
        System.out.println("The dealer's score is " + dealerScore);
    }

}

