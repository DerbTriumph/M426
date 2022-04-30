Gamefield gamefield;
StartScreen start;
PauseScreen pause;
GameoverScreen gameover;

  
void setup(){
  size(1600,900);
  frameRate(60);
  MyPApplet.p = this;
  gamefield = new Gamefield();
  start = new StartScreen();
  pause = new PauseScreen();
  gameover = new GameoverScreen();
  gamefield.createInitalField();
}


void draw(){
  background(80);
  

  gamefield.action(key);
  

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

void keyReleased(){
  gamefield.actionStopped(key);
}
