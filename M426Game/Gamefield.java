import java.util.*;
class Gamefield extends MyPApplet {
  
  final Player player = new Player(30);
  Score score = new Score();
  ColisionDetection colision = new ColisionDetection();
  String state = "start";
  int[][] Gamefield = new int[16][9];
  int[] ReiheY = new int[9];
  
  void drawfield(){
      p.fill(10,255,32);
      player.show();
      createInitalField(ReiheY, Gamefield);
      String px = String.valueOf(player.xPos);
      p.println(px);
      state = colision.playerOutOfBounds(player.xPos);
  }
  
  
  
  void action(char myKey){
    switch(myKey){
      case 'w':
      case 'W':
        player.up();
      break;
      
      case 's':
      case 'S':
        player.down();
      break;
     
      case 'd':
      case 'D':
        player.right();
      break;
     
      case 'a':
      case 'A':
        player.left();
      break;
     
      case 'p':
      case 'P':
        state = "pause";
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
           System.out.println(gamefield[e][r]);
         }
    }
  }
}
