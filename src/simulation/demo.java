package simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import drawing.RectangleDrawable;
import fourmi.Fourmi;
import fourmilliere.Fourmiliere;
import proie.Proie;
import proie.etat.MortProie;
import territoire.Territoire;
import visiteur.RapportFourmiliere;

public class demo {

  public static void main(String[] args) {
    RapportFourmiliere rapportFourmiliere = new RapportFourmiliere();

    Affichage aff = new Affichage();
    Territoire territoire = new Territoire(500, 500, aff);
    Point pointFourmilliere = new Point(50, 50);

    ArrayList<Fourmi> fourmis;
    Iterator<Fourmi> itFourmis;

    Fourmiliere fourmiliere = territoire.nouvelleFourmiliere(pointFourmilliere);

    Proie proie1 = new Proie(territoire, 3.0);
    proie1.placerProie();
    territoire.getDeplacement().ajoutProie(proie1);

    Proie proie2 = new Proie(territoire, 3.0);
    proie2.placerProie();
    territoire.getDeplacement().ajoutProie(proie2);

    Proie proie3 = new Proie(territoire, 3.0);
    proie3.placerProie();
    territoire.getDeplacement().ajoutProie(proie3);

    Proie proie4 = new Proie(territoire, 3.0);
    proie4.placerProie();
    territoire.getDeplacement().ajoutProie(proie4);

    Fourmi fourmi;

    Dimension dim = new Dimension(10, 10);

    RectangleDrawable representationFourmilliere = new RectangleDrawable(Color.magenta, pointFourmilliere, dim);
    aff.getWorld().add(representationFourmilliere);
    aff.getWorld().open();
    Proie proie;
    // On met des proies dans le sotck
    for (int i = 0; i < 20; i++) {
      proie = new Proie(territoire, 3.0);
      proie.setEtat(new MortProie(proie));
      fourmiliere.getStock().deposerConsommable(proie);

    }

    while (true) {

      fourmiliere.applique(rapportFourmiliere);
      fourmis = fourmiliere.getFourmis();
      fourmis.get(0).action();// La reine pond
      fourmis.get(0).action();// La reine pond
      fourmis.get(0).action();// La reine pond

      itFourmis = fourmis.iterator();
      itFourmis.next();

      while (itFourmis.hasNext()) {

        fourmi = itFourmis.next();
        fourmi.action();

      }

      for (int j = 0; j < 10; j++) {
        territoire.getDeplacement().deplacer();
        aff.getWorld().repaint();
      }

    }

  }
}
