Gamefield gamefield;
StartScreen start;
PauseScreen pause;
GameoverScreen gameover;

void setup(){
  size(1600,900);
  MyPApplet.p = this;
  gamefield = new Gamefield();
  start = new StartScreen();
  pause = new PauseScreen();
  gameover = new GameoverScreen();
}


void draw(){
  background(80);
  
  println(gamefield.state);
  
  switch(gamefield.state){
    case "start":
      gamefield.state = start.showStartScreen();
      break;
      
    case "play":
      gamefield.drawfield();
      break;
      
     case "pause":
      gamefield.state = pause.showPauseScreen();
      break;
      
     case "gameover":
       gamefield.state = gameover.showGameoverScreen();
       break;
  }
  
  
 
}



void keyPressed(){
  gamefield.action(key);
}
