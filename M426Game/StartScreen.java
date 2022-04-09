class StartScreen extends MyPApplet {
  
  public String showStartScreen() {
    int bWidth = 200;
    int bHeight = 100;
    p.background(100,150,0);
    
    p.noStroke();
    p.textSize(200);
    p.fill(255);
    p.text("GAME TITLE", 260,400);
    
    p.fill(255);
    p.rect(800-bWidth/2, 550-bHeight/2, bWidth, bHeight, 20);
    p.fill(100,150,0);
    
    p.textSize(50);
    p.fill(100,150,0);
    p.text("Play",750, 570);
    
    if (p.mousePressed && p.mouseX > 800-bWidth/2 && p.mouseX < 800+bWidth/2) {
      if (p.mousePressed && p.mouseY > 550-bHeight/2 && p.mouseY < 650+bHeight/2){
          return "play";    
      }
    }
    return "start";
    
  }
  

}
