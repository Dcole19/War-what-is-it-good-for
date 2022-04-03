package War;

import java.util.LinkedList;
import java.util.List;

public class Player {
  private String name;
  private List<Card> hand = new LinkedList<>();
  private int score;
  
  public Player(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  

  public Player(String name, List<Card> hand, int score) {
    super();
    this.name = name;
    this.hand = hand;
    this.score = score;
  }
  public void draw(Deck deck) {
    hand.add(deck.draw());
      
    
    
  }
  
public int size() {
  return hand.size();
}
public Card flip() {
  return hand.remove(0);
}
public void incrementScore() {
  score = getScore() + 1;
  
}
public int getScore() {
  return score;
}
}


