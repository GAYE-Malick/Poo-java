package plays;
import games.Game;

public class Orchestrator
{
  Game jeu;

  public Orchestrator(Game jeu)
  {
    this.jeu=jeu;
  }

  public void play()
  {
    while (this.jeu.isOver()==false)
    {
      System.out.println(this.jeu.situationToString());
      int action = this.jeu.getCurrentPlayer().chooseMove(this.jeu);
      this.jeu.execute(action);
      System.out.println("");
    }

    System.out.println(this.jeu.situationToString());
  }
}
