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
  
  public boolean isPlayerPushed(int playerX, int playerY) {
    playerX = playerX / 100;
    playerY = playerY / 100;
    if (gameField[playerX+1][playerY] == 1) {
      return true;
    } else {
      return false; 
    }
       
  }
  
  boolean rightAllowed(int playerX, int playerY) {
    playerX = playerX / 100;
    playerY = playerY / 100;
    int nextBlockXPos = (playerX + 1) * 100;
    if (gameField[playerX+1][playerY] == 1) {
      if (nextBlockXPos - (playerX + 50) <= 0) {
        return false;
      }
    }
    return true;
  }
  
  
  
  
  
  
}
