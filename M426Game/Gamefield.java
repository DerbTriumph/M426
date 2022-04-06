class Gamefield extends MyPApplet {
  
  final Player player = new Player(30);
  Score score = new Score();
  String state = "start";
  
  
  void drawfield(){
    
    
    player.show();
  }
  
  void showStartScreen() {
    int bWidth = 200;
    int bHeight = 100;
    p.background(100,150,0);
    p.fill(255);
    p.noStroke();
    p.rect(800-bWidth/2, 450-bHeight/2, bWidth, bHeight, 20);
    p.fill(100,150,0);
    if (p.mousePressed && p.mouseX > 800-bWidth/2 && p.mouseX < 800+bWidth/2) {
      if (p.mousePressed && p.mouseY > 450-bHeight/2 && p.mouseY < 450+bHeight/2){
          state = "play";    
      }
    }
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
