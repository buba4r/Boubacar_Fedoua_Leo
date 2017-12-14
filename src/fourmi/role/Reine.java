package fourmi.role;

import fourmi.Fourmi;

public class Reine extends Role {

  double dureDeVieMin = 4;
  double dureDeVieMax = 10;
  Fourmi fourmi;

  public Reine(Fourmi fourmi) {
    super(fourmi);
    this.fourmi = fourmi;

  }

  public void ponte() {
    fourmi.getFourmiliere().naissanceFourmi();

  }

  public void action() {

    ponte();

  }

}
