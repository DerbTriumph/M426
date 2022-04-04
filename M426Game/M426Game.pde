Gamefield gamefield;

void setup(){
  size(800,600);
  MyPApplet.p = this;
  gamefield = new Gamefield();
}


void draw(){
  background(80);
  gamefield.drawfield();
}



void keyPressed(){
  gamefield.action(key);
}
