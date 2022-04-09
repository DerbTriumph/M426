Gamefield gamefield;
StartScreen start;
PauseScreen pause;

void setup(){
  size(1600,900);
  MyPApplet.p = this;
  gamefield = new Gamefield();
  start = new StartScreen();
  pause = new PauseScreen();
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
  }
  
  
 
}



void keyPressed(){
  gamefield.action(key);
}
