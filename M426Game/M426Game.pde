Gamefield gamefield;

void setup(){
  size(1600,900);
  MyPApplet.p = this;
  gamefield = new Gamefield();
}


void draw(){
  background(80);
  
  switch(gamefield.state){
    case "start":
      gamefield.showStartScreen();
      
    case "play":
      gamefield.drawfield();
  }
  
  
 
}



void keyPressed(){
  gamefield.action(key);
}
