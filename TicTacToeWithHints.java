package games;
import players.*;
import java.util.*;

public class TicTacToeWithHints extends TicTacToe
{

  public TicTacToeWithHints(Player player1, Player player2)
  {
    super(player1, player2);
  }

  public ArrayList<Integer> hints()
  {
    ArrayList<Integer> res = new ArrayList<Integer>();
    for (Integer i : super.validMoves())
    {
      Game jeuPrime = super.copy();
      jeuPrime.execute(i);
      if (jeuPrime.getWinner() != null &&
      jeuPrime.getWinner().equals(jeuPrime.getCurrentPlayer()) || jeuPrime.getWinner() == null)
      {
        for (Integer j : jeuPrime.validMoves())
        {
          Game jeu = jeuPrime.copy();
          jeu.execute(j);
          if (jeu.getWinner() != null &&
          !jeu.getWinner().equals(jeu.getCurrentPlayer())
           && !res.contains(j))
            res.add(j);
        }
      }
    }
    Collections.sort(res);
    return res;
  }

  @Override
  public String situationToString()
  {
    String representation = "";
    if (!super.isOver() && this.hints().size() > 0)
    {
      representation += "Attention : ";
      for (Integer value : this.hints())
      {
        representation += super.moveToString(value);
        representation += " ";
      }
      representation += System.lineSeparator();
    }
    representation += super.situationToString();
    return representation;
  }
}
