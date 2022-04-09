class GameoverScreen extends MyPApplet {
  
  public String showGameoverScreen() {
    int bWidth = 200;
    int bHeight = 100;
    p.background(250,80,0);
    
    p.noStroke();
    p.textSize(200);
    p.fill(255);
    p.text("Game Over", 330,400);
    
    p.fill(255);
    p.rect(800-bWidth/2, 550-bHeight/2, bWidth, bHeight, 20);
    
    p.textSize(45);
    p.fill(250,80,0);
    p.text("Retry",745, 565);
    
    if (p.mousePressed && p.mouseX > 800-bWidth/2 && p.mouseX < 800+bWidth/2) {
      if (p.mousePressed && p.mouseY > 550-bHeight/2 && p.mouseY < 650+bHeight/2){
          return "play";    
      }
    }
    return "gameover";
    
  }
}
