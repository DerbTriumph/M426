class ColisionDetection extends MyPApplet {
  
  private int[][] gameField = null;
  
  public ColisionDetection(int[][] gameField){
    this.gameField = gameField;
  }
  
  public String playerOutOfBounds(int playerX) {
     if (playerX < 0) {
       return "gameover"; 
     }
     return "play";
  }
  
  int isPlayerOnBlock(int playerXabs, int playerYabs) {
    int playerXright = playerXabs + 50;
    int playerXfield = playerXright / 100;
    int playerYfield = playerYabs / 100;
    System.out.println("x: " + playerXfield);
    System.out.println("y: " + playerYfield);
    if (gameField[playerXfield][playerYfield] == 1 ) {
      int currentBlockabs = (playerXfield) * 100;
      //p.text(nextBlockXabs,50,50);
      if (playerXabs + 50 >= currentBlockabs) {
        return currentBlockabs-50;
      }
    }  
    return 0;
  }
  
  boolean rightAllowed(int playerXabs, int playerYabs) {
    int playerXfield = playerXabs / 100;
    int playerYfield = playerYabs / 100; 
    if (gameField[playerXfield+1][playerYfield] == 1) {
      int nextBlockXabs = (playerXfield + 1) * 100;
      p.text(nextBlockXabs,50,50);
      if (nextBlockXabs - (playerXabs + 50) <= 0) {
        return false;
      }
    }  
    return true;
  }
  
  boolean leftAllowed(int playerXabs, int playerYabs) {
    int playerXfield = playerXabs / 100;
    int playerYfield = playerYabs / 100; 
    if (gameField[playerXfield-1][playerYfield] == 1) {      int prevBlockXabs = (playerXfield - 1) * 100;
      //p.text(nextBlockXabs,50,50);
      if (playerXabs - (prevBlockXabs + 100)<= 0) {
        return false;
      }
    }  
    return true;
    
  }
  
  
  
  
  
  
}
