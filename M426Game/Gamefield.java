import java.util.*;
import java.awt.Rectangle;

class Gamefield extends MyPApplet {
  
  final Player player = new Player(30);
  Score score = new Score();
  ColisionDetection colision = new ColisionDetection();
  String state = "start";
  int interval = 90;
  
  void drawfield(int[][] gamefield){
      p.fill(10,255,32);
      player.show();
      String px = String.valueOf(player.xPos);
      //p.println(px);
      state = colision.playerOutOfBounds(player.xPos);
      
      
      
      if (interval <= 0){
          
          gamefield = moveField(gamefield);
          interval = 90;
      }else{
          drawFieldArray(gamefield);
      }
      interval--;
      //System.out.println("Interval Zähler: " + interval);
      
      
      
  }
  
  void action(char myKey){
    switch(myKey){
      case 'w':
      case 'W':
        player.yPos -= 5;
      break;
      
      case 's':
      case 'S':
        player.yPos += 5;
      break;
     
      case 'd':
      case 'D':
        player.xPos += 5;
      break;
     
      case 'a':
      case 'A':
        player.xPos -= 5;
      break;
     
      case 'p':
      case 'P':
        state = "pause";
      break;
     
      default: break;
    }
  }
  
  void actionStopped(char myKey){
    switch(myKey){
      case 'w':
      case 'W':
        p.key = 'n';
      break;
      
      case 's':
      case 'S':
        p.key = 'n';
      break;
     
      case 'd':
      case 'D':
        p.key = 'n';
      break;
     
      case 'a':
      case 'A':
        p.key = 'n';
      break;
     
      default: break;
    }
  }
  
  void createInitalField(int[] reiheY, int[][] gamefield){
    for(int u=0; u<3; u+=2){
        Random rand = new Random();
        int upperbound = 2; // befüllt(1) oder nicht befüllt(0)
        int upperboundPosFree = 10; // Plätze in einer Reihe Y
        int posFree1 = rand.nextInt(upperboundPosFree);
        int posFree2 = rand.nextInt(upperboundPosFree);
        
        for(int i = 0; i < 7; i++){
          if (i != posFree1 || i != posFree2){
            int wert = rand.nextInt(upperbound); 
              reiheY[i] = wert;
          }else{
              reiheY[i] = 0;
          }
        }
        
        // ReiheY in das Spielfeld übertragen
        for(int i = 0; i<9; i++){
           gamefield[13+u][i] = reiheY[i];
        }
     }
    
    for(int e = 0; e < 16; e++) {
         for(int r = 0; r < 9; r++) {
           System.out.print(gamefield[e][r]);
         }
         System.out.println("");
    }
      System.out.println("-------X-------");
  }
  
  void drawFieldArray(int[][] gamefield){
    int posY = 0;
     for(int e = 0; e < 9; e++) {
         for(int r = 0; r < 16; r++) {
           if(gamefield[r][e] == 1){
             p.fill(35);
             p.rect(r*100+2,posY+2,96,96,10);
           }
         }
         posY = posY + 100;
    }
  }
  
  int[][] moveField(int[][] gamefield){
    int[][] GamefieldNew = new int[16][9];
  
    for(int i=1; i<16; i++){
      
      for(int p=0; p<9; p++){
          GamefieldNew[i-1][p] = gamefield[i][p];
      }
    }
    
    // Neue ReiheY generieren und hinzufügen
    GamefieldNew[15][0] = 0;
    GamefieldNew[15][1] = 0;
    GamefieldNew[15][2] = 0;
    GamefieldNew[15][3] = 0;
    GamefieldNew[15][4] = 0;
    GamefieldNew[15][5] = 0;
    GamefieldNew[15][6] = 0;
    GamefieldNew[15][7] = 0;
    GamefieldNew[15][8] = 0;
    
     for(int e = 0; e < 16; e++) {
         for(int r = 0; r < 9; r++) {
           System.out.print(GamefieldNew[e][r]);
         }
         System.out.println("");
    }
    System.out.println("---------------------------");
    return GamefieldNew;
  }
  
  
  
}
