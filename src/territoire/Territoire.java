package territoire;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import fourmi.deplacement.Deplacement;
import fourmi.Fourmi;
import fourmi.combat.Combattant;
import fourmi.etat.Adulte;
import fourmi.role.Soldat;
import fourmilliere.Fourmiliere;
import simulation.Affichage;

public class Territoire {
  Deplacement deplacement;
  Affichage aff;
  private Map<Point, Case> grille;
  private ArrayList<Case> gril;
  private List<Fourmiliere> listeFourmiliere;
  private int dimensionX;
  private int dimensionY;
  // List<Proie> listeProie;
  // Gestionnaire gestionnaire;

  public Fourmiliere nouvelleFourmiliere(Point point) {

    Iterator<Fourmiliere> it = listeFourmiliere.iterator();

    while (it.hasNext()) {
      if (!it.next().getPoint().equals(point)) {
        return null;
      }
    }

    Case caseFourmiliere = new Case(point);
    caseFourmiliere.ajouterObserveur(aff);
    Fourmiliere nouvelleFourmiliere = new Fourmiliere(point, this);
    this.listeFourmiliere.add(nouvelleFourmiliere);
    Fourmi reineFourmiliere = new Fourmi(nouvelleFourmiliere);

    reineFourmiliere.transformation(new Adulte(reineFourmiliere));

    nouvelleFourmiliere.arriveeFourmi(reineFourmiliere);
    grille.put(point, caseFourmiliere);
    return nouvelleFourmiliere;

  }

  public Territoire(int dimX, int dimY, Affichage aff) {
    deplacement = new Deplacement(this);
    this.aff = aff;
    Case nouvelleCase;
    listeFourmiliere = new ArrayList<Fourmiliere>();
    grille = new HashMap<Point, Case>();
    dimensionX = dimX;
    dimensionY = dimY;
    for (int x = 0; x < dimX; x++) {
      for (int y = 0; y < dimY; y++) {
        Point nouveauPoint = new Point(x, y);
        nouvelleCase = new Case(nouveauPoint);
        nouvelleCase.ajouterObserveur(aff);
        grille.put(new Point(x, y), nouvelleCase);
      }
    }
  }

  public List<Fourmiliere> getFourmilieres() {
    return listeFourmiliere;
  }

  public Case getCase(Point point) {
    if (grille.containsKey(point)) {
      return grille.get(point);
    }
    return null;
  }

  public int getX() {
    return dimensionX;
  }

  public int getY() {
    return dimensionY;
  }

  public Map<Point, Case> getGrille() {
    return grille;
  }

  public Deplacement getDeplacement() {
    // TODO Auto-generated method stub

    return deplacement;

  }

  public int ajoutSoldat(Soldat soldat) {
    int verifier;
    for (Case UneCase : gril) {
      if (UneCase.getPoint().x == soldat.getX() && UneCase.getPoint().y == soldat.getY()) {
        verifier = UneCase.PositionCombattant((Combattant) soldat);
        return verifier;
      }
    }
    return 1;
  }

  public void suppressionSoldat(Soldat soldat) {
    for (Case UneCase : this.gril) {

      if (UneCase.getPoint().x == soldat.getX() && UneCase.getPoint().y == soldat.getY()) {
        UneCase.DeletePositionCombattant((Combattant) soldat);
      }
    }
  }

}
