package fourmi.role;

import fourmi.Fourmi;

public class Soldat extends Role {
  int x, y;

  public Soldat(Fourmi fourmi) {
    super(fourmi);
    this.fourmi = fourmi;
    fourmi.getFourmiliere().addSoldat();
    // TODO Auto-generated constructor stub
  }

  public void action() {
    // System.out.println("Le soldat protege");

  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

}
