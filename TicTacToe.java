package games;
import players.*;
import java.util.*;

public class TicTacToe extends AbstractGame
{
  public Player plateau[][];

  public TicTacToe(Player player1, Player player2)
  {

    super(player1, player2);
    this.plateau = new Player[3][3];
  }

  @Override
  public void doExecute(int numero)
  {
    this.plateau[numero / 3][numero % 3] = super.getCurrentPlayer();
  }
  @Override
  public ArrayList<Integer> validMoves()
  {
    ArrayList<Integer> res = new ArrayList<Integer>();
    int i = -1;
    while (i < 8)
    {
      i++;
      if (this.isValid(i))
        res.add(i);
    }
    return res;
  }
  @Override
  public boolean isValid(int numero)
  {

    if (numero < 0 || numero > 8)
    return false;
    else if (this.plateau[numero / 3][numero % 3] == null)
    return true;
    else
    return false;
  }
  @Override
   public String toString()
   {

     String retour="";
     for (int ligne=0;ligne<3;ligne++)
     {
       for (int colonne=0;colonne<3;colonne++)
       {
         if(plateau[ligne][colonne]==this.player1)
         retour+=" X  " ;
         else if(plateau[ligne][colonne]==this.player2)
         retour+=" O  ";
         else retour+=" . ";
       }
       retour+="\n";
     }
     return retour;
   }
  @Override
  public String situationToString()
  {
    String retour;
      if (this.isOver())
      {
        retour="La partie est terminée.\n";
        Player gagnant = this.getWinner();
        if(gagnant==null)
        retour+="C'est un match null.\n";
        else
        retour+="Le gagnant est le joueur " + gagnant.toString()+ ".\n";
      }
      else
      {
        retour= "C'est au tour du joueur " + getCurrentPlayer().toString() + " de jouer. \n";
      }
      retour+=this.toString();
      return retour;
      }

  public String moveToString(int numero)
  {

    return "(" + (numero / 3 + 1) + "," + (numero % 3 + 1) + ")";
  }

  public boolean isOver()
  {
    if (this.getWinner() != null) return true;
    int i = -1;
    while (i < 8)
    {
      i++;
      if (this.plateau[i / 3][i % 3] == null)
        return false;
    }
    return true;
  }

  public boolean wins(Player player, int row, int column, int deltaRow, int deltaColumn)
  {
    boolean boolWins = false;
    if (this.plateau[row][column] != null && this.plateau[row][column].equals(player))
      if (this.plateau[row + deltaRow][column + deltaColumn] != null && this.plateau[row + deltaRow][column + deltaColumn].equals(player))
        if (this.plateau[row + 2 * deltaRow][column + 2 * deltaColumn] != null && this.plateau[row + 2 * deltaRow][column + 2 * deltaColumn].equals(player))
          boolWins = true;
    return boolWins;
  }

  public Player getWinner()
  {

    int i = -1;
    while (i < 8)
    {
      i++;
      int j = -2;
      while(j < 1)
      {
        j++;
        int k = -2;
        while (k < 1)
        {
          k++;
          if (i / 3 + j > -1 && i / 3 + j < 3 && i % 3 + k > -1 && i % 3 + k < 3)
            if (i / 3 + 2 * j > -1 && i / 3 + 2 * j < 3 && i % 3 + 2 * k > -1 && i % 3 + 2 * k < 3)
              if (j != 0 || k != 0)
              {
                if (this.wins(super.player1, i / 3, i % 3, j, k)) return super.player1;
                if (this.wins(super.player2, i / 3, i % 3, j, k)) return super.player2;
              }
        }
      }
    }
    return null;
  }

  public Game copy()
  {
    TicTacToe CopyTTT = new TicTacToe(super.player1, super.player2);
    int i = -1;
    while (i < 2) {
      ++i;
      int j = -1;
      while (j < 2) {
        ++j;
        CopyTTT.plateau[i][j] = this.plateau[i][j];
      }
    }
    CopyTTT.currentPlayer = super.getCurrentPlayer();
    return CopyTTT;
  }
/*
  @Override
  public boolean equals(Object o) {

    if (o == null || !(o instanceof TicTacToe)) {
      return false;
    } else {
      TicTacToe resCopy = (TicTacToe) o;
      boolean tabEquals = true;
      int i = -1;
      while (i < 2) {
        ++i;
        int j = -1;
        while (j < 2) {
          ++j;
          if (this.tabPlayer[i][j] != null && resCopy.tabPlayer[i][j] == null ||
          this.tabPlayer[i][j] == null && resCopy.tabPlayer[i][j] != null ||
          this.tabPlayer[i][j] != null && !this.tabPlayer[i][j].equals(resCopy.tabPlayer[i][j])) {
            tabEquals = false;
          }
        }
      }
      return super.currentPlayer.equals(resCopy.currentPlayer)
      && super.player1.equals(resCopy.player1)
      && super.player2.equals(resCopy.player2)
      && tabEquals;
    }
  }

  /**
   * makes a new game's hash
   * @return integer representating new game's hash
   */
  /*@Override
  public int hashCode() {
    return Objects.hash(super.player1, super.player2, super.currentPlayer, Arrays.deepHashCode(this.tabPlayer));
  }*/
}
