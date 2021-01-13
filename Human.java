package players;

import java.util.Scanner;

import games.Game;
public class Human implements Player
{
  protected String name;
  protected Scanner a = new Scanner( System.in );
  public Human(String name,Scanner a)
  {
    this.name = name;
    this.a = a;
  }
  public String toString()
  {
    return this.name;
  }
  public int chooseMove(Game Jeu)
  {
    int c;
    for (int i=0;i < Jeu.validMoves().size();i++)
    {

      System.out.print("  "+Jeu.validMoves().get(i));
    }
    do
    {
      System.out.println ("\nchoisir un coup dans la liste suivante ");
      c= a.nextInt();
    } while (Jeu.isValid(c)==false);
    return c;
  }
}


