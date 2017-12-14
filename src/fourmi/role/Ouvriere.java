package fourmi.role;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import fourmi.Fourmi;
import fourmi.etat.Larve;
import fourmilliere.Stock;
import proie.Proie;

public class Ouvriere extends Role {
  Larve larve;
  private int nbNourriture;
  private static int nbMaxOuvrierDehors = 20;
  private static int nbOuvrierDehors = 0;
  Proie proie;
  Fourmi fourmi;
  Point point;

  public Ouvriere(Fourmi fourmi) {
    super(fourmi);
    this.fourmi = fourmi;
    this.point = fourmi.getFourmiliere().getPoint();
    fourmi.getFourmiliere().addOuvrier();
    // TODO Auto-generated constructor stub
  }

  // La fourmi mange une proie du Stock de la fourmiliere.

  public void action() {
    // System.out.println("L'ouvriere travaille");
    if (!fourmi.getEtatDeveloppement().manger()) {

      if (nbOuvrierDehors < nbMaxOuvrierDehors) {
        System.out.println("Le Stock de nourriture est vide");
        sortir();
        nbOuvrierDehors++;
      }
    }

  }

  public void recolterNouriture(Larve larve) {
    Set<Stock> stocks = new HashSet<Stock>();
    for (Stock s : stocks) {
      s.deposerConsommable(proie);
      double besoin = fourmi.getAppetit().getFaim();
      fourmi.getAppetit().manger(besoin);
    }
  }

  public void ajoutNourriture() {
    nbNourriture += 1;
    this.larve.ajoutNourriture();
    System.out.println("-Ouvriere : j'ai " + this.nbNourriture + " Nourritures");
  }

  public void sortir() {
    int x = (int) point.getX() + 5;
    int y = (int) point.getY();
    fourmi.setPoint(x, y);

    fourmi.getTerritoire().getDeplacement().ajoutFourmi(fourmi);
    fourmi.getTerritoire().getCase(new Point(x, y)).arriveeFourmi(fourmi);

    // fourmi.getFourmiliere().getFourmis().remove(fourmi);
  }

}
