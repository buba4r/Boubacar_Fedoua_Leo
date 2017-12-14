package fourmi.etat;

import java.util.Random;

import fourmi.EtatDeveloppement;
import fourmi.Fourmi;

public class Larve extends EtatDeveloppement {
  Fourmi fourmi;
  private int qteNourriture;

  private final int VIE_LARVE = 10;

  private final double POID = poidLarve((double) 4.5, (double) 8.0);

  /**
   * Constructeur de l'etat Larve.
   * 
   * @param fourmi
   *          l'etat connait sa fourmi
   */
  Larve(Fourmi fourmi) {
    super(fourmi);
    this.fourmi = fourmi;
    fourmi.getFourmiliere().addLarve();
    this.setDureeDeVie(VIE_LARVE);
    fourmi.setPoids(POID);

  }

  @Override
  public void evolution() {
    if (dureeDeVie.decrementer()) {
      fourmi.transformation(new Nymphe(fourmi));
      fourmi.getFourmiliere().supprLarve();
    }

  }

  public static int poidLarve(double pmin, double pmax) {

    Random rand = new Random();
    return (int) (rand.nextFloat() * (((double) pmax - (long) pmin)) + (double) pmin);

  }

  public void ajoutNourriture() {
    qteNourriture += 1;
    System.out.println("-Larve : j'ai " + this.qteNourriture + " nourritures");
  }

  @Override
  public void action() {
    // TODO Auto-generated method stub
    // System.out.println("Larve se repose");
    evolution();

  }

  @Override
  public boolean manger() {
    // TODO Auto-generated method stub
    return false;
  }

}
