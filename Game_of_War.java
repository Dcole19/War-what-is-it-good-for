package War;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game_of_War {
  List<String> people = List.of("Jack", "Thomas", "Jill", "Rand", "Gwen");
  
  Random random = new Random();
  
  public static void main(String[] args) {
    new Game_of_War().playWar();
  }
  
  private void playWar() {
    List<String> playerNames = new LinkedList<>(people);
   Player player1 = findPlayer(playerNames);
   Player player2 = findPlayer(playerNames);
   Deck deck = new Deck();
   
   // Time to play the game
   shuffleDeck(deck);
   dealTheCards(player1, player2, deck);
   playTheGame(player1, player2);
   determineWinner(player1, player2);
  }
  
  
//determine the winner
  private void determineWinner(Player player1, Player player2) {
   Player winner = null;
   Player loser = null;
    
    if (player1.getScore() >player2.getScore()) {
      winner = player1;
      loser = player2;
    }
    else {
      winner = player2;
      loser = player1;
    }
    
     // unused code..... had to add .getscore to winner 
    //and loser to get tie to work. 
    if (winner.getScore() == loser.getScore()) {
      System.out.println("Its a Tie between " + 
    player1.getName() +   " and " + player2.getName() + "!!!");
    }
    else {
      System.out.println("The winner is " + winner.getName() 
      + " with a score of " + winner.getScore());
      
      System.out.println("The loser is " + loser.getName() 
      + " with a score of " + loser.getScore());
    }
  }
  private void playTheGame(Player player1, Player player2) {
    int deckSize = player1.size() + player2.size();
    System.out.println("deck = " + deckSize);
    
    for (int playNum = 0; playNum < deckSize / 2; playNum++) {
      Card card1 = player1.flip();
      Card card2 = player2.flip();
      
      if (card1.getRank() > card2.getRank()) {
        player1.incrementScore();
      }
      else {
        player2.incrementScore();
      }
    }
  }
  private void dealTheCards(Player player1, Player player2, Deck deck) {
    int deckSize = deck.size();
    for (int pos = 0; pos < deckSize; pos++){
      if(pos % 2 == 0) {
        player1.draw(deck);
      }
      else {
        player2.draw(deck);
      }
    } 
  }

  private void shuffleDeck(Deck deck) {
    deck.shuffle();
  }
  private Player findPlayer(List<String> names) {
    int pos = random.nextInt(names.size());
    String name = names.remove(pos);
    return new Player(name);
  }

}
