import java.util.*;
import java.io.*;
import java.*;
class Score extends MyPApplet {

  int punkteSpieler;
  PrintWriter output;
  
  Score (){
    punkteSpieler = 0;
  }

   public void addPunkt(Player player){ 
      int multiplikator = player.xPos / 100;
      punkteSpieler = punkteSpieler + multiplikator;
      System.out.println("Punktestand: " + punkteSpieler);    
  }
  
  public void saveScore(){
    String words = String.valueOf(punkteSpieler);
    String[] list = p.split(words, ' ');

    // Writes the strings to a file, each on a separate line
    p.saveStrings("score.txt", list);
    
    p.fill(5);
    p.print("Output of paint method",100,100);
  
  }
  
}
