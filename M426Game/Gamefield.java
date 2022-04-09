class Gamefield extends MyPApplet {
  
  final Player player = new Player(30);
  Score score = new Score();
  ColisionDetection colision = new ColisionDetection();
  String state = "start";
  
  void drawfield(){
      p.fill(10,255,32);
      player.show();
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
     
      default: break;
    }
  }
}
