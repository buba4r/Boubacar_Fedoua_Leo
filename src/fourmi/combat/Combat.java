package fourmi.combat;

public class Combat implements Combattant {

  @Override
  public void PerduCombat() {
    int point1 = 0;
    int point2 = 0;

    while (point1 == point2) {
      point1 = (int) (Math.random() * (10));
      point2 = (int) (Math.random() * (10));
    }

    if (point1 > point2) {
      System.out.println("point 2 a perdu Combat");
    } else {
      System.out.println("point 1 a perdu Combat");
    }

  }

}