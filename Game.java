package games;
import players.*;
import java.util.*;

public interface Game
{
  public void execute(int turn);
  public Player getCurrentPlayer();
  public boolean isValid(int turn);
  public ArrayList<Integer> validMoves();
  public Player getWinner();
  public boolean isOver();
  public String moveToString(int turn);
  public String situationToString();
  public Game copy();
}
