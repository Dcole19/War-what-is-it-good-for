package War;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {
  private List<String> values = List.of
      ("two", "three", "four", "five",
       "six", "seven", "eight", "nine",
       "ten", "jack", "queen", "king", "ace");
  
  private List<String> name = List.of
     ("Hearts", "Diamonds", "Spades", "Clubs");

  private List<Card> cards;
  
public Deck() {
  createDeck();
}

private void createDeck() {
  cards = new LinkedList<>();
  
  for(int valuePos = 0; valuePos < values.size(); valuePos++) {
    int rank = valuePos + 1;
    String value = values.get(valuePos);
    
  for (String name : name) {
    Card card = new Card(value, name, rank);
    cards.add(card);
   }
  }
 }

@Override
public String toString() {
  StringBuilder builder = new StringBuilder();
  
  builder.append("Deck:\n");
  
  for(Card card : cards) {
    builder.append(card).append("\n");
  }
  
  return builder.toString();
}

public void shuffle() {
  Random random = new Random();
  
  List<Card> temp = new LinkedList<>(cards);
  cards.clear();
  
  // not working running but not giving info... 
     // had to ad ! to code.
  while(!temp.isEmpty()) {
    int pos = random.nextInt(temp.size());
    cards.add(temp.remove(pos));
  }
  
  
}
public int size() {
  return cards.size();
}

public Card draw() {
  
  return cards.remove(0);
}
}
