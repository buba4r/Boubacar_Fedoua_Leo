package fourmi.deplacement;

import java.awt.Point;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import fourmi.Fourmi;
import proie.Proie;
import territoire.Territoire;

public class Deplacement {
  private Territoire territoire;
  private CopyOnWriteArrayList<Fourmi> fourmisEnDeplacement;
  private CopyOnWriteArrayList<Proie> proiesEnDeplacement;

  public Deplacement(Territoire territoire) {
    fourmisEnDeplacement = new CopyOnWriteArrayList<Fourmi>();
    proiesEnDeplacement = new CopyOnWriteArrayList<Proie>();
    this.territoire = territoire;

  }

  public void ajoutFourmi(Fourmi fourmi) {
    fourmisEnDeplacement.add(fourmi);
  }

  public void ajoutProie(Proie proie) {
    proiesEnDeplacement.add(proie);
  }

  public void enleverFourmi(Fourmi fourmi) {
    fourmisEnDeplacement.remove(fourmi);
  }

  public void enleverProie(Proie proie) {
    proiesEnDeplacement.remove(proie);
  }

  public void deplacer() {
    Iterator<Fourmi> itFourmis = fourmisEnDeplacement.iterator();
    Iterator<Proie> itProies = proiesEnDeplacement.iterator();
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    while (itFourmis.hasNext()) {

      deplacementFourmi(itFourmis.next());
    }
    while (itProies.hasNext()) {

      deplacementProie(itProies.next());
    }

  }

  public void deplacementFourmi(Fourmi fourmi) {
    boolean deplacement = false;
    Random rand = new Random();
    Point pointFourmi = fourmi.getPoint();
    // System.out.println(pointFourmi);
    territoire.getCase(pointFourmi).departFourmi(fourmi);
    int i;
    while (!deplacement) {
      i = rand.nextInt(4);
      switch (i) {
      case 0:
        if (((pointFourmi.x - 3) > 0)) {// gauche
          pointFourmi.x -= 3;
          deplacement = true;
        }

        break;
      case 1:
        if (((pointFourmi.x + 3) < territoire.getX())) {
          pointFourmi.x += 3;
          deplacement = true;
        } // droite
        break;

      case 2:
        if (((pointFourmi.y + 3) < territoire.getY())) {
          pointFourmi.y += 3;
          deplacement = true;
        } // bas
        break;

      case 3:
        if (((pointFourmi.y - 3) > 0)) {
          pointFourmi.y -= 3;
          deplacement = true;
        } // haut
        break;

      }
    }
    territoire.getCase(pointFourmi).arriveeFourmi(fourmi);

  }

  public void deplacementProie(Proie proie) {
    boolean deplacement = false;
    Random rand = new Random();
    Point pointProie = proie.getPoint();
    territoire.getCase(pointProie).departProie(proie);
    int i;
    while (!deplacement) {
      i = rand.nextInt(4);
      switch (i) {
      case 0:
        if (((pointProie.x - 3) > 0)) {// gauche
          pointProie.x -= 3;
          deplacement = true;
        }

        break;
      case 1:
        if (((pointProie.x + 3) < territoire.getX())) {
          pointProie.x += 3;
          deplacement = true;
        } // droite
        break;

      case 2:
        if (((pointProie.y + 3) < territoire.getY())) {
          pointProie.y += 3;
          deplacement = true;
        } // bas
        break;

      case 3:
        if (((pointProie.y - 3) > 0)) {
          pointProie.y -= 3;
          deplacement = true;
        } // haut
        break;

      }
    }
    territoire.getCase(pointProie).arriveeProie(proie);

  }

}
