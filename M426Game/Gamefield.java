class Gamefield extends MyPApplet {
  
  final Player player = new Player(30);
  Score score = new Score();
  String state = "start";
  
  void drawfield(){
      p.fill(10,255,32);
      player.show();
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
