package fourmi.etat;

import java.util.Random;

import fourmi.EtatDeveloppement;
import fourmi.Fourmi;
import fourmi.role.Role;
import proie.Proie;

import fourmi.role.*;

public class Adulte extends EtatDeveloppement {
  protected Fourmi fourmi;
  protected Role role;

  private final double VIE_MIN = 1.5;
  private final double VIE_MAX = 2.5;

  private final double POID_MIN = 1.5;
  private final double POID_MAX = 2;

  public Adulte(Fourmi fourmi) {

    super(fourmi);
    this.fourmi = fourmi;
    setDureeDeVie((VIE_MIN + (double) Math.random() * ((VIE_MAX - VIE_MIN))));
    fourmi.setPoids((POID_MIN + (double) Math.random() * ((POID_MAX - POID_MIN) + 1)));
    this.role = newRole(this);
  }

  public Role getRole() {
    return role;
  }

  public Role newRole(Adulte adulte) {
    Random ran = new Random();
    int ouvriere = ran.nextInt(10);
    // int soldat = ran.nextInt((25 - 20) + 1) + 20;

    if (getFourmi().getFourmiliere().getFourmis().size() < 1)
      return new Reine(fourmi);
    else if (ouvriere < 7) {
      return new Ouvriere(fourmi);
    } else
      return new Soldat(fourmi);
  }

  @Override
  public void evolution() {
    if (dureeDeVie.decrementer()) {
      fourmi.transformation(new Mort(fourmi));

    }

  }

  @Override
  public void action() {
    // TODO Auto-generated method stub
    role.action();

  }

  // La fourmi mange une proie du Stock de la fourmiliere.
  public boolean manger() {
    double appetit = 1;
    Proie proie;
    while (appetit >= 0) {
      proie = fourmi.getFourmiliere().getStock().retirerProieConsommable();
      if (proie != null) {
        appetit = fourmi.manger(proie.getPoid());
      } else {
        return false;
      }
    }
    return true;
  }

}
