class Player extends Shape {

  Player(int distanz) {
    breite = 50;
    hoehe = 50;

    if (distanz >= 0) xPos = distanz;
    else xPos = p.width + distanz - breite;
    yPos = p.height/2-hoehe/2;

    ySpeed = 5;
    xSpeed = 5;
  }

  void show() {
    p.rect(xPos, yPos, breite, hoehe, 10);
  }

  void up() {
    if (yPos > ySpeed) yPos -= ySpeed;
  }

  void down() {
    if (yPos < p.height - hoehe - ySpeed) yPos += ySpeed;
  }

  void left() {
    xPos -= xSpeed;
  }

  void right() {
    if (xPos < p.width - breite - xSpeed) xPos += xSpeed;
  }

  int getLeft() {
    return xPos;
  }

  int getRight() {
    return xPos;
  }

  int getTop() {
    return yPos;
  }

  int getBootom() {
    return yPos + hoehe;
  }

  void pushPlayer() {
    int increment = xPos/100;
    xPos = increment * 100 + 50;
  }
}
