Gamefield gamefield;
StartScreen start;
PauseScreen pause;
GameoverScreen gameover;
Score score;
  
void setup(){
  size(1600,900);
  frameRate(60);
  MyPApplet.p = this;
  gamefield = new Gamefield();
  start = new StartScreen();
  pause = new PauseScreen();
  gameover = new GameoverScreen();
  gamefield.createInitalField();
  score = new Score();
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
       score.saveScore();
       gamefield.state = gameover.showGameoverScreen();
       
       break;
  }
}

void keyReleased(){
  gamefield.actionStopped(key);
}
