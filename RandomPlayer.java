package players;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import games.Game;

public class RandomPlayer implements Player
{

	protected Random aleatoire;

	public RandomPlayer(Random aleatoire)
	{
		this.aleatoire = aleatoire;
	}



	public int chooseMove(Game object)
	{
		ArrayList<Integer> validMoves = object.validMoves();

		int randomIndex = aleatoire.nextInt(validMoves.size());


		return validMoves.get(randomIndex);
	}

	@Override

	public String toString()
	{
		return "Joueur aleatoire numero " + this.hashCode();
	}

}
