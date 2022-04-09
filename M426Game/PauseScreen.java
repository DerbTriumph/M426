class PauseScreen extends MyPApplet {
  
  public String showPauseScreen() {
    int bWidth = 200;
    int bHeight = 100;
    p.background(0,100,150);
    
    p.noStroke();
    p.textSize(200);
    p.fill(255);
    p.text("Pause", 530,400);
    
    p.fill(255);
    p.rect(800-bWidth/2, 550-bHeight/2, bWidth, bHeight, 20);
    p.fill(0,100,150);
    
    p.textSize(45);
    p.fill(0,100,150);
    p.text("Resume",725, 565);
    
    if (p.mousePressed && p.mouseX > 800-bWidth/2 && p.mouseX < 800+bWidth/2) {
      if (p.mousePressed && p.mouseY > 550-bHeight/2 && p.mouseY < 650+bHeight/2){
          return "play";    
      }
    }
    return "pause";
    
  }
}
