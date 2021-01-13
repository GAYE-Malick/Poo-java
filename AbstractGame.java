package games;
import players.*;

public abstract class AbstractGame implements Game
{
  protected Player player1;
  protected Player player2;
  protected Player currentPlayer;


  public AbstractGame(Player player1, Player player2)
  {
    this.player1 = player1;
    this.player2 = player2;
    this.currentPlayer = this.player1;
  }

  protected abstract void doExecute(int turn);

  @Override
  public void execute(int turn)
  {

    doExecute(turn);
    if (this.getCurrentPlayer().equals(this.player1))
      this.currentPlayer = this.player2;
    else
      this.currentPlayer = this.player1;
  }

  @Override
  public Player getCurrentPlayer()
  {
    return this.currentPlayer;
  }
}
