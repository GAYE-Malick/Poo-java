package games;
import players.*;
import java.util.*;

public class Nim extends AbstractGame
{
  protected int tasTotal = 0;
  protected int maxTire = 1;
  protected int tasActuel = 0;

  public Nim(int tasTotal, int maxTire, Player player1, Player player2)
  {

    super(player1, player2);
    this.tasTotal = tasTotal;
    this.maxTire = maxTire;
    this.tasActuel = this.tasTotal;
  }

  public int getInitialNbMatches()
  {

    return this.tasTotal;
  }


  public int getCurrentNbMatches()
  {

    return this.tasActuel;
  }

  @Override
  public void doExecute(int retire)
  {

    this.tasActuel = this.getCurrentNbMatches() - retire;
  }


  public ArrayList<Integer> validMoves()
  {

    ArrayList<Integer> res = new ArrayList<Integer>();
    int i = 0;
    while (i < this.getCurrentNbMatches() && i < this.maxTire)
    {
      i++;
      res.add(i);
    }
    return res;
  }

  public boolean isValid(int tentative)
  {
    for (int i : this.validMoves())
    {
      if (tentative == i)
      return true;
    }
    return false;
  }

  @Override
  public String situationToString()
  {
    if(this.tasActuel==0)
    {
      System.out.println("La partie est terminée : ");
      System.out.println("Le gagnant est " +getWinner().toString());
    }
    else
    {
      return "Il reste " + this.tasActuel +  " allumettes."
      + "C'est au tour du joueur  " + getCurrentPlayer().toString() + " de jouer.";
    }
    return "  ";
  }

  public String moveToString(int tasActuel)
  {
    return "";
  }

  public boolean isOver()
  {

    if (this.getCurrentNbMatches() == 0)
    return true;
    else
    return false;
  }
  public Player getWinner()
  {
    if (this.isOver())
    return super.getCurrentPlayer();
    else
    return null;
  }

  public Game copy()
  {
    Nim CopyNim = new Nim(this.getInitialNbMatches(), this.maxTire, super.player1, super.player2);
    CopyNim.tasActuel = this.getCurrentNbMatches();
    CopyNim.currentPlayer = super.getCurrentPlayer();
    return CopyNim;
  }
}
