package simulation;

import java.awt.Color;
import java.awt.Dimension;

import drawing.Oval;
import drawing.World;
import observeur.Observable;
import observeur.Observeur;
import territoire.Case;

public class Affichage implements Observeur {
  World jc;
  Dimension dimFourmi;
  Dimension dimProie;

  public Affichage() {
    jc = new World("Fourmilliere");
    jc.setBackground(Color.WHITE);
    jc.setPreferredSize(new Dimension(1000, 1000));
    dimFourmi = new Dimension(5, 5);
    dimProie = new Dimension(8, 8);
  }

  @Override

  public Oval actualiser(Observable o, Oval oval) {

    // TODO Auto-generated method stub
    Case maCase = (Case) o;
    if (maCase.containsProie()) {

      Oval representationProie = new Oval(new Color((int) (800)), maCase.getPoint(), dimProie);

      jc.add(representationProie);

      // jc.repaint();
      return representationProie;

    } else if (maCase.containsFourmi()) {
      Oval representationFourmi = new Oval(Color.blue, maCase.getPoint(), dimFourmi);
      jc.add(representationFourmi);

      // jc.repaint();
      return representationFourmi;
    } else {
      if (oval != null) {
        jc.remove(oval);

        // jc.repaint();
      }
    }
    return null;
  }

  public World getWorld() {
    return jc;
  }
}
