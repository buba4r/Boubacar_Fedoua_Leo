package fourmi.etat;

import fourmi.EtatDeveloppement;
import fourmi.Fourmi;

public class Nymphe extends EtatDeveloppement {
  Fourmi fourmi;
  private final int VIE_LYMPHE = 20;

  public Nymphe(Fourmi fourmi) {
    super(fourmi);
    this.fourmi = fourmi;
    fourmi.getFourmiliere().addNymphe();
    this.setDureeDeVie(VIE_LYMPHE);
    fourmi.setPoids(-1);
  }

  @Override
  public void evolution() {
    if (dureeDeVie.decrementer()) {
      fourmi.transformation(new Adulte(fourmi));
      fourmi.getFourmiliere().supprNymphe();
    }

  }

  @Override
  public void action() {
    // TODO Auto-generated method stub
    // System.out.println("Nymphe se repose");
    evolution();

  }

  @Override
  public boolean manger() {
    // TODO Auto-generated method stub
    return false;
  }

}
