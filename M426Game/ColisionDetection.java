class ColisionDetection extends MyPApplet {
  
  public String playerOutOfBounds(int playerX) {
     if (playerX < 0) {
       return "gameover"; 
     }
     return "play";
    
  }
  
  
  
  
  
}
