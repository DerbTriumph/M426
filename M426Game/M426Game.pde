Gamefield gamefield;
StartScreen start;
PauseScreen pause;
GameoverScreen gameover;
int[][] Gamefield = new int[16][9];
int[] ReiheY = new int[9];
  
void setup(){
  size(1600,900);
  frameRate(60);
  MyPApplet.p = this;
  gamefield = new Gamefield();
  start = new StartScreen();
  pause = new PauseScreen();
  gameover = new GameoverScreen();
  gamefield.createInitalField(ReiheY, Gamefield);
}


void draw(){
  background(80);
  
<<<<<<< HEAD
  gamefield.action(key);
  
=======
>>>>>>> d47396a4fc942f9b73984501143bcd7f417e574f
  switch(gamefield.state){
    case "start":
      gamefield.state = start.showStartScreen();
      break;
      
    case "play":
      gamefield.drawfield(Gamefield);
      gamefield.moveField(Gamefield);
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
