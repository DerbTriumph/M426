import java.util.*;
import java.awt.Rectangle;

class Gamefield extends MyPApplet {
  
  Player player;
  Score score = new Score();
  ColisionDetection colision;
  String state = "start";
  int interval = 60;
  boolean leerReihe = true;
  int[][] gamefield;
  
  public Gamefield() {
    this.player = new Player(30);
    this.score = new Score();
    this.gamefield = new int[16][9];
    this.colision = new ColisionDetection(this.gamefield);
  }
  
  void drawfield(){
      p.fill(10,255,32);
      //player.pushPlayer(colision.isPlayerPushed(player.xPos,player.yPos, gamefield));
      player.show();

      state = colision.playerOutOfBounds(player.xPos);
      
      //boolean hasToMove = false;
      //if (interval == 1) {
      //  //hasToMove = colision.isPlayerPushed(player.xPos, player.yPos);
      //}
 
  
       
      if (interval <= 0){
          //System.out.println("Spielfeld schieben");
     
          moveField(gamefield);
          int newPosition = colision.isPlayerOnBlock(player.xPos, player.yPos);
          if (newPosition > 0) {
            player.xPos = newPosition;
          }

  
          interval = 60;
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
        if (colision.rightAllowed(player.xPos, player.yPos)){
          player.xPos += 5;
        }     
      break;
     
      case 'a':
      case 'A':
        if (colision.leftAllowed(player.xPos, player.yPos)){
          player.xPos -= 5;
        }
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
  
  void createInitalField(){
    for(int u=0; u<3; u+=2){
        // ReiheY in das Spielfeld übertragen
        for(int i = 0; i<9; i++){
           gamefield[13+u][i] = generateYLine()[i];
        }
     }
    // Debug Spielfeld in Konsole ausgeben
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
  
  void moveField(int[][] gamefield){
    for(int i=1; i<16; i++){
      for(int p=0; p<9; p++){
          gamefield[i-1][p] = gamefield[i][p];
      }
    }
    
    // Nur bei jedem zweiten Aufruf Hindernisse einfügen
    if (leerReihe){
      // leere ReiheY in das Spielfeld übertragen
        for(int i = 0; i<9; i++){
           gamefield[15][i] = 0;
        }
        leerReihe = false;
    }else{
        // ReiheY in das Spielfeld übertragen
        for(int i = 0; i<9; i++){
           gamefield[15][i] = generateYLine()[i];
        }
        leerReihe = true;
    }
     
    // Debug Neues Array schreiben in Konsole
  //   for(int e = 0; e < 16; e++) {
  //       for(int r = 0; r < 9; r++) {
  //         System.out.print(gamefield[e][r]);
  //       }
  //       System.out.println("");
  //  }
  //  System.out.println("---------------------------");
  }
  
  
  
  
  int[] generateYLine(){
    // Neue Y Reihe generieren
    int[] NewReiheY = new int[9];
    Random rand = new Random();
    int upperbound = 2; // befüllt(1) oder nicht befüllt(0)
    int upperboundPosFree = 10; // Plätze in einer Reihe Y
    int posFree1 = rand.nextInt(upperboundPosFree);
    int posFree2 = rand.nextInt(upperboundPosFree);
        for(int i = 0; i < 9; i++){
          if (i != posFree1 || i != posFree2){
            int wert = rand.nextInt(upperbound); 
              NewReiheY[i] = wert;
          }else{
              NewReiheY[i] = 0;
          }
        }
  return NewReiheY;
  }
}
