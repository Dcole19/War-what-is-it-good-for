package War;



public class Card {

  public String value;
  public String name;
  public int rank;
  
  
    public Card(String value, String name, int rank) {
    super();
    this.value = value;
    this.name = name;
    this.rank = rank;
    
    
    
  }


    @Override
    public String toString() {
      return value + " of " + name;
    }
    public int getRank() {
      return rank;
    }




  





 
  
  
  
  
  
  
}
