class Gamefield extends MyPApplet {
  
  final Player player = new Player(30);
  Score score = new Score();
  
  
  void drawfield(){
    
    
    
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
     
      default: break;
    }
  }
}
