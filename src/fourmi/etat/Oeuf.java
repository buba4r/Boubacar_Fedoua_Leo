package fourmi.etat;

import fourmi.EtatDeveloppement;
import fourmi.Fourmi;

public class Oeuf extends EtatDeveloppement {

  Fourmi fourmi;

  private int VIE_OEUF = 3;

  public Oeuf(Fourmi fourmi) {
    super(fourmi);
    this.fourmi = fourmi;
    fourmi.getFourmiliere().addOeuf();
    this.setDureeDeVie(VIE_OEUF);

  }

  @Override
  public void evolution() {
    if (dureeDeVie.decrementer()) {
      fourmi.transformation(new Larve(fourmi));
      fourmi.getFourmiliere().supprOeuf();
    }

  }

  @Override
  public void action() {
    // TODO Auto-generated method stub
    // System.out.println("L'oeuf se repose");
    evolution();

  }

  @Override
  public boolean manger() {
    // TODO Auto-generated method stub
    return false;
  }

}
